package com.example.zhangxinfang.bbchat;

public class Item {

    private int imageId;
    private String textviewId;
    private int delete;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }


    public Item(int delete, String textviewId, int imageId) {
        this.delete = delete;
        this.textviewId =textviewId;
        this.imageId=imageId;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setTextviewId(String textviewId) {
        this.textviewId = textviewId;
    }

    public String getTextviewId() {
        return textviewId;
    }
}

