package com.clever;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.widget.ImageView;

import com.clever.base.AppBaseActivity;
import com.clever.presenter.SplashPresenter;
import com.clever.presenter.impl.SplashPresenterImpl;
import com.clever.ui.activity.MainActivity;
import com.clever.ui.activity.SettingActivity;
import com.clever.ui.interf.SplashView;
import com.cleverlib.utils.SimpleAnimatorListener;

import butterknife.BindView;


/**
 * welcome to Clever
 *
 * @author liuhea
 * @created 16-11-24
 */
public class SplashActivity extends AppBaseActivity implements SplashView {

    private static final int SPLASH_DURATION = 2000;

    private SplashPresenter mSplashPresenter;
    @BindView(R.id.iv_splash)
    ImageView mIvSplash;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData() {
        super.initData();
        /**
         * 1. 判断是否第一次登录。
         * 2. 已登录，进入主界面。
         * 3. 未登录，渐变动画进入注册登录页面。
         */
        mSplashPresenter = new SplashPresenterImpl(this);
        mSplashPresenter.isFirstLogin();
    }

    @Override
    public void onFirstLogin(boolean isFirstLogin) {
        if (isFirstLogin) {
            /**
             * 等待两秒进入主界面
             */
            ObjectAnimator animator = ObjectAnimator.ofFloat(mIvSplash, "alpha", 0, 1).setDuration(SPLASH_DURATION);
            animator.start();
            animator.addListener(new SimpleAnimatorListener() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    startActivity(SettingActivity.class, true);
                }
            });
        } else {
            /**
             * 开启服务或者跳转页面
             */
            startActivity(MainActivity.class, true);
        }
    }
}
