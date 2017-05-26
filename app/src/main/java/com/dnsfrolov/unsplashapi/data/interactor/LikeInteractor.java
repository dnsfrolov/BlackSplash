package com.dnsfrolov.unsplashapi.data.interactor;

import com.dnsfrolov.unsplashapi.data.models.Photo;

/**
 * Created by dnsfrolov on 25.05.2017.
 */

public interface LikeInteractor {

    void setLike(String id, InteractorCallback<Photo> callback);

    void setDislike(String id, InteractorCallback<Photo> callback);
}
