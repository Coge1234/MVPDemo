package com.example.mvpdemo.presenter;

/**
 * Created by Administrator on 2017/3/19.
 */

public interface ILoginPresenter {
    void clear();
    void doLogin(String name, String passwd);
    void setProgressBarVisiblity(int visiblity);
}
