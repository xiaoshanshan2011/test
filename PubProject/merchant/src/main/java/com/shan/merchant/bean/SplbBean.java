package com.shan.merchant.bean;

/**
 * Created by root on 17-12-28.
 */

public class SplbBean {
    private String img;
    private String text;

    public SplbBean(String img, String text) {
        this.img = img;
        this.text = text;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
