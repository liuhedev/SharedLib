package com.cleverlib.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.cleverlib.base.BaseApplication;

import java.util.UUID;


/**
 * @author liuhea .
 * @created 16-11-25 .
 */
public class DeviceUtils {

    /**
     * Don't let anyone instantiate this class.
     */
    private DeviceUtils() {
        throw new UnsupportedOperationException("you can't instantiate me.");
    }

    /**
     * 获取手机IMEI序列号
     */
    public static String getIMEI() {
        TelephonyManager tel = (TelephonyManager) BaseApplication.getApplication()
                .getSystemService(Context.TELEPHONY_SERVICE);
        return tel.getDeviceId();
    }

    public static String getUUID() {
        final TelephonyManager tm = (TelephonyManager) BaseApplication.getApplication().getSystemService(Context.TELEPHONY_SERVICE);
        final String tmDevice, tmSerial, androidId;
        tmDevice = "" + tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = "" + android.provider.Settings.Secure.getString(BaseApplication.getApplication().getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
        UUID deviceUuid = new UUID(androidId.hashCode(), ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
        String uniqueId = deviceUuid.toString();
        LogUtils.d("uuid=" + uniqueId);
        return uniqueId;
    }


    /**
     * 获取手机系统型号等信息
     */

}
