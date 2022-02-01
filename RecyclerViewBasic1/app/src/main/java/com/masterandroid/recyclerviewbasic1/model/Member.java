package com.masterandroid.recyclerviewbasic1.model;

import java.io.Serializable;

public class Member implements Serializable {

   public String name;
    public String phoneNumber;

    public Member(String name,String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
