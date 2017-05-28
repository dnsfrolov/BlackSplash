package com.dnsfrolov.unsplashapi.screen.login;

import com.dnsfrolov.unsplashapi.data.interactor.InteractorCallback;
import com.dnsfrolov.unsplashapi.data.interactor.LoginInteractor;
import com.dnsfrolov.unsplashapi.data.interactor.impl.LoginInteractorImpl;
import com.dnsfrolov.unsplashapi.data.models.TokenResponse;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public class LoginPresenterImpl implements LoginContract.LoginPresenter {

    private LoginContract.LoginView mView;
    private LoginInteractor mInteractor;

    public LoginPresenterImpl(LoginContract.LoginView mView) {
        this.mView = mView;
        this.mInteractor = new LoginInteractorImpl();
    }

    @Override
    public void signIn(String code) {
        if (mView != null) {
            mView.showProgressIndicator();
        }

        mInteractor.getToken(code, new InteractorCallback<TokenResponse>() {
            @Override
            public void onSuccess(TokenResponse response) {
                mView.loginSuccess();
                mView.hideProgressIndicator();
            }

            @Override
            public void onError(Throwable error) {
                mView.showError();
                mView.hideProgressIndicator();
            }
        });
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
