package com.masterandroid.rv_drag_and_swipe_java_14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

import com.masterandroid.rv_drag_and_swipe_java_14.adapter.CustomAdapter;
import com.masterandroid.rv_drag_and_swipe_java_14.helper.SimpleItemTouchHelperCallback;
import com.masterandroid.rv_drag_and_swipe_java_14.model.Member;

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
        context = this;
        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));


    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.Callback callback =new SimpleItemTouchHelperCallback(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();
        for (int i=1;i<21;i++){
            members.add(new Member(i+".PDP Academy"));
        }
        return members;
    }

}