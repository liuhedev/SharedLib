package com.cleverlib.utils;

import android.app.Activity;
import android.app.ProgressDialog;

/**
 * UI相关工具类
 *
 * @author liuhea .
 * @created 16-12-1 .
 */
public class UIUtils {

    /**
     * 获取一个环形进度条等待窗口
     */
    public static ProgressDialog getProgress(Activity activity, String msg) {
        // 实例化一个ProgressBarDialog
        ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage(msg);
        progressDialog.getWindow().setLayout(
                DensityUtils.getScreenW(activity),
                DensityUtils.getScreenH(activity));
        progressDialog.setCancelable(true);
        // 设置ProgressBarDialog的显示样式
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        return progressDialog;
    }
}
