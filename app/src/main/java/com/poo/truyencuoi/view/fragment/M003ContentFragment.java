package com.poo.truyencuoi.view.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.poo.truyencuoi.R;
import com.poo.truyencuoi.view.adapter.ContentAdapter;
import com.poo.truyencuoi.view.adapter.ContentPageChangeAdapter;
import com.poo.truyencuoi.model.entity.TruyenCuoiEntity;
import com.poo.truyencuoi.view.event.OnCallBackContent;
import com.poo.truyencuoi.model.logic.Tittle;
import com.poo.truyencuoi.App;
import com.poo.truyencuoi.utils.StorageCommon;

import java.util.List;

public class M003ContentFragment extends BaseFragment<OnCallBackContent> {
    private static final int LEVEL_1 = 1;
    private static final int LEVEL_0 = 0;
    private ViewPager viewPager;
    private List<TruyenCuoiEntity> listData;
    private TextView tvPage, tvContentTitle;
    private ContentAdapter contentAdapter;
    private ImageView ivBack, ivStar;
    private boolean isCheck;
    public static String TAG = M003ContentFragment.class.getName();


    @Override
    protected void initView() {

        Tittle tittle = getStorage().getTittle();
        tvContentTitle = rootView.findViewById(R.id.tv_title_content);
        tvContentTitle.setText(tittle.getTittle());

        ivBack = rootView.findViewById(R.id.iv_back_content_act);
        ivBack.setOnClickListener(this);
        tvPage = rootView.findViewById(R.id.tv_page_number);
        ivStar = rootView.findViewById(R.id.iv_star);
        ivStar.setOnClickListener(this);
        ivBack.setOnClickListener(this);

        viewPager = rootView.findViewById(R.id.vp_content);
        listData = getStorage().getTittle().getListTruyenCuoi();

        contentAdapter = new ContentAdapter(listData, mContext);
        viewPager.setAdapter(contentAdapter);

        viewPager.setCurrentItem(getStorage().getIndexContent());
        tvPage.setText(String.format("%s/%s", viewPager.getCurrentItem() + 1, listData.size()));

        viewPager.addOnPageChangeListener(new ContentPageChangeAdapter() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tvPage.setText(String.format("%s/%s", position + 1, listData.size()));
                boolean isCheck = getStorage().getTittle().getListTruyenCuoi().get(position).getIsCheck();
                ivStar.setImageLevel(isCheck ? LEVEL_1 : LEVEL_0);
            }
        });
    }

    @Override
    protected int getByID() {
        return R.layout.frg_content;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_back_content_act) {
           callBack.backFragment();

        } else if (v.getId() == R.id.iv_star) {
            setFavorit();
            callBack.clickFavorite(ivStar.getDrawable().getLevel(), ivStar);

        }
    }

    private void setFavorit() {
        if (ivStar.getDrawable().getLevel() == LEVEL_0) {
            ivStar.setImageLevel(LEVEL_1);
            getStorage().getTittle().getListTruyenCuoi().get(viewPager.getCurrentItem()).setCheck(!isCheck);
        } else {
            ivStar.setImageLevel(LEVEL_0);
        }
    }

    public StorageCommon getStorage() {
        return App.getInstance().getStorage();
    }
}
