package com.dnsfrolov.unsplashapi.data.api;

import com.dnsfrolov.unsplashapi.data.models.TokenRequest;
import com.dnsfrolov.unsplashapi.data.models.TokenResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public interface UnsplashService {

    /*
     *https://unsplash.com/oauth/token
     */
    @POST("/oauth/token")
    Call<TokenResponse> getToken(@Body TokenRequest requestParams);


}
