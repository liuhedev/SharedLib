package com.clever.presenter.impl;

import com.clever.model.UserEntity;
import com.clever.presenter.RegisterPresenter;
import com.clever.ui.interf.RegisterView;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * 注册逻辑处理
 *
 * @author liuhea
 * @date 2016-12-29</p>
 */
public class RegisterPresenterImpl implements RegisterPresenter {

    private RegisterView mRegisterView;

    public RegisterPresenterImpl(RegisterView registerView) {
        mRegisterView = registerView;
    }

    @Override
    public void registerUser(String username, String password) {
        /**
         * 1.数据校验
         * 2.注册Bmob云数据库
         *  2.1 成功 注册环信
         *      2.1.1环信注册成功，成功
         *      2.1.2环信注册失败，删除bmob保存的用户
         *  2.2 失败
         */
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.signUp(new SaveListener<UserEntity>() {
                              @Override
                              public void done(UserEntity userEntity, BmobException e) {
                                  if (e == null) {
                                      mRegisterView.onRegisterUserSuccess();
                                  } else {
                                      mRegisterView.onRegisterUserFailed(e.getMessage());
                                  }
                              }
                          }

        );
    }
}
