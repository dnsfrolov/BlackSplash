package com.dnsfrolov.unsplashapi.data.interactor;

import com.dnsfrolov.unsplashapi.data.models.TokenResponse;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public interface LoginInteractor {

    void getToken(String code, InteractorCallback<TokenResponse> callback);
}
