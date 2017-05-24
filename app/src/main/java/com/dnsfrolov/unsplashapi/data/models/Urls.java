package com.dnsfrolov.unsplashapi.data.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dnsfrolov on 23.05.2017.
 */

public class Urls {

    @SerializedName("raw")
    private String raw;

    @SerializedName("full")
    private String full;

    @SerializedName("regular")
    private String regular;

    @SerializedName("small")
    private String small;

    @SerializedName("thumb")
    private String thumb;

    public String getRaw() {
        return raw;
    }

    public String getFull() {
        return full;
    }

    public String getRegular() {
        return regular;
    }

    public String getSmall() {
        return small;
    }

    public String getThumb() {
        return thumb;
    }
}
