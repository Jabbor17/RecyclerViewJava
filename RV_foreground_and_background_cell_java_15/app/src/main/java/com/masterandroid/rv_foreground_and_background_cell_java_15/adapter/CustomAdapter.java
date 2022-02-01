package com.masterandroid.rv_foreground_and_background_cell_java_15.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masterandroid.rv_foreground_and_background_cell_java_15.R;
import com.masterandroid.rv_foreground_and_background_cell_java_15.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    List<Member> members;

    public CustomAdapter(Context context, List<Member> members){
        this.context = context;
        this.members = members;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member_list,parent,false);
        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (holder instanceof MemberViewHolder){
            ((MemberViewHolder) holder).textView.setText(member.getName());
        }

    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    static class MemberViewHolder extends RecyclerView.ViewHolder{
        View view;
        TextView textView;
        RelativeLayout view_background, view_foreground;

        public MemberViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;

            textView = view.findViewById(R.id.tv_name);
            view_background = view.findViewById(R.id.view_background);
            view_foreground = view.findViewById(R.id.view_foreground);
        }
    }

}
