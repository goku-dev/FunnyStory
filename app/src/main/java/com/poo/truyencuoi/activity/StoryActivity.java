package com.poo.truyencuoi.activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.poo.truyencuoi.R;
import com.poo.truyencuoi.logic.Tittle;
import com.poo.truyencuoi.logic.TruyenCuoiManager;
import com.poo.truyencuoi.singleton.App;

import java.util.List;

public class StoryActivity extends BaseActivity {
    private static final int LEVEL_0 = 0;
    private static final int LEVEL_1 = 1;
    private LinearLayout lnEn, lnVn, lnStory;
    private ImageView ivFlag;
    private TruyenCuoiManager truyenCuoiManager;

    @Override
    protected void initView() {
        ivFlag = findViewById(R.id.iv_language, this);
         truyenCuoiManager = new TruyenCuoiManager();
        List<Tittle> listTitTleVN = truyenCuoiManager.getListChuDeTruyenVN();
        List<Tittle> listTitTleEN = truyenCuoiManager.getListChuDeTruyenEN();


        lnStory = findViewById(R.id.ln_main);


        lnVn = new LinearLayout(this);
        lnEn = new LinearLayout(this);

        initData(listTitTleVN, lnVn);
        initData(listTitTleEN, lnEn);
        lnStory.removeAllViews();
        lnStory.addView(lnVn);
    }

    private void initData(List<Tittle> listTittle, LinearLayout ln) {
        ln.setOrientation(LinearLayout.VERTICAL);
        for (int i = 0; i < listTittle.size(); i++) {
            View itemView = LayoutInflater.from(this).inflate(R.layout.item_story, null);
            ImageView ivStory = itemView.findViewById(R.id.iv_story);
            TextView tvStory = itemView.findViewById(R.id.tv_story);

            ivStory.setOnClickListener(this);
            tvStory.setOnClickListener(this);

            ivStory.setImageBitmap(listTittle.get(i).getImage());
            tvStory.setText(listTittle.get(i).getTittle());

            ivStory.setTag(listTittle.get(i));
            tvStory.setTag(listTittle.get(i));
            ln.addView(itemView);
        }
    }

    @Override
    protected int findByID() {
        return R.layout.act_story;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_language) {
            changeLanguage();
        } else if (v.getId() == R.id.tv_story || v.getId() == R.id.iv_story) {
            Tittle tittle = (Tittle) v.getTag();
            App.getInstance().setTittle(tittle);
            startActivity(new Intent(this, TittleActivity.class));
        }
    }

    private void changeLanguage() {
        if(ivFlag.getDrawable().getLevel()==LEVEL_0){
            ivFlag.getDrawable().setLevel(LEVEL_1);
            lnStory.removeAllViews();
            lnStory.addView(lnEn);
        }else{
            ivFlag.getDrawable().setLevel(LEVEL_0);
            lnStory.removeAllViews();
            lnStory.addView(lnVn);
        }
    }
}
