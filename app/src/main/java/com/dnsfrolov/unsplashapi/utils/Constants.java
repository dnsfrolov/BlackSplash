package com.dnsfrolov.unsplashapi.utils;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public class Constants {

    public static final String BASE_API_URL = "https://api.unsplash.com";

    public static final String BASE_OAUTH_URL = "https://unsplash.com";

    public static final String OAUTH_URL = "https://unsplash.com/oauth/authorize";

    public static final String CLIENT_ID = "6d3cdfb2113dc26514dbe65debb3ee6d206c0c09b3c2ad5ef334cd604190aabb";

    public static final String CLIENT_SECRET = "ba779ed2e42d1fa4ab790888dd0a085e9064187ce4be6bb0bd251c00cbd076b1";

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

    public static final String PHOTO_ID = "photo_id";

    public static final String LATEST = "latest";

    public static final String OLDEST = "oldest";

    public static final String POPULAR = "popular";

    public static final String SORT_BY = "sortBy";

    public static final int FIRST_PAGE = 1;
}
