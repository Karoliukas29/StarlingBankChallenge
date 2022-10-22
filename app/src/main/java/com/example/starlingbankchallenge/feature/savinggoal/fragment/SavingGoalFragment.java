package com.example.starlingbankchallenge.feature.savinggoal.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.starlingbankchallenge.base.BaseFragment;
import com.example.starlingbankchallenge.databinding.FragmentSavingGoalBinding;


public class SavingGoalFragment extends BaseFragment<FragmentSavingGoalBinding> {

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
    }

    private void initView() {

    }
}