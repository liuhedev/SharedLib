package com.clever.base;


import com.cleverlib.base.BaseActivity;

import butterknife.ButterKnife;


/**
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


}
