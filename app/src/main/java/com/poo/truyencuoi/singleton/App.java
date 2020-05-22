package com.poo.truyencuoi.singleton;

import android.app.Application;

import com.poo.truyencuoi.logic.Tittle;

public class App extends Application {

    private static App instance;
    private int indexContent;
    private Tittle tittle;
    private String titleContent;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }

    public String getTitleContent() {
        return titleContent;
    }

    public void setTitleContent(String titleContent) {
        this.titleContent = titleContent;
    }

    public int getIndexContent() {
        return indexContent;
    }

    public void setIndexContent(int indexContent) {
        this.indexContent = indexContent;
    }

    public Tittle getTittle() {
        return tittle;
    }

    public void setTittle(Tittle tittle) {
        this.tittle = tittle;
    }
}
