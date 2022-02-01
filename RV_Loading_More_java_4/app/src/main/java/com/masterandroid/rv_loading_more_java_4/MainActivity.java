package com.masterandroid.rv_loading_more_java_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.masterandroid.rv_loading_more_java_4.adapter.RecyclerAdapter;
import com.masterandroid.rv_loading_more_java_4.listener.OnBottomReachedListener;
import com.masterandroid.rv_loading_more_java_4.model.Member;

import java.util.ArrayList;

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

        for (int i = 1; i < 70; i++){
            members.add(new Member(R.drawable.ic_launcher_background,i + ".Ali","Gani"));
        }
        return members;
    }

    void refreshAdapter(ArrayList<Member> members){
        RecyclerAdapter adapter = new RecyclerAdapter(context,members,new OnBottomReachedListener(){

            @Override
            public void OnBottomReached(int position) {
                Log.d("@@@","@@@position"+position);
            }
        });
        recyclerView.setAdapter(adapter);


    }
}