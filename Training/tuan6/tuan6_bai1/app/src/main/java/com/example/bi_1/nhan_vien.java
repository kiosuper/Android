package com.example.bi_1;

import android.widget.CheckBox;
import android.widget.ImageView;

public class nhan_vien {
    public int icon;
    public String info;
    public boolean checkBox;

    public nhan_vien(int icon, String info, boolean checkBox) {
        this.icon = icon;
        this.info = info;
        this.checkBox = checkBox;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isCheckBox() {
        return checkBox;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }
}
