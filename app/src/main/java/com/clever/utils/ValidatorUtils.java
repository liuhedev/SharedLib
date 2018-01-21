package com.clever.utils;


import com.cleverlib.utils.StringUtils;

/**
 * 数据校验工具类
 *
 * @author liuhea
 * @date 2016-12-29</p>
 */

public class ValidatorUtils {

    private ValidatorUtils() {
        throw new UnsupportedOperationException("you can't instantiate me.");
    }

    /**
     * 校验姓名
     *
     * @param username
     * @return
     */
    public static boolean checkUsername(String username) {
        if (StringUtils.isEmpty(username)) {
            return false;
        }
        return username.matches("^[a-zA-Z]\\w{2,19}$");
    }

    /**
     * 校验密码
     *
     * @param password
     * @return
     */
    public static boolean checkPassword(String password) {
        if (StringUtils.isEmpty(password)) {
            return false;
        }
        return password.matches("^[0-9]{3,20}$");
    }
}
