package com.poo.truyencuoi.singleton;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.poo.truyencuoi.entity.TruyenCuoiEntity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CommonUtils {
    private static CommonUtils instance;

    private CommonUtils() {

    }

    public static CommonUtils getInstance() {
        if (instance == null) {
            instance = new CommonUtils();
        }
        return instance;
    }

    public ArrayList<TruyenCuoiEntity> readStoriesfromAssets(String path) {
        ArrayList<TruyenCuoiEntity> listData = new ArrayList<>();

        try {
            InputStream in = App.getInstance().getAssets().open(path);
            BufferedReader buf = new BufferedReader(new InputStreamReader(in));

            String title = null, content = "", line;
            while ((line = buf.readLine()) != null) {
                if (title == null) {
                    title = line;
                    continue;
                }
                if (line.contains("','0');")) {
                    listData.add(new TruyenCuoiEntity(title, content));
                    title = null;
                    content = "";
                    continue;
                }
                content += line + "\n";

            }
            return listData;
        } catch (Exception e) {
            return null;
        }

    }

    public Bitmap readFileImage(String path) {
        try {
            InputStream inputStream = App.getInstance().getAssets().open(path);
            Bitmap img = BitmapFactory.decodeStream(inputStream);
            return img;
        } catch (Exception e) {
            return null;
        }
    }

}
