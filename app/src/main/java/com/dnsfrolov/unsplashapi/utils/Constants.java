package com.dnsfrolov.unsplashapi.utils;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public class Constants {

    public static final String BASE_API_URL = "https://api.unsplash.com";

    public static final String BASE_OAUTH_URL = "https://unsplash.com";

    public static final String OAUTH_URL = "https://unsplash.com/oauth/authorize";

    public static final String CLIENT_ID = "bea75e5b5d4a8955d06830f6f3f97decefc4d3d02ea5f846f06d094370ff1cb8";

    public static final String CLIENT_SECRET = "43a1893e967965e9a064b3fef37721625d37a6b4de41080341bd6891667ccd49";

    public static final String REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob";

    public static final String GRAND_TYPE = "authorization_code";

    public static final String RESPONSE_TYPE = "code";

    public static final String SCOPE = "public+read_user+write_user+read_photos+write_likes";

    public static final String LOAD_AUTH_URL = OAUTH_URL +
            "?client_id=" + CLIENT_ID +
            "&redirect_uri=" + REDIRECT_URI +
            "&response_type=" + RESPONSE_TYPE +
            "&scope=" + SCOPE;

    public static final String TOKEN = "token";
}
