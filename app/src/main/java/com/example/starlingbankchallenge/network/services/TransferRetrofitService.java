package com.example.starlingbankchallenge.network.services;

import com.example.starlingbankchallenge.model.transfer.TransferRequest;
import com.example.starlingbankchallenge.model.transfer.TransferResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TransferRetrofitService {
    @PUT("/api/v2/account/{accountUid}/savings-goals/{savingsGoalUid}/add-money/{transferUid}")
    Single<TransferResponse> createTransaction(@Header("Authorization") String token,
                                               @Path("accountUid") String accountUid,
                                               @Path("savingsGoalUid") String savingsGoalUid,
                                               @Path("transferUid") String transferUid,
                                               @Body TransferRequest request);
}
