package com.dnsfrolov.unsplashapi.data.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public class TokenRequest {

    /*
     *  Your application ID.
     */
    @SerializedName("client_id")
    private String clientId;

    /*
     *  Your application secret.
     */
    @SerializedName("client_secret")
    private String clientSecret;

    /*
     *  Your application’s redirect URI.
     */
    @SerializedName("redirect_uri")
    private String redirectUri;

    /*
     *  The authorization code supplied to the callback by Unsplash.
     */
    @SerializedName("code")
    private String code;

    /*
     *  Value “authorization_code”.
     */
    @SerializedName("grant_type")
    private String grantType;

    public TokenRequest(String clientId, String clientSecret, String redirectUri, String code, String grantType) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
        this.code = code;
        this.grantType = grantType;
    }

    public TokenRequest() {
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }
}
