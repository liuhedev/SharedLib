package com.clever.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.clever.R;
import com.clever.base.AppBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppBaseActivity {
    @BindView(R.id.common_toolbar)
    Toolbar mCommonToolbar;
    @BindView(R.id.dl_main_slide)
    DrawerLayout mDlMainSlide;
    @BindView(R.id.ll_main_container)
    LinearLayout mLlMainContainer;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        mCommonToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.__leak_canary_icon));
        mCommonToolbar.setTitle("toobar");

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,mDlMainSlide,mCommonToolbar,R.string.app_name,R.string.app_name);
        //同步状态
        drawerToggle.syncState();
        //  监听DrawerLayout的Drawer事件（把menu菜单的图像修改）
        mDlMainSlide.addDrawerListener(drawerToggle);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
