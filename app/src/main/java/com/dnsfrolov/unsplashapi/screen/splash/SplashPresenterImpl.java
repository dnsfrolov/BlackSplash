package com.dnsfrolov.unsplashapi.screen.splash;

import android.text.TextUtils;

import com.dnsfrolov.unsplashapi.utils.AccountPrefs;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public class SplashPresenterImpl implements SplashContract.SplashPresenter {

    private SplashContract.SplashView mView;

    public SplashPresenterImpl(SplashContract.SplashView view) {
        this.mView = view;
    }

    @Override
    public void checkAuthorized() {
        mView.isAuthorized(!TextUtils.isEmpty(AccountPrefs.getToken()));
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
