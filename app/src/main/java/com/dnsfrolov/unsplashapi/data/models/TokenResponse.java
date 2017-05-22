package com.dnsfrolov.unsplashapi.data.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public class TokenResponse {

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("token_type")
    private String tokenType;

    /*
     *  Separated list of requested scopes. e.g. public+read_user
     */
    @SerializedName("scope")
    private String scope;

    @SerializedName("created_at")
    private String createdAt;

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getScope() {
        return scope;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
