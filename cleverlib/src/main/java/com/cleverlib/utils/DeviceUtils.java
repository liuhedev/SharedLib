package com.cleverlib.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

import com.cleverlib.base.BaseApplication;


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


    /**
     * 获取手机系统型号等信息
     */

}
