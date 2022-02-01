package com.masterandroid.rv_inside_nestedsv_java_6.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.masterandroid.rv_inside_nestedsv_java_6.R;
import com.masterandroid.rv_inside_nestedsv_java_6.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MemberListHolder> {

    Context context;
    List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }


    @NonNull
    @Override
    public CustomAdapter.MemberListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_list,parent,false);
        return new MemberListHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MemberListHolder holder, int position) {
        Member member = members.get(position);

        holder.textView.setText(member.getName());
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    static class MemberListHolder extends RecyclerView.ViewHolder{
        View view;
        TextView textView;

        public MemberListHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;

            textView = view.findViewById(R.id.tv_item_name);
        }
    }

}
