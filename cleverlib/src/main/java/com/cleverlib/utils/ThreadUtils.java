package com.cleverlib.utils;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 运行在线程的简单封装
 *
 * @author liuhea
 * @date 2016-12-29</p>
 */

public class ThreadUtils {
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static Executor sExecutor = Executors.newSingleThreadExecutor();

    /**
     * 运行在子线程
     *
     * @param runnable
     */
    public void runOnSubThread(Runnable runnable) {
        sExecutor.execute(runnable);
    }

    /**
     * 运行在主线程
     *
     * @param runnable
     */
    public void runOnMainThread(Runnable runnable) {
        sHandler.post(runnable);
    }

}
