package com.dnsfrolov.unsplashapi.data.interactor;

import com.dnsfrolov.unsplashapi.data.models.Photo;

import java.util.List;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public interface PhotoInteractor {

    void getListOfPhotos(int page, InteractorCallback<List<Photo>> callback);
}
