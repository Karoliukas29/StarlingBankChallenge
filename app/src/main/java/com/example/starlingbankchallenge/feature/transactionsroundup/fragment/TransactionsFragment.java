package com.example.starlingbankchallenge.feature.transactionsroundup.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.starlingbankchallenge.base.BaseFragment;
import com.example.starlingbankchallenge.databinding.FragmentTransactionsBinding;
import com.example.starlingbankchallenge.feature.transactionsroundup.adapter.TransactionsAdapter;
import com.example.starlingbankchallenge.feature.transactionsroundup.viewmodel.AccountViewModel;
import com.example.starlingbankchallenge.model.account.AccountsItem;
import com.example.starlingbankchallenge.model.transactions.TransactionResponse;
import com.example.starlingbankchallenge.network.base.StateData;
import com.example.starlingbankchallenge.utilities.AppPreference;
import com.example.starlingbankchallenge.utilities.Const;

import dagger.hilt.android.AndroidEntryPoint;
import timber.log.Timber;

@AndroidEntryPoint
public class TransactionsFragment extends BaseFragment<FragmentTransactionsBinding> {
    private AccountViewModel accountViewModel;
    private String accountUid, categoryUid, changesSince;
    private TransactionsAdapter transactionsAdapter;
    private static final String TAG = "TransactionsFragment";

    @Override
    public FragmentTransactionsBinding getFragmentBinding(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentTransactionsBinding.inflate(inflater, container, false);
        return binding;
    }

    public TransactionsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppPreference.init(getContext());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        observeData();
        observeState();
    }

    private void initView() {
        accountViewModel = new ViewModelProvider(requireActivity()).get(AccountViewModel.class);
        transactionsAdapter = new TransactionsAdapter(getContext());
    }

    //observing live data and saving it in share preferences
    private void observeData(){
        accountViewModel.loadAccounts().observe(getViewLifecycleOwner(), accountsResponse -> {
            for (AccountsItem accountsItem : accountsResponse.getAccounts()) {
                AppPreference.write(Const.ACCOUNT_USER_ID, accountsItem.getAccountUid());
                AppPreference.write(Const.DEFAULT_CATEGORY, accountsItem.getDefaultCategory());
                AppPreference.write(Const.CREATED_AT, accountsItem.getCreatedAt());
            }
        });
        accountUid = AppPreference.read(Const.ACCOUNT_USER_ID, "");
        categoryUid = AppPreference.read(Const.DEFAULT_CATEGORY, "");
        changesSince = AppPreference.read(Const.CREATED_AT, "");

        accountViewModel.loadTransactions(accountUid, categoryUid, changesSince).observe(getViewLifecycleOwner(), transactionResponse -> {
            binding.recyclerviewTransactions.setHasFixedSize(true);
            binding.recyclerviewTransactions.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
            transactionsAdapter = new TransactionsAdapter(getContext());
            transactionsAdapter.submitList(transactionResponse.getFeedItems());
            binding.recyclerviewTransactions.setAdapter(transactionsAdapter);
        });
    }


    private void observeState() {
        accountViewModel.stateLiveData.observe(getViewLifecycleOwner(), this::handleStatus);
    }

    private void handleStatus(@NonNull StateData<TransactionResponse> transactionResponse) {
        Timber.tag(TAG).d("handleStatus: %s", transactionResponse);
        switch (transactionResponse.getStatus()) {
            case SUCCESS:
                Timber.tag(TAG).i("handleStatus: " + " SUCCESS");
                TransactionResponse  transactionResponseItemList = transactionResponse.getData();
                if (transactionResponseItemList == null || transactionResponseItemList.getFeedItems().size() == 0) {
                    Timber.tag(TAG).i("handleStatus: " + "the data is nul");
                } else {
                    startLoading();
                }
                break;
            case ERROR:
                Throwable e = transactionResponse.getError();
                assert e != null;
                Timber.tag(TAG).i("handleStatus: %s", e.getMessage());
                dismissLoading();
                break;
            case LOADING:
                Timber.tag(TAG).i("handleStatus: " + " LOADING");
                startLoading();
                break;
            case COMPLETE:
                Timber.tag(TAG).i("handleStatus: " + " COMPLETE");
                dismissLoading();
                break;
        }
    }

    private void startLoading() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    private void dismissLoading() {
        binding.progressBar.setVisibility(View.GONE);
    }
}