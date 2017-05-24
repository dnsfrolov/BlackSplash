package com.dnsfrolov.unsplashapi.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public class User {

    @SerializedName("id")
    private String id;

    @SerializedName("updated_at")
    private Date updatedAt;

    @SerializedName("username")
    private String username;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("portfolio_url")
    private String portfolioUrl;

    @SerializedName("bio")
    private String bio;

    @SerializedName("location")
    private String location;

    @SerializedName("total_likes")
    private int totalLikes;

    @SerializedName("total_photos")
    private int totalPhotos;

    @SerializedName("total_collections")
    private int totalCollections;

    @SerializedName("followed_by_user")
    private boolean followedByUser;

    @SerializedName("followers_count")
    private String followersCount;

    @SerializedName("following_count")
    private int followingCount;

    @SerializedName("downloads")
    private int downloads;

    @SerializedName("profile_image")
    private ProfileImage profileImage;

    public String getId() {
        return id;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPortfolioUrl() {
        return portfolioUrl;
    }

    public String getBio() {
        return bio;
    }

    public String getLocation() {
        return location;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public int getTotalPhotos() {
        return totalPhotos;
    }

    public int getTotalCollections() {
        return totalCollections;
    }

    public boolean isFollowedByUser() {
        return followedByUser;
    }

    public String getFollowersCount() {
        return followersCount;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public int getDownloads() {
        return downloads;
    }

    public ProfileImage getProfileImage() {
        return profileImage;
    }
}
