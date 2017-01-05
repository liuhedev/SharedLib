package com.clever.ui.activity;

import android.widget.Toast;

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
        String s = "王晓明".substring(0, 1).toUpperCase();
        Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mMapView.onDestroy();
    }
}
