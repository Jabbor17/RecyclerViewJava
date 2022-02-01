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
import com.masterandroid.rv_as_horizontal_list_java_8.model.Photo;

import java.util.List;
import java.util.zip.Inflater;

public class PhotoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Photo> photos;
    public PhotoAdapter(Context context, List<Photo> photos){
        this.context = context;
        this.photos = photos;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo,parent,false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Photo photo = photos.get(position);

        if (holder instanceof PhotoViewHolder){
            ((PhotoViewHolder)holder).image.setText(photo.getPhoto());
        }


    }

    @Override
    public int getItemCount() {
        return 0;
    }
    static class PhotoViewHolder extends RecyclerView.ViewHolder{
        View view;
        TextView image;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;

            image = view.findViewById(R.id.image_vertical);
        }
    }
}
