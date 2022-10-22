package com.example.starlingbankchallenge.feature;

import android.os.Bundle;
import com.example.starlingbankchallenge.base.BaseActivity;
import com.example.starlingbankchallenge.databinding.ActivityMainBinding;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected ActivityMainBinding getBinding() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        return binding;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}