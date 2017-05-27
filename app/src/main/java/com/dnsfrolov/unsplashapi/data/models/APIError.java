package com.dnsfrolov.unsplashapi.data.models;

/**
 * Created by dnsfrolov on 27.05.2017.
 */

public class APIError {

    private int statusCode;
    private String message;

    public APIError() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
