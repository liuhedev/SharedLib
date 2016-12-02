package com.clever;

import com.clever.utils.LogUtils;
import com.cleverlib.base.BaseApplication;

/**
 * @author liuhea .
 * @created 16-11-25 .
 */
public class AppContext extends BaseApplication {
    private static final String TAG = AppContext.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.log(TAG, "startApplication");
    }
}
