package com.masterandroid.rv_foreground_and_background_cell_java_15.helper;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerItemTouchHelper<RecyclerItemTouchHelperListener> extends ItemTouchHelper.SimpleCallback {
    private RecyclerItemTouchHelperListener listener;
//    /**
//     * Creates a Callback for the given drag and swipe allowance. These values serve as
//     * defaults
//     * and if you want to customize behavior per ViewHolder, you can override
//     * {@link #getSwipeDirs(RecyclerView, ViewHolder)}
//     * and / or {@link #getDragDirs(RecyclerView, ViewHolder)}.
//     *
//     * @param dragDirs  Binary OR of direction flags in which the Views can be dragged. Must be
//     *                  composed of {@link #LEFT}, {@link #RIGHT}, {@link #START}, {@link
//     *                  #END},
//     *                  {@link #UP} and {@link #DOWN}.
//     * @param swipeDirs Binary OR of direction flags in which the Views can be swiped. Must be
//     *                  composed of {@link #LEFT}, {@link #RIGHT}, {@link #START}, {@link
//     *                  #END},
//     *                  {@link #UP} and {@link #DOWN}.
//     */

    public RecyclerItemTouchHelper(int dragDirs, int swipeDirs,RecyclerItemTouchHelperListener listener) {
        super(dragDirs, swipeDirs);
        this.listener =listener;

    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return true;
    }
    @Override
    public  void  onSelectedChanged(RecyclerView.ViewHolder viewHolder,int actionState){
        if (viewHolder != null){
            final View foregroundView = viewHolder.view
        }
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

    }
}
