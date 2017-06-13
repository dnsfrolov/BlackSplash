package com.dnsfrolov.unsplashapi.screen.photo;

import com.arellomobile.mvp.MvpView;
import com.dnsfrolov.unsplashapi.data.models.Photo;

/**
 * Created by dnsfrolov on 12.06.2017.
 */

public interface PhotoInfoView extends MvpView {

    void showProgressIndicator();

    void hideProgressIndicator();

    void showPhotoInfo(Photo photo);

    void showError(Throwable error);
}
