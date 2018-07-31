package com.liuhe.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Activity基类
 *
 * @author liuhea
 * @created 16-11-24
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected static final String TAG = BaseActivity.class.getSimpleName();
    protected Activity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

        onBeforeSetContentLayout();
        setContentView(getLayoutResId());
        onAfterSetContentLayout(savedInstanceState);

        initView();
        initListener();
        initData();

    }

    protected void onBeforeSetContentLayout() {
    }

    protected void onAfterSetContentLayout(Bundle savedInstanceState) {
    }

    protected abstract int getLayoutResId();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
