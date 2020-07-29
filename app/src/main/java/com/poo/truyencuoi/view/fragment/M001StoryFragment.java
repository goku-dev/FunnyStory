package com.poo.truyencuoi.view.fragment;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.poo.truyencuoi.R;
import com.poo.truyencuoi.view.event.OnCallBackDetail;
import com.poo.truyencuoi.model.logic.Tittle;
import com.poo.truyencuoi.model.logic.TruyenCuoiManager;
import com.poo.truyencuoi.App;
import com.poo.truyencuoi.utils.StorageCommon;

import java.util.List;

public class M001StoryFragment extends BaseFragment<OnCallBackDetail> {
    private static final int LEVEL_0 = 0;
    private static final int LEVEL_1 = 1;
    private LinearLayout lnEn, lnVn, lnStory;
    private ImageView ivFlag;
    private TruyenCuoiManager truyenCuoiManager;
    public static String TAG = M001StoryFragment.class.getName();


    @Override
    protected void initView() {

        ivFlag = rootView.findViewById(R.id.iv_language);
        ivFlag.setOnClickListener(this);
        truyenCuoiManager = new TruyenCuoiManager();
        List<Tittle> listTitTleVN = truyenCuoiManager.getListChuDeTruyenVN();
        List<Tittle> listTitTleEN = truyenCuoiManager.getListChuDeTruyenEN();

        lnStory = rootView.findViewById(R.id.ln_main);


        lnVn = new LinearLayout(mContext);
        lnEn = new LinearLayout(mContext);

        initData(listTitTleVN, lnVn);
        initData(listTitTleEN, lnEn);
        lnStory.removeAllViews();
        lnStory.addView(lnVn);


    }

    private void initData(List<Tittle> listTittle, LinearLayout ln) {
        ln.setOrientation(LinearLayout.VERTICAL);
        for (int i = 0; i < listTittle.size(); i++) {
            View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_story, null);
            ImageView ivStory = itemView.findViewById(R.id.iv_story);
            TextView tvStory = itemView.findViewById(R.id.tv_story);

            Typeface font = Typeface.createFromAsset(App.getInstance().getAssets(), "fonts/inglobal_0.ttf");
            tvStory.setTypeface(font);

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
    protected int getByID() {
        return R.layout.frg_story;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_language) {
            changeLanguage();
        } else if (v.getId() == R.id.tv_story || v.getId() == R.id.iv_story) {
            Tittle tittle = (Tittle) v.getTag();
            callBack.showTitle(tittle);
        }
    }

    private void changeLanguage() {
        if (ivFlag.getDrawable().getLevel() == LEVEL_0) {
            ivFlag.getDrawable().setLevel(LEVEL_1);
            lnStory.removeAllViews();
            lnStory.addView(lnEn);
        } else {
            ivFlag.getDrawable().setLevel(LEVEL_0);
            lnStory.removeAllViews();
            lnStory.addView(lnVn);
        }
    }

    public StorageCommon getStorage() {
        return App.getInstance().getStorage();
    }
}
