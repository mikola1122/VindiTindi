package com.kardiga.nicolas.vinditindi.first_screen.callback;

import com.kardiga.nicolas.vinditindi.first_screen.entity.Photo;

import java.util.List;

/**
 * Created by Nicolas on 23.11.2017.
 */

public interface FirstScreenMvp {
    interface FirstScreenView {
        void showErrorMessage(String message);
    }

    interface FirstScreenPresenter {
        void loadPhotos(FirstScreenView view);
        void updatePhotos(List<Photo> photos, int position);
        void cardRightSwipe();
        void cardLeftSwipe();
    }

    interface FirstScreenModel {
        void loadPhotos(int page);
    }
}
