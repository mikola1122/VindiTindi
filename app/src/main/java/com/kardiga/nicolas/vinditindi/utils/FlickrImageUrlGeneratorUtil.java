package com.kardiga.nicolas.vinditindi.utils;

import com.kardiga.nicolas.vinditindi.first_screen.entity.Photo;

/**
 * Created by Nicolas on 23.11.2017.
 */

public class FlickrImageUrlGeneratorUtil {
    public static String generateUrlFromFlickrPhoto(Photo photo){
        String url = "https://farm" + photo.getFarm() + ".staticflickr.com/" + photo.getServer()
                + "/" + photo.getId() + "_" + photo.getSecret() + "_c.jpg";
        return url;
    }
}
