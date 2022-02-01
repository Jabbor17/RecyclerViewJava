package com.masterandroid.rv_header_footer_java_3.adapter;

import static com.masterandroid.rv_header_footer_java_3.R.id.iv_profile;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.masterandroid.rv_header_footer_java_3.R;
import com.masterandroid.rv_header_footer_java_3.model.Member;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_AVIALABLE = 2;
    private static final int  TYPE_VIEW_HEADER = 0;
    private static final int  TYPE_VIEW_FOOTER = 3;


    Context context;
    ArrayList<Member> members;

    public RecyclerAdapter(Context context, ArrayList<Member> members){
        this.context = context;
        this.members = members;
    }

    @Override
    public int getItemViewType(int position) {

        if(isHeader(position)) return TYPE_VIEW_HEADER;
        if(isFooter(position)) return TYPE_VIEW_FOOTER;

       return TYPE_AVIALABLE;
    }

    private boolean isFooter(int position) {
        return position==members.size()-1;
    }

    private boolean isHeader(int position) {
        return position==0;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == TYPE_VIEW_HEADER) {
            View header = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_header, parent, false);
            return new HeaderHolder(header);
        }
        if(viewType == TYPE_VIEW_FOOTER) {
            View footer = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_footer, parent, false);
            return new FooterHolder(footer);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_list, parent, false);
        return new MemberViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

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

    private static class FooterHolder extends RecyclerView.ViewHolder {
        public FooterHolder(View footer) {
            super(footer);
        }
    }

    private static class HeaderHolder extends RecyclerView.ViewHolder {
        public HeaderHolder(View header) {
            super(header);
        }
    }
}
