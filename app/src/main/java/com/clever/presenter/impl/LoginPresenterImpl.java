package com.clever.presenter.impl;

import com.clever.presenter.LoginPresenter;
import com.clever.ui.interf.LoginView;
import com.clever.utils.ValidatorUtils;

/**
 * @author liuhea
 * @date 2016-12-29</p>
 */

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView mLoginView;

    public LoginPresenterImpl(LoginView loginView) {
        mLoginView = loginView;
    }

    @Override
    public void checkUser(String username, String password) {

        //校验用户信息

        ValidatorUtils.checkUsername(username);

        ValidatorUtils.checkPassword(password);
    }
}
