package com.kardiga.nicolas.vinditindi.first_screen.callback;

/**
 * Created by Nicolas on 23.11.2017.
 */

public interface FirstScreenMvp {
    interface FirstScreenView{
        void showErrorMessage(String message);
    }

    interface FirstScreenPresenter{
        void loadData();
    }

    interface FirstScreenModel{

    }
}
