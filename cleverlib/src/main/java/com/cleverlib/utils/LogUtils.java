package com.cleverlib.utils;

import android.util.Log;

/**
 * 打印log工具类
 *
 * @author liuhea
 * @created 16-11-24
 */
public class LogUtils {
    public static final String LOG_TAG = "LogUtils";
    public static boolean DEBUG = true;

    /**
     * Don't let anyone instantiate this class.
     */
    private LogUtils() {
        throw new Error("Do not need instantiate!");
    }

    public static final void d(String log) {
        if (DEBUG) {
            Log.d(LOG_TAG, log);
        }
    }

    public static final void e(String log) {
        if (DEBUG) {
            Log.e(LOG_TAG, "" + log);
        }
    }

    public static final void i(String log) {
        if (DEBUG) {
            Log.i(LOG_TAG, log);
        }
    }

    public static final void i(String tag, String log) {
        if (DEBUG) {
            Log.i(tag, log);
        }
    }

    public static final void v(String log) {
        if (DEBUG) {
            Log.v(LOG_TAG, log);
        }
    }

    public static final void w(String log) {
        if (DEBUG) {
            Log.w(LOG_TAG, log);
        }
    }
}
