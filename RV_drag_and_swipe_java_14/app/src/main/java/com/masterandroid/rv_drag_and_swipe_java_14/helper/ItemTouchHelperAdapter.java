package com.masterandroid.rv_drag_and_swipe_java_14.helper;

public interface ItemTouchHelperAdapter {

    void onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
