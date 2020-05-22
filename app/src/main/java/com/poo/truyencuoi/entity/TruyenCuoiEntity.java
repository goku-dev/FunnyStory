package com.poo.truyencuoi.entity;

public class TruyenCuoiEntity {
    private String tittle;
    private String content;

    public TruyenCuoiEntity(String tittle, String content) {
        this.tittle = tittle;
        this.content = content;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
