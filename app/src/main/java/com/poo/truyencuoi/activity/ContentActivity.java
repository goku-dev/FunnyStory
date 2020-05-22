package com.poo.truyencuoi.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.poo.truyencuoi.R;
import com.poo.truyencuoi.adapter.ContentAdapter;
import com.poo.truyencuoi.adapter.ContentPageChangeAdapter;
import com.poo.truyencuoi.entity.TruyenCuoiEntity;
import com.poo.truyencuoi.logic.Tittle;
import com.poo.truyencuoi.singleton.App;

import java.util.List;

public class ContentActivity extends BaseActivity {
    private ViewPager viewPager;
    private List<TruyenCuoiEntity> listData;
    private TextView tvPage, tvContentTitle;
    private ContentAdapter contentAdapter;
    private ImageView ivBack;

    @Override
    protected void initView() {
        Tittle tittle = App.getInstance().getTittle();
        tvContentTitle = findViewById(R.id.tv_title_content);
        tvContentTitle.setText(tittle.getTittle());

        ivBack = findViewById(R.id.iv_back_content_act, this);
        tvPage = findViewById(R.id.tv_page_number);
        viewPager = findViewById(R.id.vp_content);
        listData = App.getInstance().getTittle().getListTruyenCuoi();


        contentAdapter = new ContentAdapter(listData, this);
        viewPager.setAdapter(contentAdapter);

        viewPager.setCurrentItem(App.getInstance().getIndexContent());
        tvPage.setText(String.format("%s/%s", viewPager.getCurrentItem() + 1, listData.size()));

        viewPager.addOnPageChangeListener(new ContentPageChangeAdapter() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tvPage.setText(String.format("%s/%s", position + 1, listData.size()));
            }
        });


    }

    @Override
    protected int findByID() {
        return R.layout.act_content;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_back_content_act) {
            startActivity(new Intent(this, TittleActivity.class));
            finish();
        }
    }
}
