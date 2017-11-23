package com.kardiga.nicolas.vinditindi.first_screen.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nicolas on 23.11.2017.
 */

public class SearchResponse {
    @SerializedName("photos")
    private Photos photos;

    @SerializedName("stat")
    private String stat;

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
