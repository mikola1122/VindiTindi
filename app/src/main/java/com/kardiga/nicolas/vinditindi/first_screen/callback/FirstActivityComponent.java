package com.kardiga.nicolas.vinditindi.first_screen.callback;

import com.kardiga.nicolas.vinditindi.AppComponent;
import com.kardiga.nicolas.vinditindi.first_screen.model.FirstScreenModel;
import com.kardiga.nicolas.vinditindi.first_screen.presenter.FirstScreenPresenter;
import com.kardiga.nicolas.vinditindi.first_screen.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Nicolas on 26.11.2017.
 */

@Singleton
@Component(dependencies = AppComponent.class, modules = {FirstScreenPresenter.class, FirstScreenModel.class})
public interface FirstActivityComponent {
    void inject(MainActivity activity);
    void inject(FirstScreenPresenter presenter);
    void inject(FirstScreenModel model);
}
