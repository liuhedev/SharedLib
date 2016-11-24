package com.clever.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Activity基类
 *
 * @author liuhea
 * @created 16-11-24
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        initView();
        initListener();
        initData();

    }

    protected abstract int getLayoutResId();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract void initData();


}
