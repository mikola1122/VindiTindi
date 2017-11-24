package com.kardiga.nicolas.vinditindi.first_screen.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nicolas on 23.11.2017.
 */

public class Photo {
    @SerializedName("id")
    private Long id;

    @SerializedName("owner")
    private String owner;

    @SerializedName("secret")
    private String secret;

    @SerializedName("server")
    private Long server;

    @SerializedName("farm")
    private Long farm;

    @SerializedName("title")
    private String title;

    @SerializedName("ispublic")
    private  Integer isPublic;

    @SerializedName("isfriend")
    private Integer isFriend;

    @SerializedName("isfamily")
    private Integer isFamily;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Long getServer() {
        return server;
    }

    public void setServer(Long server) {
        this.server = server;
    }

    public Long getFarm() {
        return farm;
    }

    public void setFarm(Long farm) {
        this.farm = farm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    public Integer getIsFriend() {
        return isFriend;
    }

    public void setIsFriend(Integer isFriend) {
        this.isFriend = isFriend;
    }

    public Integer getIsFamily() {
        return isFamily;
    }

    public void setIsFamily(Integer isFamily) {
        this.isFamily = isFamily;
    }
}
