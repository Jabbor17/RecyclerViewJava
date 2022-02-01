package com.masterandroid.rv_baceclassforactivity_java_11.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masterandroid.rv_baceclassforactivity_java_11.R;
import com.masterandroid.rv_baceclassforactivity_java_11.activity.MainActivity;
import com.masterandroid.rv_baceclassforactivity_java_11.model.Member;

import java.util.List;

public class MainAdapter extends BaseAdapter {

   MainActivity activity;
    List<Member> members;

    public MainAdapter(MainActivity activity,List<Member> members){
        this.activity = activity;
        this.members = members;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member_list,parent,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);
        if (holder instanceof  MainViewHolder){
            ((MainViewHolder) holder).textView.setText(member.getName());
            ((MainViewHolder) holder).lay_info.setOnClickListener(view -> {
                activity.openItemDetails(member);

            });
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder{
        View view;
        TextView textView;
        LinearLayout lay_info;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;

            textView = view.findViewById(R.id.tv_view_main);
            lay_info = view.findViewById(R.id.lay_info);
        }
    }

}
