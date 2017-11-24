package com.kardiga.nicolas.vinditindi.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kardiga.nicolas.vinditindi.first_screen.presenter.FirstScreenPresenter;

/**
 * Created by Nicolas on 23.11.2017.
 */

public class DataBindingAdapter {

    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView view, String imageUrl) {
            Glide.with(view.getContext())
                    .load(imageUrl)
                    .fitCenter()
                    .into(view);
    }
}
