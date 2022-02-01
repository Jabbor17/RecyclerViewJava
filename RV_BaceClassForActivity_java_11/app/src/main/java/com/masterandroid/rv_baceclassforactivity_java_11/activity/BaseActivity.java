package com.masterandroid.rv_baceclassforactivity_java_11.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.masterandroid.rv_baceclassforactivity_java_11.R;
import com.masterandroid.rv_baceclassforactivity_java_11.model.Member;
import com.masterandroid.rv_baceclassforactivity_java_11.network.BaseServer;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity implements BaseServer {

   protected String getServer(){
       if (IS_TESTER) return SERVER_DEVELOPMENT;
       return SERVER_DEPLOYMENT;
   }

    protected List<Member> prepareMemberList() {
        ArrayList<Member> members = new ArrayList<>();

        for (int i = 1; i < 30; i++){
            members.add(new Member(i + ". PDP Academy"));
        }
        return members;
    }
    protected static boolean isEmpty(final String s){
       return s == null || s.trim().isEmpty();
    }
}