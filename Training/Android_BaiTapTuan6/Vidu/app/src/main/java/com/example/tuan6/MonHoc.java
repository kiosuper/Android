package com.example.tuan6;

public class MonHoc {
    private int img;
    private String tenMH, maMH, soTiet;

    public MonHoc(){}

    public MonHoc(int img, String tenMH, String maMH, String soTiet) {
        this.img = img;
        this.tenMH = tenMH;
        this.maMH = maMH;
        this.soTiet = soTiet;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(String soTiet) {
        this.soTiet = soTiet;
    }
}
