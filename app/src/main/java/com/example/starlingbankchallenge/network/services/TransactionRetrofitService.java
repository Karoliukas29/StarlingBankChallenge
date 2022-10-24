package com.example.starlingbankchallenge.network.services;

import com.example.starlingbankchallenge.model.transactions.TransactionResponse;
import com.example.starlingbankchallenge.model.transactions.TransactionResponseItem;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TransactionRetrofitService {

    @GET("/api/v2/feed/account/{accountUid}/category/{categoryUid}")
    Single<List<TransactionResponseItem>> getTransactions(@Header("Authorization") String token, @Path("accountUid") String accountUid, @Path("categoryUid") String categoryUid,
                                                          @Query("changesSince") String changesSince);
}
