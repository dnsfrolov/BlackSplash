package com.dnsfrolov.unsplashapi.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public class Photo {

    @SerializedName("id")
    private String id;

    @SerializedName("created_at")
    private Date createdAt;

    @SerializedName("updated_at")
    private Date updatedAt;

    @SerializedName("width")
    private int width;

    @SerializedName("height")
    private int height;

    @SerializedName("color")
    private String color;

    @SerializedName("likes")
    private int likes;

    @SerializedName("liked_by_user")
    private boolean isLikedByUser;

    @SerializedName("user")
    private User user;

    @SerializedName("urls")
    private Urls urls;

    public boolean isLikedByUser() {
        return isLikedByUser;
    }

    public void setLikedByUser(boolean likedByUser) {
        isLikedByUser = likedByUser;
    }

    public Urls getUrls() {
        return urls;
    }

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public int getLikes() {
        return likes;
    }

    public User getUser() {
        return user;
    }
}
