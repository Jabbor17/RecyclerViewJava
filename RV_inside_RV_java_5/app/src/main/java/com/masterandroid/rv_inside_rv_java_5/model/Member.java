package com.masterandroid.rv_inside_rv_java_5.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Member implements Serializable {

   private String name;
    private String surname;
    private ArrayList<MemberSub> memberSubs;


    public Member(String name, String surname, ArrayList<MemberSub> memberSubs){
        this.name = name;
        this.surname = surname;
        this.memberSubs = memberSubs;

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String phoneNumber) {
        this.surname = phoneNumber;
    }

    public ArrayList<MemberSub> getMemberSubs() {
        return memberSubs;
    }

    public void setMemberSubs(ArrayList<MemberSub> memberSubs) {
        this.memberSubs = memberSubs;
    }
}
