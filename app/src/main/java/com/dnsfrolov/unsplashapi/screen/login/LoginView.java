package com.dnsfrolov.unsplashapi.screen.login;

import com.arellomobile.mvp.MvpView;

/**
 * Created by dnsfrolov on 12.06.2017.
 */

public interface LoginView extends MvpView {

    void showProgressIndicator();

    void hideProgressIndicator();

    void loginSuccess();

    void showError();
}
