package com.dnsfrolov.unsplashapi.utils;

/**
 * Created by dnsfrolov on 25.05.2017.
 */

public interface OnItemClickListener {

    interface OnLikeClickListener<T> {

        void onLikeClick(T item);
    }

    interface OnPhotoClickListener<T> {

        void onPhotoClick(T item);
    }
}
