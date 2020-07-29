package com.poo.truyencuoi.model.entity;

public class TruyenCuoiEntity {
    private String tittle;
    private String content;
    private boolean isCheck;

    public TruyenCuoiEntity(String tittle, String content,boolean isCheck) {
        this.tittle = tittle;
        this.isCheck = isCheck;
        this.content = content;

    }

    public boolean getIsCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
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
