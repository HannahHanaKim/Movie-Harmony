package com.example.hannahkim.movieharmony;

import android.widget.ImageView;

import org.jsoup.select.Elements;

public class MovieItem {

    String imgSrc;
    String name="";

    public MovieItem(String imgSrc, String name) {
        super();
        this.imgSrc = imgSrc;
        this.name=  name;
    }
    public MovieItem() {}
}
