package com.example.starlingbankchallenge.repository;

import com.example.starlingbankchallenge.model.savings.SavingsGoalRequest;
import com.example.starlingbankchallenge.model.savings.SavingsGoalResponse;
import com.example.starlingbankchallenge.network.services.SavingGoalRetrofitService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import retrofit2.http.Header;

@Singleton
public class SavingsGoalRepository {
    private SavingGoalRetrofitService savingGoalRetrofitService;

    @Inject
    public SavingsGoalRepository( SavingGoalRetrofitService savingGoalRetrofitService) {
        this.savingGoalRetrofitService = savingGoalRetrofitService;
    }

    public Single<SavingsGoalResponse> createSavingGoal(String token, String accountUid, SavingsGoalRequest request){
        return savingGoalRetrofitService.createSavingGoal(token,accountUid, request);
    }
}
