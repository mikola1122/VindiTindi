package com.kardiga.nicolas.vinditindi.first_screen.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kardiga.nicolas.vinditindi.R;
import com.kardiga.nicolas.vinditindi.databinding.ActivityMainBinding;
import com.kardiga.nicolas.vinditindi.first_screen.callback.FirstScreenMvp;
import com.kardiga.nicolas.vinditindi.first_screen.presenter.FirstScreenPresenter;

public class MainActivity extends AppCompatActivity implements FirstScreenMvp.FirstScreenView {
    private ActivityMainBinding mBinding;
    private FirstScreenPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mPresenter = new FirstScreenPresenter(mBinding, this);
        mBinding.setPresenter(mPresenter);
        mPresenter.loadPhotos();
    }

    @Override
    public void showErrorMessage(String message) {

    }
}
