package com.dnsfrolov.unsplashapi.utils;

import android.support.annotation.NonNull;

import com.orhanobut.hawk.Hawk;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public class AccountPrefs {

    public static String getToken() {
        return Hawk.get(Constants.TOKEN, "");
    }

    public static void setToken(@NonNull String token) {
        Hawk.put(Constants.TOKEN, token);
    }
}
