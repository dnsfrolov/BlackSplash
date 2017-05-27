package com.dnsfrolov.unsplashapi.screen.photo;

import com.dnsfrolov.unsplashapi.data.models.Photo;

/**
 * Created by dnsfrolov on 26.05.2017.
 */

public interface PhotoInfoContract {

    interface PhotoInfoView {

        void showProgressIndicator();

        void hideProgressIndicator();

        void showPhotoInfo(Photo photo);

        void showError(Throwable error);
    }

    interface PhotoInfoPresenter {

        void loadChosenPhoto(String id);

        void detachView();
    }
}
