package com.gstechworks.digicardo.Models;

public class NotiModel {
    String noti_name, noti_desc, noti_time;
    int noti_img;

    public NotiModel(String noti_name, String noti_desc, String noti_time, int noti_img) {
        this.noti_name = noti_name;
        this.noti_desc = noti_desc;
        this.noti_time = noti_time;
        this.noti_img = noti_img;
    }

    public String getNoti_name() {
        return noti_name;
    }

    public String getNoti_desc() {
        return noti_desc;
    }

    public String getNoti_time() {
        return noti_time;
    }

    public int getNoti_img() {
        return noti_img;
    }
}
