package com.dnsfrolov.unsplashapi.utils;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public class Constants {

    public static final String BASE_API_URL = "https://api.unsplash.com";

    public static final String BASE_OAUTH_URL = "https://unsplash.com";

    public static final String OAUTH_URL = "https://unsplash.com/oauth/authorize";

    public static final String CLIENT_ID = "c9a4ee034e254bbc8304856c0c8f267ac5861f5a2b9711d50b0f53590d27ff5b";

    public static final String CLIENT_SECRET = "3a222fa0868ef4248416a66a2ea953ddd3bb8523cd2f0071ba4af1b83255937c";

    public static final String REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob";

    public static final String GRAND_TYPE = "authorization_code";

    public static final String RESPONSE_TYPE = "code";

    public static final String SCOPE = "public+read_user+write_user+read_photos+write_photos+" +
            "write_likes+write_followers+read_collections+write_collections";

    public static final String LOAD_AUTH_URL = OAUTH_URL +
            "?client_id=" + CLIENT_ID +
            "&redirect_uri=" + REDIRECT_URI +
            "&response_type=" + RESPONSE_TYPE +
            "&scope=" + SCOPE;

    public static final String TOKEN = "token";
}
