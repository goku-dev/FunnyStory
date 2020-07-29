package com.poo.truyencuoi.view.event;

import android.widget.ImageView;

public interface OnCallBackContent extends OnCallBack {
    void showContent(int index);

    void clickFavorite(int level, ImageView v);

    void backFragment();
}
