package com.masterandroid.rv_as_horizontal_list_java_8.model;

import java.io.Serializable;

public class Photo implements Serializable {
    int photo;

    public Photo(int photo){
        this.photo = photo;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
