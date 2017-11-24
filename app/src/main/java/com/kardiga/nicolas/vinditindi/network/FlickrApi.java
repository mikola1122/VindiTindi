package com.kardiga.nicolas.vinditindi.network;

import com.kardiga.nicolas.vinditindi.first_screen.entity.SearchResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Nicolas on 24.11.2017.
 */

public interface FlickrApi {

    @GET("rest")
    Observable<SearchResponse> getMovers(@Query("format") String format,
                                         @Query("nojsoncallback") int noJsonFlag,
                                         @Query("api_key") String apiKey,
                                         @Query("method") String method,
                                         @Query("tags") String searchTag,
                                         @Query("sort") String sortType,
                                         @Query("per_page") int pageStep,
                                         @Query("page") int pageNumber);
}
