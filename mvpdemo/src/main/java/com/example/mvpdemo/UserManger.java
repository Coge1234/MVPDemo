package com.example.mvpdemo;

import android.content.Context;

/**
 * Created by Administrator on 2017/3/20.
 */

public class UserManger {
    private static UserManger instance;

    private Context context;

    private UserManger(Context context) {
        this.context = context;
    }

    public static UserManger getInstance(Context context) {
        if (instance == null) {
            instance = new UserManger(context.getApplicationContext());
        }
        return instance;
    }
}
