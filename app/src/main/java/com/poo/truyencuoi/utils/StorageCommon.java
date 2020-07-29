package com.poo.truyencuoi.utils;

import com.poo.truyencuoi.model.logic.Tittle;

public class StorageCommon {
    private int indexContent;
    private Tittle tittle;
    private String titleContent;

    public int getIndexContent() {
        return indexContent;
    }

    public int setIndexContent(int indexContent) {
        this.indexContent = indexContent;
        return indexContent;
    }

    public Tittle getTittle() {
        return tittle;
    }

    public void setTittle(Tittle tittle) {
        this.tittle = tittle;
    }

    public String getTitleContent() {
        return titleContent;
    }

    public void setTitleContent(String titleContent) {
        this.titleContent = titleContent;
    }
}
