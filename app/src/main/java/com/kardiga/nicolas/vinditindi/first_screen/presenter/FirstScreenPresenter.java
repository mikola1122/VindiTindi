package com.kardiga.nicolas.vinditindi.first_screen.presenter;

import android.util.Log;

import com.daprlabs.aaron.swipedeck.SwipeDeck;
import com.kardiga.nicolas.vinditindi.databinding.ActivityMainBinding;
import com.kardiga.nicolas.vinditindi.first_screen.adapters.SwipeDeckAdapter;
import com.kardiga.nicolas.vinditindi.first_screen.callback.FirstScreenMvp;
import com.kardiga.nicolas.vinditindi.first_screen.entity.Photo;
import com.kardiga.nicolas.vinditindi.first_screen.model.FirstScreenModel;
import com.kardiga.nicolas.vinditindi.first_screen.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 23.11.2017.
 */

public class FirstScreenPresenter implements FirstScreenMvp.FirstScreenPresenter {
    private FirstScreenMvp.FirstScreenView mView;
    private FirstScreenMvp.FirstScreenModel mModel;
    private ActivityMainBinding mBinding;
    private int like = 0;
    private int unlike = 0;
    private SwipeDeckAdapter adapter;


    public FirstScreenPresenter(ActivityMainBinding binding, FirstScreenMvp.FirstScreenView view) {
        mBinding = binding;
        mView = view;
        mModel = new FirstScreenModel(this);
    }

    @Override
    public void loadPhotos() {
        mBinding.swipeDeck.setCallback(new SwipeDeck.SwipeDeckCallback() {
            @Override
            public void cardSwipedLeft(long positionInAdapter) {
                cardLeftSwipe();
                Log.i("MainActivity", "card was swiped left, position in adapter: " + positionInAdapter);
            }

            @Override
            public void cardSwipedRight(long positionInAdapter) {
                cardRightSwipe();
                Log.i("MainActivity", "card was swiped right, position in adapter: " + positionInAdapter);
            }
        });
        mModel.loadPhotos();
    }

    @Override
    public void updatePhotos(List<Photo> photos, int position) {
        if (adapter == null){
            adapter = new SwipeDeckAdapter(photos, (MainActivity) mView);
            mBinding.swipeDeck.setAdapter(adapter);
        } else {
            adapter.addData(photos);
        }
    }

    @Override
    public void cardRightSwipe() {
        like +=1;
        mBinding.likeCounter.setText(String.valueOf(like));
    }

    @Override
    public void cardLeftSwipe() {
        unlike +=1;
        mBinding.unlikeCounter.setText(String.valueOf(unlike));
    }
}
