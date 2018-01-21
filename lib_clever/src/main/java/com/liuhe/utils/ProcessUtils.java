package com.liuhe.utils;

import android.app.ActivityManager;
import android.content.pm.PackageManager;

import com.liuhe.base.BaseApplication;

import java.util.Iterator;
import java.util.List;

import static android.content.Context.ACTIVITY_SERVICE;

/**
 * @author liuhea
 * @date 2016-12-29</p>
 */

public class ProcessUtils {

    public static String getAppName(int pID) {
        String processName = null;
        ActivityManager am = (ActivityManager) BaseApplication.getApplication().getSystemService(ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = BaseApplication.getApplication().getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == pID) {
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
                // Log.d("Process", "Error>> :"+ e.toString());
            }
        }
        return processName;
    }
}
