package com.dnsfrolov.unsplashapi.screen.photo.random;

import com.dnsfrolov.unsplashapi.data.interactor.InteractorCallback;
import com.dnsfrolov.unsplashapi.data.interactor.LikeInteractor;
import com.dnsfrolov.unsplashapi.data.interactor.PhotoInteractor;
import com.dnsfrolov.unsplashapi.data.interactor.impl.LikeInteractorImpl;
import com.dnsfrolov.unsplashapi.data.interactor.impl.PhotoInteractorImpl;
import com.dnsfrolov.unsplashapi.data.models.Photo;

/**
 * Created by dnsfrolov on 28.05.2017.
 */

public class RandomPhotoPresenterImpl implements RandomPhotoContract.RandomPhotoPresenter {

    private RandomPhotoContract.RandomPhotoView mView;
    private PhotoInteractor mPhotoInteractor;
    private LikeInteractor mLikeInteractor;

    public RandomPhotoPresenterImpl(RandomPhotoContract.RandomPhotoView mView) {
        this.mView = mView;
        mPhotoInteractor = new PhotoInteractorImpl();
        mLikeInteractor = new LikeInteractorImpl();
    }

    @Override
    public void loadRandomPhoto() {
        if (mView != null) {
            mView.showProgressIndicator();
        }

        mPhotoInteractor.getRandomPhoto(new InteractorCallback<Photo>() {
            @Override
            public void onSuccess(Photo response) {
                if (response != null) {
                    mView.showRandomPhoto(response);
                    mView.hideProgressIndicator();
                }
            }

            @Override
            public void onError(Throwable error) {
                mView.showError(error);
                mView.hideProgressIndicator();
            }
        });
    }

    @Override
    public void doLike(String id) {

        mLikeInteractor.setLike(id, new InteractorCallback<Photo>() {
            @Override
            public void onSuccess(Photo response) {
            }

            @Override
            public void onError(Throwable error) {
                mView.showError(error);
            }
        });
    }

    @Override
    public void doDislike(String id) {

        mLikeInteractor.setDislike(id, new InteractorCallback<Photo>() {
            @Override
            public void onSuccess(Photo response) {
            }

            @Override
            public void onError(Throwable error) {
                mView.showError(error);
            }
        });
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
