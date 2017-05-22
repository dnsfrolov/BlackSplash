package com.dnsfrolov.unsplashapi.screen.splash;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public interface SplashContract {

    interface SplashView {

        void isAuthorized(boolean isAuthorized);
    }

    interface SplashPresenter {

        void checkAuthorized();

        void detachView();
    }
}
