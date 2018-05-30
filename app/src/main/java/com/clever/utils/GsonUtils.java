package com.clever.utils;

import android.util.Log;

import com.google.gson.GsonBuilder;
import com.liuhe.utils.LogUtils;
import com.liuhe.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * @author liuhe
 * @created 2017/8/3
 */

public class GsonUtils {
    private static final String TAG = GsonUtils.class.getName();

    private static Gson GSON = createGson();
    private static final Gson GSON_NO_NULLS = createGson(false);

    private GsonUtils() {
    }

    /**
     * Create the standard {@link Gson} configuration
     *
     * @return created gson, never null
     */
    public static final Gson createGson() {
        return createGson(true);
    }

    /**
     * Create the standard {@link Gson} configuration
     *
     * @param serializeNulls whether nulls should be serialized
     * @return created gson, never null
     */
    private static Gson createGson(final boolean serializeNulls) {
        final GsonBuilder builder = new GsonBuilder();
        // 是否序列化带空的参数到gson中
        if (serializeNulls) {
            builder.serializeNulls();
        }
        return builder.create();
    }

    /**
     * Get reusable pre-configured {@link Gson} instance
     *
     * @return Gson instance
     */
    public static final Gson getGson() {
        return GSON;
    }

    /**
     * Get reusable pre-configured {@link Gson} instance
     *
     * @return Gson instance
     */
    public static final Gson getGson(final boolean serializeNulls) {
        return serializeNulls ? GSON : GSON_NO_NULLS;
    }

    /**
     * Convert string to given type
     *
     * @return instance of type
     */
    public static <T> T jsonToBean(String json, Class<T> clazz) {
        try {
            return GSON.fromJson(json, clazz);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return null;
        }
    }

    /**
     * Convert object to json
     *
     * @return json string
     */
    public static final String toJson(final Object object) {
        return toJson(object, true);
    }

    /**
     * Convert object to json
     *
     * @return json string
     */
    public static final String toJson(final Object object, final boolean includeNulls) {
        return includeNulls ? GSON.toJson(object) : GSON_NO_NULLS.toJson(object);
    }

    /**
     * 判断是否是正确json
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
