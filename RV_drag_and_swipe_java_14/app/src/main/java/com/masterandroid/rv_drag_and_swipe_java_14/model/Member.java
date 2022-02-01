package com.masterandroid.rv_drag_and_swipe_java_14.model;

import java.io.Serializable;

public class Member implements Serializable {
    String name;

    public Member(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
