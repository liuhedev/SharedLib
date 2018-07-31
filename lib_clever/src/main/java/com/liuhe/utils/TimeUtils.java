package com.liuhe.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间相关工具类
 *
 * @author liuhea .
 * @created 16-12-1 .
 */
public class TimeUtils {

    /**
     * 返回当前系统时间
     */
    public static String getCurrentTime(String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(new Date());
    }
}
