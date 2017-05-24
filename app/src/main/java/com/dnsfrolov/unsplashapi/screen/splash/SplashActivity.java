package com.dnsfrolov.unsplashapi.screen.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dnsfrolov.unsplashapi.screen.home.HomeActivity;
import com.dnsfrolov.unsplashapi.screen.login.LoginActivity;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public class SplashActivity extends AppCompatActivity implements SplashContract.SplashView {

    private SplashContract.SplashPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new SplashPresenterImpl(this);
        mPresenter.checkAuthorized();
    }

    @Override
    public void isAuthorized(boolean isAuthorized) {
        Intent intent = new Intent(this, isAuthorized ? HomeActivity.class : LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
