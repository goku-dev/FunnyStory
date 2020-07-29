package com.poo.truyencuoi;

import android.app.Application;

import com.poo.truyencuoi.utils.StorageCommon;

public class App extends Application {

    private static App instance;

    private StorageCommon storage;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        storage = new StorageCommon();
        instance = this;

    }

    public StorageCommon getStorage() {
        return storage;
    }


}
