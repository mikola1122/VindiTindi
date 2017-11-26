package com.kardiga.nicolas.vinditindi.first_screen.model;

import com.kardiga.nicolas.vinditindi.first_screen.callback.FirstScreenMvp;
import com.kardiga.nicolas.vinditindi.first_screen.entity.SearchResponse;
import com.kardiga.nicolas.vinditindi.network.BaseRetrofit;
import com.kardiga.nicolas.vinditindi.network.FlickrApi;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Nicolas on 23.11.2017.
 */

public class FirstScreenModel implements FirstScreenMvp.FirstScreenModel {
    private FirstScreenMvp.FirstScreenPresenter presenter;
    private Retrofit retrofit = BaseRetrofit.getInstance();
    private static final String API_KEY = "9a81c5c7d034f4ab98d39d52f13fa0df";
    private static final String RESPONSE_FORMAT = "json";
    private static final int RESPONSE_NO_JSON_FLAG = 1;
    private static final String API_METHOD = "flickr.photos.search";
    private static final String SEARCH_TAG = "portrait";
    private static final String RESULT_SORT_TYPE = "relevance";
    private static final int ONE_PAGE_STEP = 20;
    private static final String OK_STATUS = "ok";


    public FirstScreenModel(FirstScreenMvp.FirstScreenPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loadPhotos(int page) {
        FlickrApi api = retrofit.create(FlickrApi.class);
        Observable<SearchResponse> o = api.getMovers(RESPONSE_FORMAT, RESPONSE_NO_JSON_FLAG, API_KEY,
                API_METHOD, SEARCH_TAG, RESULT_SORT_TYPE, ONE_PAGE_STEP, page);
        o.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::parseResponse);
    }

    private void parseResponse(SearchResponse response){
        if (response.getStat().equals(OK_STATUS)){
            presenter.updatePhotos(response.getPhotos().getPhotos(), 0);
        }
    }
}
