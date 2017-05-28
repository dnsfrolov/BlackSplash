package com.dnsfrolov.unsplashapi.data.interactor.impl;

import android.support.annotation.NonNull;

import com.dnsfrolov.unsplashapi.data.api.RequestServiceGenerator;
import com.dnsfrolov.unsplashapi.data.interactor.InteractorCallback;
import com.dnsfrolov.unsplashapi.data.interactor.PhotoInteractor;
import com.dnsfrolov.unsplashapi.data.models.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public class PhotoInteractorImpl implements PhotoInteractor {

    @Override
    public void getListOfPhotos(int page, String sortBy, final InteractorCallback<List<Photo>> callback) {

        RequestServiceGenerator.getUnsplashService().getPhotos(page, sortBy).enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(@NonNull Call<List<Photo>> call, @NonNull Response<List<Photo>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Photo>> call, @NonNull Throwable t) {
                callback.onError(t);
            }
        });
    }

    @Override
    public void getPhoto(String id, final InteractorCallback<Photo> callback) {

        RequestServiceGenerator.getUnsplashService().getPhoto(id).enqueue(new Callback<Photo>() {
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
    public void getRandomPhoto(final InteractorCallback<Photo> callback) {

        RequestServiceGenerator.getUnsplashService().getRandomPhoto().enqueue(new Callback<Photo>() {
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
