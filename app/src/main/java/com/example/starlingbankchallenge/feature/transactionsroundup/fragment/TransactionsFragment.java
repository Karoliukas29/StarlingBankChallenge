package com.example.starlingbankchallenge.feature.transactionsroundup.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.starlingbankchallenge.base.BaseFragment;
import com.example.starlingbankchallenge.databinding.FragmentTransactionsBinding;


public class TransactionsFragment extends BaseFragment<FragmentTransactionsBinding> {

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