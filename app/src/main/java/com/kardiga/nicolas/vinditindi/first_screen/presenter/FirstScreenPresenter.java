package com.kardiga.nicolas.vinditindi.first_screen.presenter;

import com.daprlabs.aaron.swipedeck.SwipeDeck;
import com.kardiga.nicolas.vinditindi.databinding.ActivityMainBinding;
import com.kardiga.nicolas.vinditindi.first_screen.adapters.SwipeDeckAdapter;
import com.kardiga.nicolas.vinditindi.first_screen.callback.FirstScreenMvp;
import com.kardiga.nicolas.vinditindi.first_screen.entity.Photo;
import com.kardiga.nicolas.vinditindi.first_screen.model.FirstScreenModel;
import com.kardiga.nicolas.vinditindi.first_screen.view.MainActivity;

import java.util.List;

/**
 * Created by Nicolas on 23.11.2017.
 */

public class FirstScreenPresenter implements FirstScreenMvp.FirstScreenPresenter {
    private FirstScreenMvp.FirstScreenView mView;
    private FirstScreenMvp.FirstScreenModel mModel;
    private ActivityMainBinding mBinding;
    private int like = 0;
    private int dislike = 0;
    private SwipeDeckAdapter adapter;
    private static boolean isLastPage = false;


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
                checkPagination();
            }

            @Override
            public void cardSwipedRight(long positionInAdapter) {
                cardRightSwipe();
                checkPagination();
            }
        });
        mModel.loadPhotos(1);
    }

    @Override
    public void updatePhotos(List<Photo> photos, int position) {
        if (adapter == null) {
            adapter = new SwipeDeckAdapter(photos, (MainActivity) mView);
            SwipeDeck sd = mBinding.swipeDeck;
            if (sd != null) {
                sd.setAdapter(adapter);
            }
        } else {
            adapter.addData(photos);
        }
        isLastPage = photos.size() != 20;
    }

    @Override
    public void cardRightSwipe() {
        like += 1;
        mBinding.likeCounter.setText(like + "\nlike");
    }

    @Override
    public void cardLeftSwipe() {
        dislike += 1;
        mBinding.unlikeCounter.setText(dislike + "\ndislike");
    }

    private void checkPagination() {
        if (!isLastPage && adapter.getCount() - like - dislike < 6) {
            mModel.loadPhotos(adapter.getCount() / 20 + 1);
        }
    }
}
