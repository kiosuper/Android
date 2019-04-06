package com.example.myapplication;

public class Player {
    public String name;
    public String team;
    public String number;
    public int avatar;

    public Player(int avatar, String name,String number,String team){
        this.name = name;
        this.team = team;
        this.number = number;
        this.avatar = avatar;

    }
    public void Player(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
