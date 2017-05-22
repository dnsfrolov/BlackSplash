package com.dnsfrolov.unsplashapi.data.api;

import android.support.annotation.NonNull;

import com.dnsfrolov.unsplashapi.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

class LoggingInterceptor implements Interceptor {

    private Interceptor mLoggingInterceptor;

    private LoggingInterceptor() {
        mLoggingInterceptor = new HttpLoggingInterceptor()
                .setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        return mLoggingInterceptor.intercept(chain);
    }

    public static Interceptor create() {
        return new LoggingInterceptor();
    }


}
