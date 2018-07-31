package com.clever.presenter;

/**
 * 登录页面控制类
 *
 * @author liuhea
 * @date 2016-12-29</p>
 */

public interface LoginPresenter {
    /**
     * 校验用户
     * @param username
     * @param password
     */
    void checkUser(String username, String password);
}
