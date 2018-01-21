package com.liuhe.utils;

import android.text.TextUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author liuhe
 * @created 2017/5/19
 */

public class HttpHelper {

    /**
     * 遍历Map集合元素，构建一个get请求参数字符串
     *
     * @param params get请求map集合
     * @return get请求的字符串结构
     */
    private static String buildGetParam(Map<String, String> params) {
        StringBuilder buffer = new StringBuilder();
        if (params != null) {
            buffer.append("?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (TextUtils.isEmpty(key) || TextUtils.isEmpty(value)) {
                    continue;
                }
                try {
                    buffer.append(URLEncoder.encode(key, "UTF-8"));
                    buffer.append("=");
                    buffer.append(URLEncoder.encode(value, "UTF-8"));
                    buffer.append("&");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

        }
        String str = buffer.toString();
        //去掉最后的&
        if (str.length() > 1 && str.endsWith("&")) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }


}
