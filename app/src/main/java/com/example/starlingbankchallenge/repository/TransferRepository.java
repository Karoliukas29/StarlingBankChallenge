package com.example.starlingbankchallenge.repository;

import com.example.starlingbankchallenge.model.transfer.TransferRequest;
import com.example.starlingbankchallenge.model.transfer.TransferResponse;
import com.example.starlingbankchallenge.network.services.TransferRetrofitService;
import javax.inject.Inject;
import javax.inject.Singleton;
import io.reactivex.Single;

@Singleton
public class TransferRepository {
    TransferRetrofitService transferRetrofitService;

    @Inject
    public TransferRepository(TransferRetrofitService transferRetrofitService) {
        this.transferRetrofitService = transferRetrofitService;
    }

    public Single<TransferResponse> createTransfer(String token, String accountUid, String savingsGoalUid, String transferUid, TransferRequest request){
        return transferRetrofitService.createTransaction(token,accountUid,savingsGoalUid,transferUid, request);
    }
}
