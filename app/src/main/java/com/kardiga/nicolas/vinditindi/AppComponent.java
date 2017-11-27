package com.kardiga.nicolas.vinditindi;

import com.kardiga.nicolas.vinditindi.first_screen.model.FirstScreenModel;
import com.kardiga.nicolas.vinditindi.first_screen.presenter.FirstScreenPresenter;
import com.kardiga.nicolas.vinditindi.network.BaseRetrofit;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Nicolas on 26.11.2017.
 */
@Singleton
@Component(modules = {FirstScreenModel.class, BaseRetrofit.class})
public interface AppComponent {
    void inject(FirstScreenPresenter presenter);
    void inject(FirstScreenModel model);
}
