package com.dnsfrolov.unsplashapi.data.api;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.dnsfrolov.unsplashapi.utils.AccountPrefs;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

class TokenInterceptor implements Interceptor {

    private final String mToken;

    private TokenInterceptor() {
        this.mToken = AccountPrefs.getToken();
    }

    public static Interceptor create() {
        return new TokenInterceptor();
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        if (TextUtils.isEmpty(mToken)) {
            return chain.proceed(chain.request());
        }

        Request request = chain.request().newBuilder()
                .addHeader("Accept-Version", "v1")
                .addHeader("Authorization", "Bearer " + mToken)
                .build();

        return chain.proceed(request);
    }
}
