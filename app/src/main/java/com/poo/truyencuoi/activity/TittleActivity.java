package com.poo.truyencuoi.activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.poo.truyencuoi.R;
import com.poo.truyencuoi.entity.TruyenCuoiEntity;
import com.poo.truyencuoi.logic.Tittle;
import com.poo.truyencuoi.singleton.App;

import java.util.List;

public class TittleActivity extends BaseActivity {
    public static final String KEY_TITLE = "KEY_TITLE";
    private LinearLayout lnTitle;
    private TextView tvTittle;
    private Tittle tittle;

    private List<TruyenCuoiEntity> listTruyenCuoi;

    @Override
    protected void initView() {
        findViewById(R.id.iv_back_title_act, this);
        tittle = App.getInstance().getTittle();
        tvTittle = findViewById(R.id.tv_chu_de_truyen);

        tvTittle.setText(tittle.getTittle());

        listTruyenCuoi = tittle.getListTruyenCuoi();
        lnTitle = findViewById(R.id.ln_tittle);
        lnTitle.removeAllViews();

        for (int i = 0; i < listTruyenCuoi.size(); i++) {
            View itemView = LayoutInflater.from(this).inflate(R.layout.item_title, null);
            TextView tvTitle = itemView.findViewById(R.id.tv_title);
            tvTitle.setText(listTruyenCuoi.get(i).getTittle());
            tvTitle.setTag(i);


            tvTitle.setOnClickListener(this);
            lnTitle.addView(itemView);
        }


    }

    @Override
    protected int findByID() {
        return R.layout.act_tittle;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_title) {

            App.getInstance().setIndexContent((int) v.getTag());
            startActivity(new Intent(this, ContentActivity.class));

        } else if (v.getId() == R.id.iv_back_title_act) {
            startActivity(new Intent(this, StoryActivity.class));
            finish();
        }
    }
}
