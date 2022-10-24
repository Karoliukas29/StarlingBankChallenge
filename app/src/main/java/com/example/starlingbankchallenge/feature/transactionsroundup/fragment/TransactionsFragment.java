package com.example.starlingbankchallenge.feature.transactionsroundup.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.starlingbankchallenge.base.BaseFragment;
import com.example.starlingbankchallenge.databinding.FragmentTransactionsBinding;
import com.example.starlingbankchallenge.feature.transactionsroundup.viewmodel.AccountViewModel;
import com.example.starlingbankchallenge.model.account.AccountsItem;
import com.example.starlingbankchallenge.utilities.AppPreference;
import com.example.starlingbankchallenge.utilities.Const;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TransactionsFragment extends BaseFragment<FragmentTransactionsBinding> {
    private AccountViewModel accountViewModel;

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
        if (getArguments() != null) {

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        observeData();
    }


    private void initView() {
        accountViewModel = new ViewModelProvider(requireActivity()).get(AccountViewModel.class);
    }
    //observing live data and saving it in share preferences
    private void observeData(){
        accountViewModel.loadAccounts().observe(getViewLifecycleOwner(), accountsResponse -> {
            for (AccountsItem accountsItem : accountsResponse.getAccounts()) {
                AppPreference.write(Const.ACCOUNT_USER_ID, accountsItem.getAccountUid());

            }
        });

    }


}