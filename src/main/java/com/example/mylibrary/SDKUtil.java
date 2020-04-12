package com.example.mylibrary;

import android.util.Log;

public class SDKUtil {


    public volatile static SDKUtil sdkUtil; //第一层锁，保证变量的可见性；

    public static SDKUtil getInstance() {
        if (sdkUtil == null) {
            synchronized (SDKUtil.class) { //第二层锁，保证线程同步
                if (sdkUtil == null) {
                    sdkUtil = new SDKUtil();
                }
            }
        }
        return sdkUtil;
    }

    public void outputLog() {
        Log.d("SDKUtil", "来自SDKUtil的日志信息。");
    }
}
