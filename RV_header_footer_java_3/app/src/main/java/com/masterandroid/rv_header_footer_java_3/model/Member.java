package com.masterandroid.rv_header_footer_java_3.model;

public class Member {
    int profile;
    String name;
    String surname;

    public Member(int profile,String name, String surname){
        this.profile = profile;
        this.name = name;
        this.surname = surname;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public Member() {

    }

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }


}
