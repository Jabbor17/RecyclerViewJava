package com.masterandroid.rv_baceclassforactivity_java_11.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.masterandroid.rv_baceclassforactivity_java_11.R;
import com.masterandroid.rv_baceclassforactivity_java_11.adapter.MainAdapter;
import com.masterandroid.rv_baceclassforactivity_java_11.model.Member;

import java.util.List;

public class MainActivity extends BaseActivity {
    Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        List<Member> members = prepareMemberList();

        refreshAdapter(members);
    }

    private void refreshAdapter(List<Member> members) {
        MainAdapter adapter = new MainAdapter(this,members);
        recyclerView.setAdapter(adapter);

    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recyclerView_main);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));

    }
    public void openItemDetails(Member member){
        Intent intent = new Intent(context,DetailActivity.class);
        startActivity(intent);
    }
}