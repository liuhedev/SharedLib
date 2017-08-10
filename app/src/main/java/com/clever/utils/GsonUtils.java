package com.clever.utils;

import com.cleverlib.utils.LogUtils;
import com.cleverlib.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * @author liuhe
 * @created 2017/8/3
 */

public class GsonUtils {

    private static Gson sGson = new Gson();

    private GsonUtils() {
    }

    public static <T> T jsonToBean(String json, Class<T> clazz) {
        try {
            return sGson.fromJson(json, clazz);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String toJson(Object object) {
        try {
            return sGson.toJson(object);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断是否是正确json
     *
     * @param json
     * @return
     */
    public static boolean isGoodJson(String json) {
        if (StringUtils.isEmpty(json)) {
            return false;
        }
        try {
            new JsonParser().parse(json);
            return true;
        } catch (JsonParseException e) {
            LogUtils.e("bad json:" + json);
            return false;
        }
    }

}
