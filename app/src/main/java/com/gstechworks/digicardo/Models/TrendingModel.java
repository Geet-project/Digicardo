package com.gstechworks.digicardo.Models;

public class TrendingModel {
    int image;
    String name;

    public TrendingModel(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
