package com.example.starlingbankchallenge.repository;

import com.example.starlingbankchallenge.model.account.AccountsResponse;
import com.example.starlingbankchallenge.network.services.AccountRetrofitService;

import javax.inject.Inject;
import javax.inject.Singleton;
import io.reactivex.Single;
// it is singleton which means that we have one instance in whole project
@Singleton
public class AccountRepository {
    private final AccountRetrofitService accountRetrofitService;
    // using di (HILT) for injection
    @Inject
    public AccountRepository(AccountRetrofitService accountRetrofitService) {
        this.accountRetrofitService = accountRetrofitService;
    }
    //calling the API from Retrofit service
    public Single<AccountsResponse> getAccounts(String token){
        return accountRetrofitService.getAccounts(token);
    }
}
