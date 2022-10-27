package com.example.starlingbankchallenge.feature.savinggoal.fragment;

import android.annotation.SuppressLint;
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
import com.example.starlingbankchallenge.databinding.FragmentSavingGoalBinding;
import com.example.starlingbankchallenge.feature.savinggoal.adapter.SavingsAdapter;
import com.example.starlingbankchallenge.feature.savinggoal.viewmodel.SavingsViewModel;
import com.example.starlingbankchallenge.feature.transactionsroundup.viewmodel.AccountViewModel;
import com.example.starlingbankchallenge.model.spaces.SpacesResponse;
import com.example.starlingbankchallenge.model.transactions.TransactionResponse;
import com.example.starlingbankchallenge.network.base.StateData;
import com.example.starlingbankchallenge.utilities.AppPreference;
import com.example.starlingbankchallenge.utilities.Const;

import dagger.hilt.android.AndroidEntryPoint;
import timber.log.Timber;

@AndroidEntryPoint
public class SavingGoalFragment extends BaseFragment<FragmentSavingGoalBinding> {
    private SavingsViewModel savingsViewModel;
    private SavingsAdapter savingsAdapter;
    private String accountUid;
    private static final String TAG = "SavingsFragment";

    @Override
    public FragmentSavingGoalBinding getFragmentBinding(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentSavingGoalBinding.inflate(inflater, container, false);
        return binding;
    }

    public SavingGoalFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        observeData();
        observeState();
    }

    private void initView() {
        savingsViewModel = new ViewModelProvider(requireActivity()).get(SavingsViewModel.class);
        savingsAdapter = new SavingsAdapter(requireContext());
        accountUid = AppPreference.read(Const.ACCOUNT_USER_ID, "");
    }

    //observing live data and saving it in share preferences
    @SuppressLint("SetTextI18n")
    private void observeData(){
        savingsViewModel.loadSpaces(accountUid).observe(getViewLifecycleOwner(), spacesResponse -> {
            AppPreference.write(Const.SAVINGS_GOAL_UID, spacesResponse.getSavingsGoals().get(0).getSavingsGoalUid());

            binding.recyclerviewSavings.setHasFixedSize(true);
            binding.recyclerviewSavings.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
            savingsAdapter = new SavingsAdapter(getContext());
            savingsAdapter.submitList(spacesResponse.getSavingsGoals());
            binding.recyclerviewSavings.setAdapter(savingsAdapter);
        });
    }

    private void observeState() {
        savingsViewModel.stateLiveData.observe(getViewLifecycleOwner(), this::handleStatus);
    }

    private void handleStatus(@NonNull StateData<SpacesResponse> spacesResponseStateData) {
        Timber.tag(TAG).d("handleStatus: %s", spacesResponseStateData);
        switch (spacesResponseStateData.getStatus()) {
            case SUCCESS:
                Timber.tag(TAG).i("handleStatus: " + " SUCCESS");
                SpacesResponse  spacesResponse = spacesResponseStateData.getData();
                if (spacesResponse == null || spacesResponse.getSavingsGoals().size() == 0) {
                    Timber.tag(TAG).i("handleStatus: " + "the data is nul");
                } else {
                    startLoading();
                }
                break;
            case ERROR:
                Throwable e = spacesResponseStateData.getError();
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
        binding.progressBarSavings.setVisibility(View.VISIBLE);
    }

    private void dismissLoading() {
        binding.progressBarSavings.setVisibility(View.GONE);
    }
}