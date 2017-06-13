package com.dnsfrolov.unsplashapi.screen.login;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.dnsfrolov.unsplashapi.data.interactor.InteractorCallback;
import com.dnsfrolov.unsplashapi.data.interactor.LoginInteractor;
import com.dnsfrolov.unsplashapi.data.interactor.impl.LoginInteractorImpl;
import com.dnsfrolov.unsplashapi.data.models.TokenResponse;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {

    private LoginInteractor mInteractor;

    public LoginPresenter() {
        this.mInteractor = new LoginInteractorImpl();
    }

    public void signIn(String code) {
        if (getViewState() != null) {
            getViewState().showProgressIndicator();
        }

        mInteractor.getToken(code, new InteractorCallback<TokenResponse>() {
            @Override
            public void onSuccess(TokenResponse response) {
                getViewState().loginSuccess();
                getViewState().hideProgressIndicator();
            }

            @Override
            public void onError(Throwable error) {
                getViewState().showError();
                getViewState().hideProgressIndicator();
            }
        });
    }
}
