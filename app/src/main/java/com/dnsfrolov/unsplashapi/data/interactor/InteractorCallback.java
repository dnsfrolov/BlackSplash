package com.dnsfrolov.unsplashapi.data.interactor;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public interface InteractorCallback<T> {

    void onSuccess(T response);

    void onError(Throwable error);
}
