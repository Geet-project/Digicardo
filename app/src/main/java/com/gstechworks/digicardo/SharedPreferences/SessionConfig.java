package com.gstechworks.digicardo.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionConfig {
    SharedPreferences prefs;


    public SessionConfig(Context context) {
        prefs = context.getSharedPreferences("UserLoginDetails", Context.MODE_PRIVATE);
    }
    public void setusename(String usename) {
        prefs.edit().putString("username", usename).commit();
    }
    public String getusename() {
        String usename = prefs.getString("usename","");
        return usename;
    }

    public void setusermobile(String mobile){
        prefs.edit().putString("mobile",mobile ).commit();
    }
    public String getusermobile(){
        String mobile = prefs.getString("mobile", "");
        return mobile;
    }

    public void setLoginState(boolean state){
        prefs.edit().putBoolean("LoginState", state).commit();
    }
    public boolean getLoginState(){
        boolean state = prefs.getBoolean("LoginState", false);
        return state;
    }
    public void setReseller(boolean state){
        prefs.edit().putBoolean("Reseller", state).commit();
    }

    public boolean getReseller(){
        boolean state = prefs.getBoolean("Reseller", false);
        return state;
    }
    public void setUser(boolean state){
        prefs.edit().putBoolean("User", state).commit();
    }

    public boolean getUser(){
        boolean state = prefs.getBoolean("Usr", false);
        return state;
    }



}
