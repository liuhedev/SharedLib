package com.clever.ui.activity;

import android.util.Log;

import com.clever.R;
import com.clever.base.BaseActivity;

public class MainActivity extends BaseActivity {

    public static void actionStart(){

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        Log.d("MainActivity", "dd");

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
