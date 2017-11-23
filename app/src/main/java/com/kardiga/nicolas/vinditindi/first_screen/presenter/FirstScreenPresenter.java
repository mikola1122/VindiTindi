package com.kardiga.nicolas.vinditindi.first_screen.presenter;

import com.kardiga.nicolas.vinditindi.databinding.ActivityMainBinding;
import com.kardiga.nicolas.vinditindi.first_screen.callback.FirstScreenMvp;
import com.kardiga.nicolas.vinditindi.first_screen.model.FirstScreenModel;

/**
 * Created by Nicolas on 23.11.2017.
 */

public class FirstScreenPresenter implements FirstScreenMvp.FirstScreenPresenter {
    private FirstScreenMvp.FirstScreenView mView;
    private FirstScreenMvp.FirstScreenModel mModel;
    private ActivityMainBinding mBinding;

    public FirstScreenPresenter(ActivityMainBinding binding, FirstScreenMvp.FirstScreenView view) {
        mBinding = binding;
        mView = view;
        mModel = new FirstScreenModel(this);
    }

    @Override
    public void loadData() {

    }
}
