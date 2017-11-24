package com.kardiga.nicolas.vinditindi.first_screen.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nicolas on 23.11.2017.
 */

public class Photos {
    @SerializedName("page")
    private Long page;

    @SerializedName("pages")
    private Long pages;

    @SerializedName("perpage")
    private Integer perPage;

    @SerializedName("total")
    private Long total;

    @SerializedName("photo")
    private List<Photo> photos;

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
