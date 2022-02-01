package com.masterandroid.rv_as_viewpager_java_9.model;

import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;

public class Photo implements Serializable {
    int wallpaper;
    public Photo(int wallpaper){
        this.wallpaper = wallpaper;
    }

    public int getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(int wallpaper) {
        this.wallpaper = wallpaper;
    }
}
