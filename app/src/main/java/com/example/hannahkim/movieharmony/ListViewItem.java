package com.example.hannahkim.movieharmony;

import android.widget.ImageView;

public class ListViewItem {

    private ImageView icon;
    private String name;

    public ImageView getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public ListViewItem(ImageView icon, String name) {
        this.icon = icon;
        this.name=  name;
    }

}
