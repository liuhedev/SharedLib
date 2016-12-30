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
    public void createUser(String username, String password) {
        /**
         * 1.数据校验
         * 2.注册bmob
         *  2.1 成功 注册环信
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
