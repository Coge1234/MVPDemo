package com.example.mvpdemo.model;

/**
 * Created by Administrator on 2017/3/19.
 */

public interface IUser {
    String getName();
    String getPasswd();
    int cheackUserValidity(String name, String passwd);
}
