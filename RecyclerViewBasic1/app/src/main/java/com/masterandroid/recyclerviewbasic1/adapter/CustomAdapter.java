package com.masterandroid.recyclerviewbasic1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masterandroid.recyclerviewbasic1.R;
import com.masterandroid.recyclerviewbasic1.model.Member;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        Context context;
        ArrayList<Member> members;

        public CustomAdapter(Context context,ArrayList<Member> members){
            this.context = context;
            this.members = members;
        }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member_list,parent,false);

        return new MemberViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if(holder instanceof MemberViewholder){
            TextView tv = ((MemberViewholder) holder).name;
            TextView tv_link = ((MemberViewholder) holder).phoneNumber;
            tv.setText(member.getName());
            tv_link.setText(member.getPhoneNumber());

        }

    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    class MemberViewholder extends RecyclerView.ViewHolder {
            public   View view;
            public TextView name;
            public  TextView phoneNumber;

        public MemberViewholder( View v) {
            super(v);
            this.view = v;

            this.name = view.findViewById(R.id.tv_view);
            this.phoneNumber = view.findViewById(R.id.tv_link);


        }
    }
}
