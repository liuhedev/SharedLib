package com.clever.ui.activity;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.clever.R;
import com.clever.base.AppBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppBaseActivity {

    @BindView(R.id.bmapView)
    com.baidu.mapapi.map.MapView mMapView;

    private BaiduMap mBaiduMap;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onBeforeSetContentLayout() {
        super.onBeforeSetContentLayout();
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void onAfterSetContentLayout() {
        super.onAfterSetContentLayout();
        ButterKnife.bind(this);

    }

    @Override
    public void initData() {
        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }
}
