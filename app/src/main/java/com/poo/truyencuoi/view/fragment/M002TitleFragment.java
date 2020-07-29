package com.poo.truyencuoi.view.fragment;

import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.poo.truyencuoi.R;
import com.poo.truyencuoi.model.entity.TruyenCuoiEntity;
import com.poo.truyencuoi.view.event.OnCallBackContent;
import com.poo.truyencuoi.model.logic.Tittle;
import com.poo.truyencuoi.App;
import com.poo.truyencuoi.utils.StorageCommon;

import java.util.List;

public class M002TitleFragment extends BaseFragment<OnCallBackContent> implements CompoundButton.OnCheckedChangeListener {

    private LinearLayout lnTitle;
    private TextView tvTittle;
    private Tittle tittle;
    private DrawerLayout mdrawerTitle;
    SwitchCompat switchCompatTitle;
    private List<TruyenCuoiEntity> listTruyenCuoi;
    public static String TAG = M002TitleFragment.class.getName();


    @Override
    protected void initView() {

        rootView.findViewById(R.id.ln_tittle);
        switchCompatTitle = rootView.findViewById(R.id.sw_night);
        switchCompatTitle.setChecked(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES);
        switchCompatTitle.setOnCheckedChangeListener(this);

        findViewById(R.id.iv_menu_title, this);
        mdrawerTitle = rootView.findViewById(R.id.drawer_title);


        tittle = getStorage().getTittle();

        tvTittle = rootView.findViewById(R.id.tv_chu_de_truyen);

        tvTittle.setText(tittle.getTittle());

        listTruyenCuoi = tittle.getListTruyenCuoi();
        lnTitle = rootView.findViewById(R.id.ln_tittle);
        lnTitle.removeAllViews();

        for (int i = 0; i < listTruyenCuoi.size(); i++) {
            View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_title, null);
            TextView tvTitle = itemView.findViewById(R.id.tv_title);
            tvTitle.setText(listTruyenCuoi.get(i).getTittle());
            Typeface font = Typeface.createFromAsset(App.getInstance().getAssets(), "fonts/inglobal_0.ttf");
            tvTitle.setTypeface(font);
            tvTitle.setTag(i);


            tvTitle.setOnClickListener(this);
            lnTitle.addView(itemView);
        }


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_title) {

            callBack.showContent((int) v.getTag());

        } else if (v.getId() == R.id.iv_menu_title) {
            mdrawerTitle.openDrawer(Gravity.LEFT);
        }
    }

    @Override
    protected int getByID() {
        return R.layout.frg_tittle;
    }

    public StorageCommon getStorage() {
        return App.getInstance().getStorage();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }


}
