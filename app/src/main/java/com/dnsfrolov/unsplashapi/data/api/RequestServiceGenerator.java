package com.dnsfrolov.unsplashapi.data.api;

import android.support.annotation.NonNull;

import com.dnsfrolov.unsplashapi.utils.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public final class RequestServiceGenerator {

    private static UnsplashService mService;
    private static OkHttpClient mClient;

    @NonNull
    public static UnsplashService getUnsplashService() {
        UnsplashService service = mService;
        if (service == null) {
            service = mService = buildRetrofit().create(UnsplashService.class);
        }
        return service;
    }

    @NonNull
    public static Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_API_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @NonNull
    private static OkHttpClient getClient() {
        OkHttpClient client = mClient;
        if (client == null) {
            client = mClient = buildClient();
        }
        return client;
    }

    @NonNull
    private static OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(LoggingInterceptor.create())
                .addInterceptor(TokenInterceptor.create())
                .build();
    }
}
