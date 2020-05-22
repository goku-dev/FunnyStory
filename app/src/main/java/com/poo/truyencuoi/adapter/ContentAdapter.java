package com.poo.truyencuoi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.poo.truyencuoi.R;
import com.poo.truyencuoi.entity.TruyenCuoiEntity;

import java.util.List;

public class ContentAdapter extends PagerAdapter {
    private List<TruyenCuoiEntity> listData;
    private Context context;

    public ContentAdapter(List<TruyenCuoiEntity> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup viewPager, int position) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_content, null);
        TextView tvContent = itemView.findViewById(R.id.tv_content_reading);
        TextView tvTitle = itemView.findViewById(R.id.tv_title_reading);

        TruyenCuoiEntity entity = listData.get(position);
        tvContent.setText(entity.getContent());
        tvTitle.setText(entity.getTittle());
        viewPager.addView(itemView);
        return itemView;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup viewPager, int position, @NonNull Object object) {
        viewPager.removeView((View) object);
    }
}
