package com.masterandroid.rv_header_footer_java_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.masterandroid.rv_header_footer_java_3.adapter.RecyclerAdapter;
import com.masterandroid.rv_header_footer_java_3.model.Member;

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
        members.add(new Member());

        for (int i=0;i<=20;i++){
                members.add(new Member(R.drawable.ic_launcher_background,"Ali " + i, "Vali " + i));
        }
        members.add(new Member());

        refreshAdapter(members);
    }

    void refreshAdapter(ArrayList<Member> members){
        RecyclerAdapter adapter = new RecyclerAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }

}