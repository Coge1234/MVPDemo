package com.example.mvpdemo.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.mvpdemo.model.IUser;
import com.example.mvpdemo.model.UserModel;
import com.example.mvpdemo.view.ILoginView;

/**
 * Created by Administrator on 2017/3/19.
 */

public class LoginPresenterCompl implements ILoginPresenter {

    ILoginView mILoginView;
    IUser mIUser;
    static Handler mHandler;

    public LoginPresenterCompl(ILoginView ILoginView) {
        mILoginView = ILoginView;
        initUser();
        mHandler = new Handler(Looper.getMainLooper());
    }

    private void initUser() {
        mIUser = new UserModel("mvp", "1234");
    }

    @Override
    public void clear() {
        mILoginView.onClearTest();
    }

    @Override
    public void doLogin(String name, String passwd) {
        Boolean isLoginSuccess = true;
        final int code = mIUser.cheackUserValidity(name, passwd);
        if (code != 0)
            isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mILoginView.onLoginResult(result, code);
            }
        }, 3000);
    }

    @Override
    public void setProgressBarVisiblity(int visiblity) {
        mILoginView.onSetProgressBarVisibility(visiblity);
    }
}
