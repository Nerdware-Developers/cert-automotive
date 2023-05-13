package com.nerdware.automotiveengineering.Module1;

public class module_item {
    int Image;
    String naa, pubb;

    public module_item(int image, String naa, String pubb) {
        Image = image;
        this.naa = naa;
        this.pubb = pubb;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getNaa() {
        return naa;
    }

    public void setNaa(String naa) {
        this.naa = naa;
    }

    public String getPubb() {
        return pubb;
    }

    public void setPubb(String pubb) {
        this.pubb = pubb;
    }
}
