package com.clever.ui.activity;

import android.widget.TextView;

import com.clever.R;
import com.clever.base.AppBaseActivity;
import com.cleverlib.utils.NetworkUtils;

import butterknife.BindView;

public class MainActivity extends AppBaseActivity {

    @BindView(R.id.tv)
    TextView mTv;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
    }


    @Override
    public void initData() {
        mTv.setText(NetworkUtils.getNetworkTypeName(mContext));
    }
}
