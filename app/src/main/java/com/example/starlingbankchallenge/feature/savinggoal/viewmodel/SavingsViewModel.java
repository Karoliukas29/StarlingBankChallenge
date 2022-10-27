package com.example.starlingbankchallenge.feature.savinggoal.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.ViewModel;

import com.example.starlingbankchallenge.BuildConfig;
import com.example.starlingbankchallenge.model.spaces.SpacesResponse;
import com.example.starlingbankchallenge.network.base.StateLiveData;
import com.example.starlingbankchallenge.repository.SpacesRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@HiltViewModel
public class SavingsViewModel extends ViewModel {
    private static final String TAG = "SavingsViewModel";
    private SpacesRepository spacesRepository;
    public StateLiveData<SpacesResponse> stateLiveData = new StateLiveData<>();

    @Inject
    public SavingsViewModel(SpacesRepository spacesRepository) {
        this.spacesRepository = spacesRepository;
    }

    public LiveData<SpacesResponse> loadSpaces(String accountUid) {
        return LiveDataReactiveStreams.fromPublisher(getSpacesFlowable(accountUid));
    }
    // convert single to flowable and subscribe it on io thread and observeOn main thread, and getting result/error
    private Flowable<SpacesResponse> getSpacesFlowable(String accountUid) {
        return spacesRepository.getSpaces(BuildConfig.API_SECRET_TOKEN, accountUid)
                .toFlowable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(result ->{
                    stateLiveData.postComplete();
                    Timber.tag(TAG).i(result.toString());
                })
                .doOnError(result -> {
                    stateLiveData.postError(result);
                    Timber.tag(TAG).e(result);
                });
    }

}
