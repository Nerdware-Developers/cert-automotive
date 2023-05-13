package com.nerdware.automotiveengineering;

public class module_3_item {
    int image;
    String nam;
    String puu;

    public module_3_item(int image, String nam, String puu) {
        this.image = image;
        this.nam = nam;
        this.puu = puu;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getPuu() {
        return puu;
    }

    public void setPuu(String puu) {
        this.puu = puu;
    }
}
