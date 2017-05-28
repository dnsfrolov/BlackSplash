package com.dnsfrolov.unsplashapi.screen.photo.random;

import com.dnsfrolov.unsplashapi.data.models.Photo;

/**
 * Created by dnsfrolov on 28.05.2017.
 */

public interface RandomPhotoContract {

    interface RandomPhotoView {

        void showProgressIndicator();

        void hideProgressIndicator();

        void showRandomPhoto(Photo photo);

        void showError(Throwable error);
    }

    interface RandomPhotoPresenter {

        void loadRandomPhoto();

        void doLike(String id);

        void doDislike(String id);

        void detachView();
    }
}
