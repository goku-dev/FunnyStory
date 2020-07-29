package com.poo.truyencuoi.view.activity;

import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;

import com.poo.truyencuoi.R;
import com.poo.truyencuoi.view.event.OnCallBackContent;
import com.poo.truyencuoi.view.event.OnCallBackDetail;
import com.poo.truyencuoi.view.fragment.BaseFragment;
import com.poo.truyencuoi.view.fragment.M001StoryFragment;
import com.poo.truyencuoi.view.fragment.M002TitleFragment;
import com.poo.truyencuoi.view.fragment.M003ContentFragment;
import com.poo.truyencuoi.model.logic.Tittle;
import com.poo.truyencuoi.App;
import com.poo.truyencuoi.utils.StorageCommon;

import java.lang.reflect.Constructor;

public class MainActivity extends BaseActivity implements OnCallBackDetail, OnCallBackContent {
    private static final int LEVEL_1 = 1;
    private static final int LEVEL_0 = 0;

    private ImageView ivListStory, ivFavorite;

    public void showFragment(String tag) {
        try {

            BaseFragment fragment = (BaseFragment) getSupportFragmentManager().findFragmentByTag(tag);
            if (fragment == null) {
                Class<?> clazz = Class.forName(tag);
                Constructor<?> cons = clazz.getConstructor();
                fragment = (BaseFragment) cons.newInstance();
            }
            fragment.setOnCallBack(this);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.ln_main_frg, fragment, tag)
                    .commit();

        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    protected void initView() {
        ivListStory = findViewById(R.id.iv_listStory, this);
        ivFavorite = findViewById(R.id.iv_favorite, this);
        changeTab(ivFavorite, ivListStory);
        showFragment(M001StoryFragment.TAG);
    }

    @Override
    protected int findByID() {
        return R.layout.act_main;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_listStory) {
            changeTab(ivListStory, ivFavorite);
        } else if (v.getId() == R.id.iv_favorite) {
            changeTab(ivFavorite, ivListStory);
        }
    }

    private void changeTab(ImageView selected, ImageView deselected) {
        selected.setBackgroundResource(R.color.colorBlue);
        deselected.setBackgroundResource(R.color.colorBlueNew);

        selected.setColorFilter(ContextCompat.getColor(this, R.color.colorYellowAlpha), PorterDuff.Mode.SRC_IN);
        deselected.setColorFilter(ContextCompat.getColor(this, R.color.colorStartWhite), PorterDuff.Mode.SRC_IN);
    }

    public StorageCommon getStorage() {
        return App.getInstance().getStorage();
    }

    @Override
    public void showTitle(Tittle tittle) {
        getStorage().setTittle(tittle);
        showFragment(M002TitleFragment.TAG);
    }

    @Override
    public void setOnCallBack(Tittle tittle) {

    }

    @Override
    public void showContent(int index) {

        getStorage().setIndexContent(index);
        showFragment(M003ContentFragment.TAG);
    }


    @Override
    public void clickFavorite(int level, ImageView ivStar) {
        if (level == 1) {
          ivStar.setImageLevel(LEVEL_0);
        } else {
            ivStar.setImageLevel(LEVEL_1);
        }
    }

    @Override
    public void backFragment() {
        showFragment(M002TitleFragment.TAG);
    }

}
