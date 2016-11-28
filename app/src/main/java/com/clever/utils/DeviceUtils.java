package com.clever.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import com.clever.base.BaseApplication;

/**
 * @author liuhea .
 * @created 16-11-25 .
 */
public class DeviceUtils {

    public static boolean hasInternet() {
        boolean hasInternet = ((ConnectivityManager) BaseApplication.getApplication().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
        return hasInternet;
    }


}
