package com.example.starlingbankchallenge;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;
import io.reactivex.plugins.RxJavaPlugins;
import timber.log.Timber;

@HiltAndroidApp
public class StarlingBankApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        AppPreference.init(getApplicationContext());
        RxJavaPlugins.setErrorHandler(Timber::e);
    }
}
