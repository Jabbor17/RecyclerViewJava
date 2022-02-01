package com.masterandroid.rv_loading_more_java_4.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.masterandroid.rv_loading_more_java_4.R;
import com.masterandroid.rv_loading_more_java_4.listener.OnBottomReachedListener;
import com.masterandroid.rv_loading_more_java_4.model.Member;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    OnBottomReachedListener listener;
    Context context;
    ArrayList<Member> members;

    public RecyclerAdapter(Context context, ArrayList<Member> members, OnBottomReachedListener listener){
        this.context = context;
        this.members = members;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_list, parent, false);
        return new MemberViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position == members.size()-1){
            listener.OnBottomReached(position);
        }

        Member member = members.get(position);
        Log.d("TAG", "onBindViewHolder: " + member.getName() + " " + member.getSurname());


        if(holder instanceof MemberViewHolder){
            ((MemberViewHolder) holder).iv_profile.setImageResource(member.getProfile());
            ((MemberViewHolder)holder).tv_name.setText(member.getName());
            ((MemberViewHolder)holder).tv_surname.setText(member.getSurname());
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }


    public static class MemberViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ImageView iv_profile;
        public TextView tv_name;
        public TextView tv_surname;

        public MemberViewHolder(View v){
            super(v);
            this.view = v;

            iv_profile = view.findViewById(R.id.iv_profile);
            tv_name = view.findViewById(R.id.tv_name);
            tv_surname = view.findViewById(R.id.tv_surname);
        }
    }


}
