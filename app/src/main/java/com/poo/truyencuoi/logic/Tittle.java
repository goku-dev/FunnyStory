package com.poo.truyencuoi.logic;

import android.graphics.Bitmap;

import com.poo.truyencuoi.entity.TruyenCuoiEntity;
import com.poo.truyencuoi.singleton.CommonUtils;

import java.util.List;

public class Tittle {
    private Bitmap image;
    private String tittle;
    private List<TruyenCuoiEntity> listTruyenCuoi;

    public Tittle(String tittle, String pathTxt, String pathImg) {
        this.tittle = tittle;
        this.listTruyenCuoi = CommonUtils.getInstance().readStoriesfromAssets(pathTxt);
        image = CommonUtils.getInstance().readFileImage(pathImg);
    }

    public Bitmap getImage() {
        return image;
    }

    public String getTittle() {
        return tittle;
    }

    public List<TruyenCuoiEntity> getListTruyenCuoi() {
        return listTruyenCuoi;
    }
}
