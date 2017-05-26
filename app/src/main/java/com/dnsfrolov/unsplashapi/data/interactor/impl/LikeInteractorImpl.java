package com.dnsfrolov.unsplashapi.data.interactor.impl;

import android.support.annotation.NonNull;

import com.dnsfrolov.unsplashapi.data.api.RequestServiceGenerator;
import com.dnsfrolov.unsplashapi.data.interactor.InteractorCallback;
import com.dnsfrolov.unsplashapi.data.interactor.LikeInteractor;
import com.dnsfrolov.unsplashapi.data.models.Photo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dnsfrolov on 25.05.2017.
 */

public class LikeInteractorImpl implements LikeInteractor {

    @Override
    public void setLike(String id, final InteractorCallback<Photo> callback) {

        RequestServiceGenerator.getUnsplashService().setLike(id).enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(@NonNull Call<Photo> call, @NonNull Response<Photo> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Photo> call, @NonNull Throwable t) {
                callback.onError(t);
            }
        });
    }

    @Override
    public void setDislike(String id, final InteractorCallback<Photo> callback) {

        RequestServiceGenerator.getUnsplashService().setDislike(id).enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(@NonNull Call<Photo> call, @NonNull Response<Photo> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Photo> call, @NonNull Throwable t) {
                callback.onError(t);
            }
        });
    }
}
