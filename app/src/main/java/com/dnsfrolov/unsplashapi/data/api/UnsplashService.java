package com.dnsfrolov.unsplashapi.data.api;

import com.dnsfrolov.unsplashapi.data.models.Photo;
import com.dnsfrolov.unsplashapi.data.models.TokenRequest;
import com.dnsfrolov.unsplashapi.data.models.TokenResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public interface UnsplashService {

    /*
     *https://unsplash.com/oauth/token
     */
    @POST("/oauth/token")
    Call<TokenResponse> getToken(@Body TokenRequest requestParams);

    @GET("/photos")
    Call<List<Photo>> getPhotos(@Query("page") int page);

    @POST("/photos/{id}/like")
    Call<Photo> setLike(@Path("id") String id);

    @DELETE("/photos/{id}/like")
    Call<Photo> setDislike(@Path("id") String id);
}
