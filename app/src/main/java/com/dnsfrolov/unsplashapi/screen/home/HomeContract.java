package com.dnsfrolov.unsplashapi.screen.home;

import com.dnsfrolov.unsplashapi.data.models.Photo;

import java.util.List;

/**
 * Created by dnsfrolov on 23.05.2017.
 */

public interface HomeContract {

    interface HomeView {

        void showProgressIndicator();

        void hideProgressIndicator();

        void showPhotos(List<Photo> photoList);

        void showError(Throwable error);
    }

    interface HomePresenter {

        void loadPhotos(int page);

        void doLike(String id);

        void doDislike(String id);

        void detachView();
    }
}
