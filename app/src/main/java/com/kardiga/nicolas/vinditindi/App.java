package com.kardiga.nicolas.vinditindi;

import android.app.Application;

import com.kardiga.nicolas.vinditindi.first_screen.model.FirstScreenModel;
import com.kardiga.nicolas.vinditindi.first_screen.presenter.FirstScreenPresenter;
import com.kardiga.nicolas.vinditindi.first_screen.view.MainActivity;
import com.kardiga.nicolas.vinditindi.network.BaseRetrofit;

/**
 * Created by Nicolas on 26.11.2017.
 */

public class App extends Application {
    private static AppComponent component;

    public static AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent
                .builder()
                .baseRetrofit(new BaseRetrofit())
                .build();
    }
}
