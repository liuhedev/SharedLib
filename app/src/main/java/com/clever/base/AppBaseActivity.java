package com.clever.base;


import android.content.Intent;

import com.cleverlib.base.BaseActivity;

import butterknife.ButterKnife;


/**
 * Clever Activity基类
 *
 * @author liuhea .
 * @created 16-12-2 .
 */
public class AppBaseActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() {
        return 0;
    }

    @Override
    protected void onBeforeSetContentLayout() {
        super.onBeforeSetContentLayout();
    }

    @Override
    protected void onAfterSetContentLayout() {
        super.onAfterSetContentLayout();
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initListener() {
    }

    @Override
    protected void initData() {
    }

    protected void startActivity(Class clazz, boolean isFinishSelf) {
        startActivity(new Intent(this, clazz));
        if (isFinishSelf) {
            finish();
        }
    }

    protected String getResString(int stringId) {
        return getResources().getString(stringId);
    }
}
