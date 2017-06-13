package com.dnsfrolov.unsplashapi.screen.photo;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.dnsfrolov.unsplashapi.data.interactor.InteractorCallback;
import com.dnsfrolov.unsplashapi.data.interactor.PhotoInteractor;
import com.dnsfrolov.unsplashapi.data.interactor.impl.PhotoInteractorImpl;
import com.dnsfrolov.unsplashapi.data.models.Photo;

/**
 * Created by dnsfrolov on 26.05.2017.
 */

@InjectViewState
public class PhotoInfoPresenter extends MvpPresenter<PhotoInfoView> {

    private PhotoInteractor mPhotoInteractor;
    private PhotoInfoView view;

    public PhotoInfoPresenter() {
        mPhotoInteractor = new PhotoInteractorImpl();
    }

    public void loadChosenPhoto(String id) {
        if (view == null) {
            getViewState().showProgressIndicator();
        }

        mPhotoInteractor.getPhoto(id, new InteractorCallback<Photo>() {
            @Override
            public void onSuccess(Photo response) {
                if (response != null) {
                    getViewState().showPhotoInfo(response);
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
}
