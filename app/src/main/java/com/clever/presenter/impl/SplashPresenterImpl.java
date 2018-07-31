package com.clever.presenter.impl;

import com.clever.presenter.SplashPresenter;
import com.clever.ui.interf.SplashView;

/**
 * @author liuhea
 * @date 2016-12-29</p>
 */

public class SplashPresenterImpl implements SplashPresenter {


    private SplashView mSplashView;

    public SplashPresenterImpl(SplashView splashView) {
        mSplashView = splashView;
    }

    @Override
    public void isFirstLogin() {
//        if (EMClient.getInstance().isConnected() && EMClient.getInstance().isLoggedInBefore()) {
//            // 已登录，暂时替代sp .
            mSplashView.onFirstLogin(false);
//        } else {
//            // 未登录 .
//            mSplashView.onFirstLogin(true);
//        }

    }
}
