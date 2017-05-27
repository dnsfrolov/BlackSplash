package com.dnsfrolov.unsplashapi.screen.photo;

import com.dnsfrolov.unsplashapi.data.interactor.InteractorCallback;
import com.dnsfrolov.unsplashapi.data.interactor.PhotoInteractor;
import com.dnsfrolov.unsplashapi.data.interactor.impl.PhotoInteractorImpl;
import com.dnsfrolov.unsplashapi.data.models.Photo;

/**
 * Created by dnsfrolov on 26.05.2017.
 */

public class PhotoInfoPresenterImpl implements PhotoInfoContract.PhotoInfoPresenter {

    private PhotoInfoContract.PhotoInfoView mView;
    private PhotoInteractor mPhotoInteractor;

    public PhotoInfoPresenterImpl(PhotoInfoContract.PhotoInfoView mView) {
        this.mView = mView;
        mPhotoInteractor = new PhotoInteractorImpl();
    }

    @Override
    public void loadChosenPhoto(String id) {
        if (mView != null) {
            mView.showProgressIndicator();
        }

        mPhotoInteractor.getPhoto(id, new InteractorCallback<Photo>() {
            @Override
            public void onSuccess(Photo response) {
                if (response != null) {
                    mView.showPhotoInfo(response);
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
    public void detachView() {
        mView = null;
    }
}
