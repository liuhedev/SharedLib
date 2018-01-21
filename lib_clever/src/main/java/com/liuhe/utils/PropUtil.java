package com.liuhe.utils;

import android.content.Context;

import java.io.IOException;
import java.util.Properties;

/**
 * 读取配置文件的工具类 .
 *
 * @author liuhe
 * @created 2017/3/13
 */
public class PropUtil {
    /**
     * 读取assets文件夹下的文件
     */
    public static Properties loadAssetsProperties(Context context, String arg) {
        Properties prop = null;
        prop = new Properties();
        //first load default properties
        try {
            prop.load(context.getAssets().open(arg));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;

    }


    /**
     * 读取Res文件夹的文件
     */
    public static Properties loadResProperties(Context context, int id) {
        Properties prop = new Properties();
        //first load default properties
        try {
            prop.load(context.getResources().openRawResource(id)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;

    }
}
