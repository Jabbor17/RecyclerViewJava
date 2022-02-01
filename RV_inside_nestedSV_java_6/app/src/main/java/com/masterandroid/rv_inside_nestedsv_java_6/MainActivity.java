package com.masterandroid.rv_inside_nestedsv_java_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.masterandroid.rv_inside_nestedsv_java_6.adapter.CustomAdapter;
import com.masterandroid.rv_inside_nestedsv_java_6.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private NestedScrollView nestedScrollView;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);
    }

    private void initViews() {
       // nestedScrollView = findViewById(R.id.nestedScrollView);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();

        for (int i=0;i<30;i++){
                members.add(new Member("Ali "+i,"Vali"+i));
            }
        return members;
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
    }
}