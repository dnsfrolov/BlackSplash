package com.dnsfrolov.unsplashapi.screen.login;

/**
 * Created by dnsfrolov on 19.05.2017.
 */

public interface LoginContract {

    interface LoginView {

        void showProgressIndicator();

        void hideProgressIndicator();

        void loginSuccess();

        void showError();
    }

    interface LoginPresenter {

        void signIn(String code);

        void detachView();
    }
}
