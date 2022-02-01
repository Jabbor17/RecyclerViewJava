package com.masterandroid.rv_toolbar_scroll_effect_java_12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.masterandroid.rv_toolbar_scroll_effect_java_12.adapter.CustomAdapter;
import com.masterandroid.rv_toolbar_scroll_effect_java_12.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);
    }

    private void initViews() {
        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);

    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();
        for (int i=1;i<21;i++){
            members.add(new Member("PDP Academy"));
        }
        return members;
    }
}