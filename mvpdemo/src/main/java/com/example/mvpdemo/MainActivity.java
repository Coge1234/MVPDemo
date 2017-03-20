package com.example.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvpdemo.presenter.ILoginPresenter;
import com.example.mvpdemo.presenter.LoginPresenterCompl;
import com.example.mvpdemo.view.ILoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ILoginView {
    //view变量不能够private or static
    @BindView(R.id.et_login_username)
    EditText mEtLoginUsername;
    @BindView(R.id.et_login_password)
    EditText mEtLoginPassword;
    @BindView(R.id.login_btn)
    Button mLoginBtn;
    @BindView(R.id.clear_btn)
    Button mClearBtn;
    @BindView(R.id.progress_login)
    ProgressBar mProgressLogin;

    ILoginPresenter mILoginPresenter;
    @BindView(R.id.testblockCanary_btn)
    Button mTestblockCanaryBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //初始化
        mILoginPresenter = new LoginPresenterCompl(this);
        mILoginPresenter.setProgressBarVisiblity(View.INVISIBLE);
        UserManger userManger = UserManger.getInstance(this);
    }

    @OnClick(R.id.login_btn)
    void doLogin(View view) {
//        char[] a = "hello".toCharArray();
//        Toast.makeText(this, new String(a), Toast.LENGTH_SHORT).show();
        mILoginPresenter.setProgressBarVisiblity(View.VISIBLE);
        mLoginBtn.setEnabled(false);
        mClearBtn.setEnabled(false);
        mILoginPresenter.doLogin(mEtLoginUsername.getText().toString(), mEtLoginPassword.getText().toString());
    }

    @OnClick(R.id.clear_btn)
    void doClear(View view) {
//        Toast.makeText(this, "点击了清空", Toast.LENGTH_SHORT).show();
        mILoginPresenter.clear();
    }

    @Override
    public void onClearTest() {
        mEtLoginUsername.setText("");
        mEtLoginPassword.setText("");
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        mILoginPresenter.setProgressBarVisiblity(View.VISIBLE);
        mLoginBtn.setEnabled(true);
        mClearBtn.setEnabled(true);
        onClearTest();
        if (result) {
            Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
        }
        mILoginPresenter.setProgressBarVisiblity(View.INVISIBLE);
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        mProgressLogin.setVisibility(visibility);
    }

    @OnClick(R.id.testblockCanary_btn)
    void testblockCanary(View view){
        //模拟一个长时间操作,产生ANR
        try {
            Thread.sleep(8*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "点击完成", Toast.LENGTH_SHORT).show();
    }
}
