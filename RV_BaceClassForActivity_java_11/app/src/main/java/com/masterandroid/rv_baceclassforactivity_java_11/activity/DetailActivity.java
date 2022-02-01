package com.masterandroid.rv_baceclassforactivity_java_11.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.masterandroid.rv_baceclassforactivity_java_11.R;
import com.masterandroid.rv_baceclassforactivity_java_11.adapter.DetailAdapter;
import com.masterandroid.rv_baceclassforactivity_java_11.adapter.MainAdapter;
import com.masterandroid.rv_baceclassforactivity_java_11.model.Member;

import java.util.List;

public class DetailActivity extends BaseActivity {
    Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initViews();

        List<Member> members = prepareMemberList();

        refreshAdapter(members);
    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recyclerView_detail);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));

    }

    private void refreshAdapter(List<Member> members) {
        DetailAdapter adapter = new DetailAdapter(this,members);
        recyclerView.setAdapter(adapter);


    }
}