package com.example.vincenzorusso.contacts3;

import android.graphics.drawable.Drawable;

public class Contatto {
    private String name;
    private String cognome;
    private String tel;
    private Drawable picture;

    public Contatto(String n,String c, String t, Drawable f) {
        this.name = n;
        this.tel = t;
        this.picture = f;
        this.cognome=c;
    }

    public String getName() {
        return name;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTel() {
        return tel;
    }

    public Drawable getPicture() {
        return picture;
    }
}
