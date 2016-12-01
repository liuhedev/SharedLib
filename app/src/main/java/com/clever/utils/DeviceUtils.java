package com.clever.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

import com.clever.base.BaseApplication;

/**
 * @author liuhea .
 * @created 16-11-25 .
 */
public class DeviceUtils {
    /**
     * 获取手机IMEI序列号
     */
    public static String getIMEI() {
        TelephonyManager tel = (TelephonyManager) BaseApplication.getApplication()
                .getSystemService(Context.TELEPHONY_SERVICE);
        return tel.getDeviceId();
    }

    /**
     * 判断是否有网络
     */
    public static boolean hasInternet() {
        ConnectivityManager connectivity = (ConnectivityManager) BaseApplication.getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        }
        NetworkInfo info = connectivity.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }

    /**
     * 获取网络类型
     */

    /**
     * 获取手机系统型号等信息
     */

}
