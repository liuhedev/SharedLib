package com.cleverlib.utils;

import java.util.Collection;

/**
 * 集合操作工具类
 *
 * @author liuhe
 * @created 2017/8/4
 */
public class CollectionUtils {
    /**
     * 判断集合是否为null或者0个元素
     *
     * @param c
     * @return
     */
    public static boolean isNullOrEmpty(Collection c) {
        if (null == c || c.isEmpty()) {
            return true;
        }
        return false;
    }
}
