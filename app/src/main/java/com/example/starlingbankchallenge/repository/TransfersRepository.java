package com.example.starlingbankchallenge.repository;

import com.example.starlingbankchallenge.model.transactions.TransactionResponse;
import com.example.starlingbankchallenge.model.transactions.TransactionResponseItem;
import com.example.starlingbankchallenge.network.services.TransactionRetrofitService;

import java.util.List;

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

    public Single<List<TransactionResponseItem>> getTransactions(String token,String accountUid, String categoryUid, String changesSince){
        return transactionRetrofitService.getTransactions(token, accountUid, categoryUid, changesSince);
    }
}
