package com.example.starlingbankchallenge.network.services;

import com.example.starlingbankchallenge.model.AccountsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface AccountRetrofitService {
    @GET("api/v2/accounts")
    Single<AccountsResponse> getAccounts();

}