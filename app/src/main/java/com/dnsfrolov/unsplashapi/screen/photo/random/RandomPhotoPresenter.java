package com.dnsfrolov.unsplashapi.screen.photo.random;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.dnsfrolov.unsplashapi.data.interactor.InteractorCallback;
import com.dnsfrolov.unsplashapi.data.interactor.LikeInteractor;
import com.dnsfrolov.unsplashapi.data.interactor.PhotoInteractor;
import com.dnsfrolov.unsplashapi.data.interactor.impl.LikeInteractorImpl;
import com.dnsfrolov.unsplashapi.data.interactor.impl.PhotoInteractorImpl;
import com.dnsfrolov.unsplashapi.data.models.Photo;

/**
 * Created by dnsfrolov on 28.05.2017.
 */

@InjectViewState
public class RandomPhotoPresenter extends MvpPresenter<RandomPhotoView> {

    private PhotoInteractor mPhotoInteractor;
    private LikeInteractor mLikeInteractor;

    public RandomPhotoPresenter() {
        mPhotoInteractor = new PhotoInteractorImpl();
        mLikeInteractor = new LikeInteractorImpl();
    }

    public void loadRandomPhoto() {
        if (getViewState() != null) {
            getViewState().showProgressIndicator();
        }

        mPhotoInteractor.getRandomPhoto(new InteractorCallback<Photo>() {
            @Override
            public void onSuccess(Photo response) {
                if (response != null) {
                    getViewState().showRandomPhoto(response);
                    getViewState().hideProgressIndicator();
                }
            }

            @Override
            public void onError(Throwable error) {
                getViewState().showError(error);
                getViewState().hideProgressIndicator();
            }
        });
    }

    public void doLike(String id) {

        mLikeInteractor.setLike(id, new InteractorCallback<Photo>() {
            @Override
            public void onSuccess(Photo response) {
            }

            @Override
            public void onError(Throwable error) {
                getViewState().showError(error);
            }
        });
    }

    public void doDislike(String id) {

        mLikeInteractor.setDislike(id, new InteractorCallback<Photo>() {
            @Override
            public void onSuccess(Photo response) {
            }

            @Override
            public void onError(Throwable error) {
                getViewState().showError(error);
            }
        });
    }
}
