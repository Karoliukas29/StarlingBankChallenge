package com.example.starlingbankchallenge.network.services;

import com.example.starlingbankchallenge.model.savings.SavingsGoalResponse;
import com.example.starlingbankchallenge.model.spaces.SpacesResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface SpacesRetrofitService {
    @GET("/api/v2/account/{accountUid}/spaces")
    Single<SpacesResponse> getSpaces(@Header("Authorization") String token, @Path("accountUid") String accountUid);
}

