package com.example.starlingbankchallenge.repository;

import com.example.starlingbankchallenge.model.transactions.TransactionResponse;
import com.example.starlingbankchallenge.network.services.TransactionRetrofitService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class TransfersRepository {
    private TransactionRetrofitService transactionRetrofitService;

    @Inject
    public TransfersRepository(TransactionRetrofitService transactionRetrofitService) {
        this.transactionRetrofitService = transactionRetrofitService;
    }

    public Single<TransactionResponse> getTransactions(String token, String accountUid, String categoryUid, String changesSince){
        return transactionRetrofitService.getTransactions(token, accountUid, categoryUid, changesSince);
    }
}
