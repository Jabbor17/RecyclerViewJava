package com.masterandroid.rv_multitype_java_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.masterandroid.rv_multitype_java_2.model.Member;
import com.masterandroid.rv_multitype_java_2.adapter.RecyclerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MainActivity context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    void initViews(){
        context =this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));

        ArrayList<Member> members = new ArrayList<>();

        for (int i=0;i<=20;i++){
            if(i == 0 ||i == 5 || i == 10 || i == 15 || i == 20) {
                members.add(new Member(R.mipmap.ic_launcher, "Ali " + i, "Vali " + i, false));
            }else {
                members.add(new Member(R.mipmap.ic_launcher, "Blabla " + i, "nhjuk " + i, true));
            }
        }

        refreshAdapter(members);
    }

    void refreshAdapter(ArrayList<Member> members){
        RecyclerAdapter adapter = new RecyclerAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }
}