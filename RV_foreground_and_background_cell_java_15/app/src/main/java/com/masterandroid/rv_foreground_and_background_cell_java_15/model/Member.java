package com.masterandroid.rv_foreground_and_background_cell_java_15.model;

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
