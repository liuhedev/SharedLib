package com.clever.ui.activity;

import com.clever.R;
import com.clever.base.AppBaseActivity;

public class MainActivity extends AppBaseActivity {

//    @BindView(R.id.bmapView)
//    com.baidu.mapapi.map.MapView mMapView;
//
//    private BaiduMap mBaiduMap;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
//        mBaiduMap = mMapView.getMap();
//        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mMapView.onDestroy();
    }
}
