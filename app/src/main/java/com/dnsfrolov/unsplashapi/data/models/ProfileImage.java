package com.dnsfrolov.unsplashapi.data.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public class ProfileImage {

    @SerializedName("small")
    private String small;

    @SerializedName("medium")
    private String medium;

    @SerializedName("large")
    private String large;

    public String getSmall() {
        return small;
    }

    public String getMedium() {
        return medium;
    }

    public String getLarge() {
        return large;
    }
}
