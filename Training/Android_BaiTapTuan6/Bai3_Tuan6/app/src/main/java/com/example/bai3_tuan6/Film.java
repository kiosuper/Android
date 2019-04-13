package com.example.bai3_tuan6;

public class Film {
    public int img_film;
    public String name_film_en;
    public String name_film_vn;
    public int star;

    public Film(int img_film, String name_film_en, String name_film_vn, int star) {
        this.img_film = img_film;
        this.name_film_en = name_film_en;
        this.name_film_vn = name_film_vn;
        this.star = star;
    }

    public int getImg_film() {
        return img_film;
    }

    public void setImg_film(int img_film) {
        this.img_film = img_film;
    }

    public String getName_film_en() {
        return name_film_en;
    }

    public void setName_film_en(String name_film_en) {
        this.name_film_en = name_film_en;
    }

    public String getName_film_vn() {
        return name_film_vn;
    }

    public void setName_film_vn(String name_film_vn) {
        this.name_film_vn = name_film_vn;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
