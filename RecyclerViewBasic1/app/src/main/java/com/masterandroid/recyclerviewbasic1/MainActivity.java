package com.masterandroid.recyclerviewbasic1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.masterandroid.recyclerviewbasic1.adapter.CustomAdapter;
import com.masterandroid.recyclerviewbasic1.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Context context;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        ArrayList<Member> members = prepareMemberList();

        refreshAdapter(members);
    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.rv_recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    public ArrayList<Member> prepareMemberList(){
        ArrayList<Member> members = new ArrayList<>();

        for (int i = 1; i < 30; i++){
            members.add(new Member(i + ".Ali","+Vali"));
        }
        return members;
    }

    void refreshAdapter(ArrayList<Member> members){
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }
}