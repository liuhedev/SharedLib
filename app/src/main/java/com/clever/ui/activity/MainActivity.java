package com.clever.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.clever.R;
import com.clever.base.AppBaseActivity;
import com.clever.ui.fragment.Tab1Fragment;
import com.clever.ui.fragment.Tab2Fragment;
import com.clever.ui.fragment.Tab3Fragment;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends AppBaseActivity {
    @BindView(R.id.common_toolbar)
    Toolbar mCommonToolbar;
    @BindView(R.id.dl_main_slide)
    DrawerLayout mDlMainSlide;
    @BindView(R.id.ll_main_container)
    LinearLayout mLlMainContainer;
    @BindView(R.id.tb_main)
    TabLayout mTbMain;
    @BindView(R.id.vp_main)
    ViewPager mVpMain;
    private ArrayList<Fragment> mFragments;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDlMainSlide, mCommonToolbar, R.string.app_name, R.string.app_name);
        //同步状态
        drawerToggle.syncState();
        //  监听DrawerLayout的Drawer事件（把menu菜单的图像修改）
        mDlMainSlide.addDrawerListener(drawerToggle);

        // Fragment FragmentPagerAdapter联合使用 .
        intTabData();
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mVpMain.setAdapter(myPagerAdapter);

        // Tablayout 关联ViewPager .
        mTbMain.setupWithViewPager(mVpMain);

    }

    private void intTabData() {
        mFragments = new ArrayList<>();
        mFragments.add(setTab(new Tab1Fragment(), "tab1"));
        mFragments.add(setTab(new Tab2Fragment(), "tab2"));
        mFragments.add(setTab(new Tab3Fragment(), "tab3"));
    }

    private Fragment setTab(Fragment fragment, String title) {
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragments.get(position).getArguments().getString("title");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
