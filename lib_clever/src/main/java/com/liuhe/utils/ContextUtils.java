package com.liuhe.utils;

import android.content.Context;
import android.util.Log;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Context 实用类
 * 1. 需要先调用init()进行初始化才能使用，建议放在Application中进行
 * 2. AtomicBoolean原子操作，保证只初始化一次，不会重复初始化。
 *
 * @author liuhe
 * @create 2018/5/30
 */
public class ContextUtils {
    private static final String TAG = ContextUtils.class.getSimpleName();
    private static Context appContext;
    private static AtomicBoolean initState = new AtomicBoolean(false);

    public static void init(Context context) {
        // 如果当前AtomicBoolean对象的值与expect相等，那么我们就去更新值为update，并且返回true，否则返回false
        // 可以换成这种写法：!(initState.compareAndSet(false, true))
        if (null == context || initState.get()) {
            return;
        }
        appContext = context.getApplicationContext();
        initState.set(true);
    }

    public static Context getAppContext() {
        try {
            return appContext;
        } catch (Exception e) {
            Log.e(TAG, "please invoke the init method first");
        }
        return null;
    }
}
