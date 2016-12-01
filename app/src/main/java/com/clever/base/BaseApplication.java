package com.clever.base;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

import butterknife.ButterKnife;

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
        ButterKnife.setDebug(true);
        LeakCanary.install(this);
    }

    public static synchronized BaseApplication getApplication() {
        return (BaseApplication) mContext;
    }
}
