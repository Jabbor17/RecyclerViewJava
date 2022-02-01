package com.masterandroid.rv_with_onclicklistener_java_10.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masterandroid.rv_with_onclicklistener_java_10.MainActivity;
import com.masterandroid.rv_with_onclicklistener_java_10.R;
import com.masterandroid.rv_with_onclicklistener_java_10.model.Member;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   private MainActivity activity;
    List<Member> members;

    public CustomAdapter(MainActivity activity, List<Member> members){
        this.activity = activity;
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
            ((MemberViewholder) holder).name.setText(member.getName());
            ((MemberViewholder) holder).phoneNumber.setText(member.getPhoneNumber());

            ((MemberViewholder) holder).lay_info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.openItemDetails(member);

                }
            });

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
        public LinearLayout lay_info;

        public MemberViewholder( View v) {
            super(v);
            this.view = v;

            this.name = view.findViewById(R.id.tv_view);
            this.phoneNumber = view.findViewById(R.id.tv_phone);
            this.lay_info = view.findViewById(R.id.lay_info);


        }
    }

}
