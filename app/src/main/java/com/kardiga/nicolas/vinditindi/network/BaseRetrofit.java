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

    public static Retrofit instance(){
        if (mRetrofit == null) {

            HttpLoggingInterceptor logging   = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

             OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(15, TimeUnit.SECONDS)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .addInterceptor(logging)
                    .build();

            String url = "https://test-app";

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .setPrettyPrinting()
                    .serializeNulls()
                    .create();

            mRetrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
