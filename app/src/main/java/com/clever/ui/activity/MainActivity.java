package com.clever.ui.activity;


import android.support.v7.widget.RecyclerView;

import com.clever.R;
import com.clever.base.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.common_view_recycler)
    RecyclerView mRecyclerView;

    RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<String> mDataList;

    public static void actionStart() {
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initListener() {
    }

    @Override
    protected void initData() {

        mDataList = getTestData();
    }


    private ArrayList getTestData() {
        ArrayList<String> dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dataList.add("测试数据" + i);
        }
        return dataList;
    }


}
