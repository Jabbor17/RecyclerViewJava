package com.masterandroid.rv_as_horizontal_list_java_8.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.masterandroid.rv_as_horizontal_list_java_8.R;
import com.masterandroid.rv_as_horizontal_list_java_8.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Member> members;

    public CustomAdapter(Context context, List<Member> members){
        this.context = context;
        this.members = members;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member_list,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (holder instanceof CustomViewHolder){
            ((CustomViewHolder)holder).tv_name.setText(member.getName());
            ((CustomViewHolder)holder).tv_phone.setText(member.getPhoneNumber());

        }

    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder{
        View view;
        TextView tv_name;
        TextView tv_phone;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;

            tv_name = view.findViewById(R.id.tv_name);
            tv_phone = view.findViewById(R.id.tv_phone);
        }
    }
}
