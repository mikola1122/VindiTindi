package com.kardiga.nicolas.vinditindi.first_screen.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kardiga.nicolas.vinditindi.App;
import com.kardiga.nicolas.vinditindi.AppComponent;
import com.kardiga.nicolas.vinditindi.DaggerAppComponent;
import com.kardiga.nicolas.vinditindi.R;
import com.kardiga.nicolas.vinditindi.databinding.ActivityMainBinding;
import com.kardiga.nicolas.vinditindi.first_screen.callback.FirstActivityComponent;
import com.kardiga.nicolas.vinditindi.first_screen.callback.FirstScreenMvp;
import com.kardiga.nicolas.vinditindi.first_screen.model.FirstScreenModel;
import com.kardiga.nicolas.vinditindi.first_screen.presenter.FirstScreenPresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements FirstScreenMvp.FirstScreenView {
    @Inject FirstScreenPresenter mPresenter;
    private ActivityMainBinding mBinding;
    private static FirstActivityComponent component;

    public static FirstActivityComponent getComponent() {
        return component;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component = buildComponent();
        getComponent().inject(this);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setPresenter(mPresenter);
        mPresenter.loadPhotos(this);
    }

    public ActivityMainBinding getBinding(){
        return mBinding;
    }

    protected FirstActivityComponent buildComponent(){
        return DaggerFirstActivityComponent
                .builder()
                .firstScreenModel(new FirstScreenModel())
                .firstScreenPresenter(new FirstScreenPresenter())
                .build();
    }

    @Override
    public void showErrorMessage(String message) {

    }
}
