package com.dnsfrolov.unsplashapi.screen.home;

import com.arellomobile.mvp.MvpView;
import com.dnsfrolov.unsplashapi.data.models.Photo;

import java.util.List;

/**
 * Created by dnsfrolov on 12.06.2017.
 */

public interface HomeView extends MvpView {

    void showProgressIndicator();

    void hideProgressIndicator();

    void showPhotos(List<Photo> photoList);

    void showError(Throwable error);
}
