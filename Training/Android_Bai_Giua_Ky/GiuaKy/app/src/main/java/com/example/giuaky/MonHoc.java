package com.example.giuaky;

public class MonHoc {
    public String ten_mh;
    public int ma_mh;
    public int so_tc;
    public String so_tien;
    public boolean selected = false;

    public MonHoc(String ten_mh, int ma_mh, int so_tc, String so_tien){
        this.ten_mh = ten_mh;
        this.ma_mh = ma_mh;
        this.so_tc = so_tc;
        this.so_tien = so_tien;
    }
    public MonHoc(String ten_mh, int ma_mh, int so_tc, String so_tien,boolean selected){
        this.ten_mh = ten_mh;
        this.ma_mh = ma_mh;
        this.so_tc = so_tc;
        this.so_tien = so_tien;
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getTen_mh() {
        return ten_mh;
    }

    public void setTen_mh(String ten_mh) {
        this.ten_mh = ten_mh;
    }

    public int getMa_mh() {
        return ma_mh;
    }

    public void setMa_mh(int ma_mh) {
        this.ma_mh = ma_mh;
    }

    public int getSo_tc() {
        return so_tc;
    }

    public void setSo_tc(int so_tc) {
        this.so_tc = so_tc;
    }

    public String getSo_tien() {
        return so_tien;
    }

    public void setSo_tien(String so_tien) {
        this.so_tien = so_tien;
    }
}
