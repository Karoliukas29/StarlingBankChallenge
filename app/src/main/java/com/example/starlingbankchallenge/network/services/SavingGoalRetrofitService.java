package com.example.starlingbankchallenge.network.services;

import com.example.starlingbankchallenge.model.savings.SavingsGoalRequest;
import com.example.starlingbankchallenge.model.savings.SavingsGoalResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface SavingGoalRetrofitService {
    @PUT("/api/v2/account/{accountUid}/savings-goals")
    Single<SavingsGoalResponse> createSavingGoal(@Header("Authorization") String token, @Path("accountUid") String accountUid, @Body SavingsGoalRequest request);
}
