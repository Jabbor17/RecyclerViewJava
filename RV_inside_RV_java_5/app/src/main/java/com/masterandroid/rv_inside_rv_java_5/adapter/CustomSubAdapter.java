package com.masterandroid.rv_inside_rv_java_5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masterandroid.rv_inside_rv_java_5.R;
import com.masterandroid.rv_inside_rv_java_5.model.MemberSub;

import java.util.List;

public class CustomSubAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<MemberSub> memberSubs;


    public CustomSubAdapter(Context context,List<MemberSub> memberSubs){
        this.context = context;
        this.memberSubs = memberSubs;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_view_sub, parent, false);
        return new MemberSubViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            MemberSub memberSub = memberSubs.get(position);

            if (holder instanceof MemberSubViewHolder){
                ((MemberSubViewHolder) holder).tv.setText();
            }
    }

    @Override
    public int getItemCount() {
        return memberSubs.size();
    }

    static class MemberSubViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView tv;

        public MemberSubViewHolder(View v){
            super(v);
            this.view = v;

            tv = view.findViewById(R.id.tv);
        }
    }
}
