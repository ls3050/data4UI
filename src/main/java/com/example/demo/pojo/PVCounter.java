package com.example.demo.pojo;

public class PVCounter {
    public int userid;
    public int viewTime;
    public String country;

    public PVCounter(int userid, int viewTime, String country) {
        this.userid = userid;
        this.viewTime = viewTime;
        this.country = country;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getViewTime() {
        return viewTime;
    }

    public void setViewTime(int viewTime) {
        this.viewTime = viewTime;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
