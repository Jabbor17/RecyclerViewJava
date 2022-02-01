package com.masterandroid.rv_inside_rv_java_5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.masterandroid.rv_inside_rv_java_5.R;
import com.masterandroid.rv_inside_rv_java_5.model.Member;
import com.masterandroid.rv_inside_rv_java_5.model.MemberSub;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM_VIEW = 0;
    private static final int TYPE_ITEM_LIST = 1;


    Context context;
    List<Member> members;

    public CustomAdapter(Context context, List<Member> members){
        this.context = context;
        this.members = members;
    }


    @Override
    public int getItemViewType(int position){
        Member member = members.get(position);
        if (members.get(position).getMemberSubs() != null) return TYPE_ITEM_LIST;

        return TYPE_ITEM_VIEW;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM_LIST){
            View listLiew = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_list,parent,false);
            return new CustomListHolder(listLiew);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_list,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (holder instanceof CustomViewHolder) {

        }
        if (holder instanceof CustomListHolder) {
            RecyclerView recyclerView =((CustomListHolder)holder).recyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager(context,1));

            List<MemberSub> memberSubs = member.getMemberSubs();
            refreshAdapter(recyclerView,memberSubs);

        }
    }

    private void refreshAdapter(RecyclerView recyclerView, List<MemberSub> memberSubs) {
        CustomSubAdapter adapter = new CustomSubAdapter(context,memberSubs);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    static class CustomListHolder extends RecyclerView.ViewHolder{
        public View view;
        RecyclerView recyclerView;
        public TextView tv_name;
        public TextView tv_surname;



        public CustomListHolder(@NonNull View view) {
            super(view);
            this.view = view;


            recyclerView = view.findViewById(R.id.recyclerView);
            tv_name = view.findViewById(R.id.rv_recyclerView);

        }
    }
     static class CustomViewHolder extends RecyclerView.ViewHolder{
            public View view;


         public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }
}
