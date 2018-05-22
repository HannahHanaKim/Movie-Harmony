package com.example.hannahkim.movieharmony;

public class ListViewItem {

    private int image;
    private String name;

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public ListViewItem(int image, String name) {
        this.image = image;
        this.name=  name;
    }

}
