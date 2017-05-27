package com.dnsfrolov.unsplashapi.screen.home;

import com.dnsfrolov.unsplashapi.data.interactor.InteractorCallback;
import com.dnsfrolov.unsplashapi.data.interactor.LikeInteractor;
import com.dnsfrolov.unsplashapi.data.interactor.PhotoInteractor;
import com.dnsfrolov.unsplashapi.data.interactor.impl.LikeInteractorImpl;
import com.dnsfrolov.unsplashapi.data.interactor.impl.PhotoInteractorImpl;
import com.dnsfrolov.unsplashapi.data.models.Photo;

import java.util.List;

/**
 * Created by dnsfrolov on 23.05.2017.
 */

public class HomePresenterImpl implements HomeContract.HomePresenter {

    private HomeContract.HomeView mView;
    private PhotoInteractor mPhotoInteractor;
    private LikeInteractor mLikeInteractor;

    public HomePresenterImpl(HomeContract.HomeView mView) {
        this.mView = mView;
        mPhotoInteractor = new PhotoInteractorImpl();
        mLikeInteractor = new LikeInteractorImpl();
    }

    @Override
    public void loadPhotos(int page) {
        if (mView != null) {
            mView.showProgressIndicator();
        }

        mPhotoInteractor.getListOfPhotos(page, new InteractorCallback<List<Photo>>() {
            @Override
            public void onSuccess(List<Photo> response) {
                if (response != null && !response.isEmpty()) {
                    mView.showPhotos(response);
                }
                mView.hideProgressIndicator();
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
        if (mView != null) {
            mView.showProgressIndicator();
        }

        mLikeInteractor.setLike(id, new InteractorCallback<Photo>() {
            @Override
            public void onSuccess(Photo response) {
                mView.hideProgressIndicator();
            }

            @Override
            public void onError(Throwable error) {
                mView.showError(error);
                mView.hideProgressIndicator();
            }
        });
    }

    @Override
    public void doDislike(String id) {
        if (mView != null) {
            mView.showProgressIndicator();
        }

        mLikeInteractor.setDislike(id, new InteractorCallback<Photo>() {
            @Override
            public void onSuccess(Photo response) {
                mView.hideProgressIndicator();
            }

            @Override
            public void onError(Throwable error) {
                mView.showError(error);
                mView.hideProgressIndicator();
            }
        });
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
