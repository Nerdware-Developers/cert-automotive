package com.nerdware.automotiveengineering.dash;

public class Items {
    int Image;

    String mad;

    public Items(int image, String mad) {
        Image = image;
        this.mad = mad;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getMad() {
        return mad;
    }

    public void setMad(String mad) {
        this.mad = mad;
    }
}
