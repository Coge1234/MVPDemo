package com.example.mvpdemo.model;

/**
 * Created by Administrator on 2017/3/19.
 */

public class UserModel implements IUser{
    String name;
    String passwd;

    public UserModel(String name, String passwd){
        this.name = name;
        this.passwd = passwd;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPasswd() {
        return passwd;
    }

    @Override
    public int cheackUserValidity(String name, String passwd) {
        if(name == null || passwd == null || !name.equals(getName())|| !passwd.equals(getPasswd())){
            return -1;
        }
        return 0;
    }
}
