package com.example.starlingbankchallenge.repository;

import com.example.starlingbankchallenge.model.AccountsResponse;
import com.example.starlingbankchallenge.network.services.AccountRetrofitService;

import javax.inject.Inject;
import javax.inject.Singleton;
import io.reactivex.Single;

@Singleton
public class AccountRepository {

    private final AccountRetrofitService accountRetrofitService;

    @Inject
    public AccountRepository(AccountRetrofitService accountRetrofitService) {
        this.accountRetrofitService = accountRetrofitService;
    }

    public Single<AccountsResponse> getAccounts(){
        return accountRetrofitService.getAccounts();
    }
}
