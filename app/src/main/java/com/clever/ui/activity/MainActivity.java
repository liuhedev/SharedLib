package com.clever.ui.activity;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.clever.R;
import com.clever.base.AppBaseActivity;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppBaseActivity {

    @BindView(R.id.tv)
    TextView mTv;

    @BindString(R.string.app_name)
    String mString;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
    }


    @Override
    public void initData() {
        mTv.setText(mString);
    }

    @OnClick(R.id.tv)
    public void testClick(View view) {
        Toast.makeText(mContext, "test", Toast.LENGTH_SHORT).show();
    }

}
