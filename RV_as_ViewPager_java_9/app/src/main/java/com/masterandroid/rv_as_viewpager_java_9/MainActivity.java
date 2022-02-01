package com.masterandroid.rv_as_viewpager_java_9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.masterandroid.rv_as_viewpager_java_9.adapter.PhotoAdapter;
import com.masterandroid.rv_as_viewpager_java_9.model.Photo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        List<Photo> photos = preparePhotoList();
        refreshAdapter(photos);
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView,int dx,int dy){
                super.onScrolled(recyclerView,dx,dy);
            }
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newstate){
                super.onScrollStateChanged(recyclerView,newstate);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int activePosition = layoutManager.findFirstVisibleItemPosition();
                if (activePosition == RecyclerView.NO_POSITION) return;
                Log.d("@@@","activePosition:"+activePosition);

            }
        });
    }

    private void refreshAdapter(List<Photo> photos) {
        PhotoAdapter adapter = new PhotoAdapter(context,photos);
        recyclerView.setAdapter(adapter);
    }

    private List<Photo> preparePhotoList() {
        List<Photo> photos = new ArrayList<>();

        photos.add(new Photo(R.drawable.im_wallpaper1));
        photos.add(new Photo(R.drawable.im_wallpaper2));
        photos.add(new Photo(R.drawable.im_wallpaper3));
        photos.add(new Photo(R.drawable.im_wallpaper4));
        photos.add(new Photo(R.drawable.im_wallpaper5));
        photos.add(new Photo(R.drawable.im_wallpaper6));

        return photos;
    }
}