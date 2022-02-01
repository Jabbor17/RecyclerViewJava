package com.masterandroid.rv_with_onclicklistener_java_10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.masterandroid.rv_with_onclicklistener_java_10.adapter.CustomAdapter;
import com.masterandroid.rv_with_onclicklistener_java_10.model.Member;

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

        List<Member> members = prepareMemberList();

        refreshAdapter(members);
    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.rv_recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));

    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(this,members);
        recyclerView.setAdapter(adapter);
    }

    private List<Member> prepareMemberList() {
        ArrayList<Member> members = new ArrayList<>();

        for (int i = 1; i < 30; i++){
            members.add(new Member(i + ". Jasur","+998993524297"));
        }
        return members;
    }

    public void openItemDetails(Member member) {
        Toast.makeText(getApplicationContext(),member.getName()+" is clicked",Toast.LENGTH_SHORT).show();
        Log.d("Blabla",member.getName()+" Item is clicked");
    }
}