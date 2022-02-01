package com.masterandroid.rv_as_viewpager_java_9.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masterandroid.rv_as_viewpager_java_9.R;
import com.masterandroid.rv_as_viewpager_java_9.model.Photo;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Photo> photos;

    public PhotoAdapter(Context context,List<Photo> photos){
        this.context = context;
        this.photos = photos;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo_list,parent,false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Photo photo = photos.get(position);
        if (holder instanceof PhotoViewHolder){
            ((PhotoViewHolder) holder).imageView.setImageResource(photo.getWallpaper());
        }

    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder{
        View view;
        ImageView imageView;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;

            imageView = view.findViewById(R.id.iv_image);
        }
    }
}
