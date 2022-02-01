package com.masterandroid.rv_inside_rv_java_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.masterandroid.rv_inside_rv_java_5.adapter.CustomAdapter;
import com.masterandroid.rv_inside_rv_java_5.model.Member;
import com.masterandroid.rv_inside_rv_java_5.model.MemberSub;

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
        List<Member> members = PrepareMemberList();
        refreshAdapter(members);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.rv_recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));

    }
    void refreshAdapter(List<Member> members){
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }


    private List<Member> PrepareMemberList() {
        List<Member> members = new ArrayList<>();

        for (int i = 1; i < 30; i++){
            if (i==1 || i==10){
                members.add(new Member( i+".Ali","+Vali",prepareMemberSubList()));
            }else {
                members.add(new Member( i+".Ali","+Vali",null));

            }
            
        }
        return members;
    }

    private ArrayList<MemberSub> prepareMemberSubList() {
        ArrayList<MemberSub> memberSubs = new ArrayList<>();
        for (int i = 1;i < 5; i++){
            memberSubs.add(new MemberSub());
        }


        return memberSubs;
    }
}