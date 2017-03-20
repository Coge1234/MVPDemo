package com.example.mvpdemo.app;

import android.app.Application;

import com.example.mvpdemo.utils.AppBlockCanaryContext;
import com.github.moduth.blockcanary.BlockCanary;

/**
 * Created by Administrator on 2017/3/20.
 */

public class BlockCanApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 在主进程初始化调用哈
        BlockCanary.install(this, new AppBlockCanaryContext()).start();
    }
}
