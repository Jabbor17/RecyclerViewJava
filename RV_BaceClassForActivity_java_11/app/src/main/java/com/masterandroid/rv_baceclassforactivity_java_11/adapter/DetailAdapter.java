package com.masterandroid.rv_baceclassforactivity_java_11.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masterandroid.rv_baceclassforactivity_java_11.R;
import com.masterandroid.rv_baceclassforactivity_java_11.model.Member;

import java.util.List;

public class DetailAdapter extends BaseAdapter {
    Context context;
    List<Member> members;

    public DetailAdapter(Context context,List<Member> members){
        this.context = context;
        this.members = members;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member_list_detail,parent,false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);
        if (holder instanceof DetailViewHolder){
            ((DetailViewHolder) holder).tv_detail.setText(member.getName());
        }

    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    class DetailViewHolder extends RecyclerView.ViewHolder{
        View view;
        TextView tv_detail;

        public DetailViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;

            tv_detail = view.findViewById(R.id.tv_view_detail);
        }
    }

}
