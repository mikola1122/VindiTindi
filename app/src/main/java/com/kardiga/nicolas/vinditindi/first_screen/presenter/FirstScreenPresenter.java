package com.kardiga.nicolas.vinditindi.first_screen.presenter;

import com.daprlabs.aaron.swipedeck.SwipeDeck;
import com.kardiga.nicolas.vinditindi.App;
import com.kardiga.nicolas.vinditindi.R;
import com.kardiga.nicolas.vinditindi.databinding.ActivityMainBinding;
import com.kardiga.nicolas.vinditindi.first_screen.adapters.SwipeDeckAdapter;
import com.kardiga.nicolas.vinditindi.first_screen.callback.FirstScreenMvp;
import com.kardiga.nicolas.vinditindi.first_screen.entity.Photo;
import com.kardiga.nicolas.vinditindi.first_screen.model.FirstScreenModel;
import com.kardiga.nicolas.vinditindi.first_screen.view.MainActivity;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Nicolas on 23.11.2017.
 */

public class FirstScreenPresenter implements FirstScreenMvp.FirstScreenPresenter {
    @Inject FirstScreenModel mModel;
    private FirstScreenMvp.FirstScreenView mView;
    private ActivityMainBinding mBinding;
    private int like = 0;
    private int dislike = 0;
    private SwipeDeckAdapter adapter;
    private static boolean isLastPage = false;
    private static final int PAGINATION_LIMIT = 6;
    private static final int PAGINATION_STEP = 20;
    private static final int NUMBER_OF_START_PAGE = 1;


    public FirstScreenPresenter(ActivityMainBinding binding, FirstScreenMvp.FirstScreenView view) {
        mBinding = binding;
        mView = view;
        App.getComponent().inject(this);
        mModel.setPresenter(this);
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
        mModel.loadPhotos(NUMBER_OF_START_PAGE);
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
        isLastPage = photos.size() != PAGINATION_STEP;
    }

    @Override
    public void cardRightSwipe() {
        like += 1;
        mBinding.likeCounter.setText(like + mBinding.getRoot().getContext().getString(R.string.like));
    }

    @Override
    public void cardLeftSwipe() {
        dislike += 1;
        mBinding.unlikeCounter.setText(dislike + mBinding.getRoot().getContext().getString(R.string.dislike));
    }

    private void checkPagination() {
        if (!isLastPage && adapter.getCount() - like - dislike < PAGINATION_LIMIT) {
            mModel.loadPhotos(adapter.getCount() / PAGINATION_STEP + 1);
        }
    }
}
