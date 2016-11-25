package com.clever.base;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import butterknife.ButterKnife;

/**
 * @author liuhea .
 * @created 16-11-25 .
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ButterKnife.setDebug(true);
        LeakCanary.install(this);
    }
}
