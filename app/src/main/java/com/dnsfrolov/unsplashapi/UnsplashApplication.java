package com.dnsfrolov.unsplashapi;

import android.app.Application;

import com.orhanobut.hawk.BuildConfig;
import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;
import com.orhanobut.hawk.LogLevel;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public class UnsplashApplication extends Application {

    private static UnsplashApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        Hawk.init(this)
                .setEncryptionMethod(HawkBuilder.EncryptionMethod.MEDIUM)
                .setStorage(HawkBuilder.newSharedPrefStorage(this))
                .setLogLevel(BuildConfig.DEBUG ? LogLevel.FULL : LogLevel.NONE)
                .build();
    }

    public static UnsplashApplication getInstance() {
        return instance;
    }
}
