package com.masterandroid.rv_baceclassforactivity_java_11.model;

import java.io.Serializable;

public class Member implements Serializable {

   public String name;

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
