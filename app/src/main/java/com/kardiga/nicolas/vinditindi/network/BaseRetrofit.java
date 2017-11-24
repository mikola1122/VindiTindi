package com.kardiga.nicolas.vinditindi.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nicolas on 23.11.2017.
 */
public class BaseRetrofit {
    private static Retrofit mRetrofit = null;


    public static Retrofit getInstance() {
        if (mRetrofit == null) {
            String url = "https://api.flickr.com/services/";
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

    private static OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();
    }

    private static Gson getGson() {
        return new GsonBuilder()
                .setLenient()
                .setPrettyPrinting()
                .serializeNulls()
                .create();
    }
}
