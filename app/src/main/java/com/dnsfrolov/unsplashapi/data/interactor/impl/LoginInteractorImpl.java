package com.dnsfrolov.unsplashapi.data.interactor.impl;

import android.support.annotation.NonNull;

import com.dnsfrolov.unsplashapi.data.api.TokenServiceGenerator;
import com.dnsfrolov.unsplashapi.data.api.UnsplashService;
import com.dnsfrolov.unsplashapi.data.interactor.InteractorCallback;
import com.dnsfrolov.unsplashapi.data.interactor.LoginInteractor;
import com.dnsfrolov.unsplashapi.data.models.TokenRequest;
import com.dnsfrolov.unsplashapi.data.models.TokenResponse;
import com.dnsfrolov.unsplashapi.utils.AccountPrefs;
import com.dnsfrolov.unsplashapi.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void getToken(String code, final InteractorCallback<TokenResponse> callback) {

        TokenRequest tokenRequest = new TokenRequest(Constants.CLIENT_ID,
                Constants.CLIENT_SECRET,
                Constants.REDIRECT_URI,
                code,
                Constants.GRAND_TYPE);

        TokenServiceGenerator.getUnsplashService().getToken(tokenRequest).enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(@NonNull Call<TokenResponse> call, @NonNull Response<TokenResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                    AccountPrefs.setToken(response.body().getAccessToken());
                }
            }

            @Override
            public void onFailure(@NonNull Call<TokenResponse> call, @NonNull Throwable t) {
                callback.onError(t);
            }
        });
    }
}
