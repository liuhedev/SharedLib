package com.liuhe.base;

import android.app.Application;
import android.content.Context;

/**
 * @author liuhea .
 * @created 16-11-25 .
 */
public class BaseApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;
    }

    public static synchronized BaseApplication getApplication() {
        return (BaseApplication) mContext;
    }
}
