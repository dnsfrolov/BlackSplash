package com.dnsfrolov.unsplashapi.utils;

import com.dnsfrolov.unsplashapi.data.api.RequestServiceGenerator;
import com.dnsfrolov.unsplashapi.data.models.APIError;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by dnsfrolov on 27.05.2017.
 */

public class ErrorUtils {

    public static APIError parseError(Response<?> response) {
        Converter<ResponseBody, APIError> converter =
                RequestServiceGenerator.buildRetrofit().responseBodyConverter(APIError.class, new Annotation[0]);

        APIError apiError;

        try {
            apiError = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new APIError();
        }

        return apiError;
    }
}
