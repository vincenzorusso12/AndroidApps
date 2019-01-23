package com.example.vincenzorusso.russovincenzo;

import android.graphics.drawable.Drawable;

public class ImageHolder {

    private String name;
    private Drawable picture;

    public void setName(String name) {
        this.name = name;
    }

    public void setPicture(Drawable picture) {
        this.picture = picture;
    }

    public String getName() {

        return name;
    }

    public Drawable getPicture() {
        return picture;
    }

    public ImageHolder(String name, Drawable picture) {

        this.name = name;
        this.picture = picture;
    }
}
