package com.example.starlingbankchallenge.di;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.starlingbankchallenge.BuildConfig;
import com.example.starlingbankchallenge.network.Interceptor.NetworkConnectionInterceptor;
import com.example.starlingbankchallenge.network.services.AccountRetrofitService;
import com.example.starlingbankchallenge.network.services.SavingGoalRetrofitService;
import com.example.starlingbankchallenge.network.services.SpacesRetrofitService;
import com.example.starlingbankchallenge.network.services.TransactionRetrofitService;
import com.example.starlingbankchallenge.network.services.TransferRetrofitService;
import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

// Because hilt is user, that's why we use Network modules for building retrofit client.
// And add providers for each library that is used like "okHttp", "GsonConverter" etc...
@InstallIn(SingletonComponent.class)
@Module
public class NetworkModule {

    @Provides
    @Singleton
    public Retrofit providesRetrofit(GsonConverterFactory gsonConverterFactory, RxJava2CallAdapterFactory rxJava2CallAdapterFactory, OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public final OkHttpClient providesOkHttpClient(@ApplicationContext @NotNull Context context) {
        long cacheSize = 5 * 1024 * 1024;
        Cache mCache = new Cache(context.getCacheDir(), cacheSize);
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(mCache)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(new NetworkConnectionInterceptor(context))
                .addNetworkInterceptor(loggingInterceptor)
                .protocols(Collections.singletonList(Protocol.HTTP_1_1))
                .build();
        return okHttpClient;
    }

    @Provides
    @Singleton
    public final Gson providesGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    public final GsonConverterFactory providesGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    public RxJava2CallAdapterFactory providesRxJavaCallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }
    @Provides
    @Singleton
    public boolean provideIsNetworkAvailable(@ApplicationContext Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }
    @Singleton
    @Provides
    public AccountRetrofitService provideAccountService(Retrofit retrofit) {
        return retrofit.create(AccountRetrofitService.class);
    }

    @Singleton
    @Provides
    public TransactionRetrofitService transactionRetrofitService(Retrofit retrofit) {
        return retrofit.create(TransactionRetrofitService.class);
    }

    @Singleton
    @Provides
    public SpacesRetrofitService spacesRetrofitService(Retrofit retrofit) {
        return retrofit.create(SpacesRetrofitService.class);
    }


    @Singleton
    @Provides
    public SavingGoalRetrofitService savingGoalRetrofitService(Retrofit retrofit) {
        return retrofit.create(SavingGoalRetrofitService.class);
    }

    @Singleton
    @Provides
    public TransferRetrofitService transferRetrofitService(Retrofit retrofit) {
        return retrofit.create(TransferRetrofitService.class);
    }
}