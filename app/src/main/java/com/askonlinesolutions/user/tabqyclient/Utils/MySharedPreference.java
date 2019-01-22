package com.askonlinesolutions.user.tabqyclient.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreference {

    private static MySharedPreference instance;
    private transient SharedPreferences prefs;

    private MySharedPreference(Context context) {
        prefs = context.getSharedPreferences(context.getPackageName(),
                Context.MODE_PRIVATE);
    }

    public static MySharedPreference getInstance(Context context) {
        if (instance == null)
            instance = new MySharedPreference(context);
        return instance;
    }

    public boolean isLogin(){
        if(prefs.contains(Constant.USER_ID)){
            return true;
        } else {
            return false;
        }
    }

    public void saveUserData(String login_data) {

        prefs.edit().putString(Constant.LOGIN_DATA, login_data).apply();
    }

    public String getUserData(){
        return prefs.getString(Constant.LOGIN_DATA, "");
    }

    public void saveUserId(String user_id){
        prefs.edit().putString(Constant.USER_ID,user_id).apply();
    }

    public String getUserId(){
        return prefs.getString(Constant.USER_ID, "");
    }

    public void clearUserData(){
        prefs.edit().remove(Constant.LOGIN_DATA).apply();
        prefs.edit().remove(Constant.USER_ID).apply();
    }
}