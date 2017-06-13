package com.dnsfrolov.unsplashapi.screen.home;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
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

@InjectViewState
public class HomePresenter extends MvpPresenter<HomeView> {

    private PhotoInteractor mPhotoInteractor;
    private LikeInteractor mLikeInteractor;

    public HomePresenter() {
        mPhotoInteractor = new PhotoInteractorImpl();
        mLikeInteractor = new LikeInteractorImpl();
    }

    public void loadPhotos(int page, String sortBy) {
        if (getViewState() != null) {
            getViewState().showProgressIndicator();
        }

        mPhotoInteractor.getListOfPhotos(page, sortBy, new InteractorCallback<List<Photo>>() {
            @Override
            public void onSuccess(List<Photo> response) {
                if (response != null && !response.isEmpty()) {
                    getViewState().showPhotos(response);
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
