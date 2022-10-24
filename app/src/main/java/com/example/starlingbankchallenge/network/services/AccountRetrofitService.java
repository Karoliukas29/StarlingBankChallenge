package com.example.starlingbankchallenge.network.services;

import com.example.starlingbankchallenge.model.account.AccountsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface AccountRetrofitService {
    //get accounts details like accountUID, and we have to pass the token from out starling bank developer account
    @GET("api/v2/accounts")
    Single<AccountsResponse> getAccounts(@Header("Authorization") String token);

}