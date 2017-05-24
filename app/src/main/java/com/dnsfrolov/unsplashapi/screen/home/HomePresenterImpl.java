package com.dnsfrolov.unsplashapi.screen.home;

import com.dnsfrolov.unsplashapi.data.interactor.InteractorCallback;
import com.dnsfrolov.unsplashapi.data.interactor.PhotoInteractor;
import com.dnsfrolov.unsplashapi.data.interactor.impl.PhotoInteractorImpl;
import com.dnsfrolov.unsplashapi.data.models.Photo;

import java.util.List;

/**
 * Created by dnsfrolov on 23.05.2017.
 */

public class HomePresenterImpl implements HomeContract.HomePresenter {

    private HomeContract.HomeView mView;
    private PhotoInteractor mInteractor;

    public HomePresenterImpl(HomeContract.HomeView mView) {
        this.mView = mView;
        mInteractor = new PhotoInteractorImpl();
    }

    @Override
    public void loadPhotos(int page) {
        mInteractor.getListOfPhotos(page, new InteractorCallback<List<Photo>>() {
            @Override
            public void onSuccess(List<Photo> response) {
                if (response != null && !response.isEmpty()) {
                    mView.showPhotos(response);
                }
            }

            @Override
            public void onError(Throwable error) {

            }
        });
    }

    @Override
    public void detachView() {

    }
}
