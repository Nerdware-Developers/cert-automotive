package com.nerdware.automotiveengineering;

public class paper_item {
    int image;
    String string;

    public paper_item(int image, String string) {
        this.image = image;
        this.string = string;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
