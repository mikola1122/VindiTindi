package com.kardiga.nicolas.vinditindi.first_screen.model;

import com.kardiga.nicolas.vinditindi.first_screen.callback.FirstScreenMvp;
import com.kardiga.nicolas.vinditindi.first_screen.presenter.FirstScreenPresenter;

/**
 * Created by Nicolas on 23.11.2017.
 */

public class FirstScreenModel implements FirstScreenMvp.FirstScreenModel {
    private FirstScreenMvp.FirstScreenPresenter presenter;

    public FirstScreenModel(FirstScreenMvp.FirstScreenPresenter presenter) {
        this.presenter = presenter;
    }
}
