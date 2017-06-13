package com.dnsfrolov.unsplashapi.screen.photo.random;

import com.arellomobile.mvp.MvpView;
import com.dnsfrolov.unsplashapi.data.models.Photo;

/**
 * Created by dnsfrolov on 12.06.2017.
 */

public interface RandomPhotoView extends MvpView {

    void showProgressIndicator();

    void hideProgressIndicator();

    void showRandomPhoto(Photo photo);

    void showError(Throwable error);
}
