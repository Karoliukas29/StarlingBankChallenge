package com.example.starlingbankchallenge.repository;

import com.example.starlingbankchallenge.model.spaces.SpacesResponse;
import com.example.starlingbankchallenge.model.transactions.TransactionResponse;
import com.example.starlingbankchallenge.network.services.SpacesRetrofitService;
import com.example.starlingbankchallenge.network.services.TransactionRetrofitService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class SpacesRepository {
    private SpacesRetrofitService spacesRetrofitService;

    @Inject
    public SpacesRepository(SpacesRetrofitService spacesRetrofitService) {
        this.spacesRetrofitService = spacesRetrofitService;
    }

    public Single<SpacesResponse> getSpaces(String token, String accountUid){
        return spacesRetrofitService.getSpaces(token, accountUid);
    }
}
