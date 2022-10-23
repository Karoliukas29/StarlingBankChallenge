package com.example.starlingbankchallenge.di;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.starlingbankchallenge.BuildConfig;
import com.example.starlingbankchallenge.network.Interceptor.NetworkConnectionInterceptor;
import com.example.starlingbankchallenge.network.services.AccountRetrofitService;
import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
}