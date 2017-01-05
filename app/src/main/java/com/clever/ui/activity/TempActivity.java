package com.clever.ui.activity;

import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.clever.R;
import com.clever.base.AppBaseActivity;
import com.clever.ui.fragment.TempFragment;

import butterknife.BindView;

public class TempActivity extends AppBaseActivity {
    @BindView(R.id.common_framelayout)
    FrameLayout mCommonFramelayout;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_temp;
    }

    @Override
    protected void initData() {
        super.initData();
//        对话框:DialogFragment
//        列表:ListFragment
//        选项设置:PreferenceFragment
//        WebView界面:WebViewFragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        TempFragment tempFragment = new TempFragment();
        fragmentTransaction.add(R.id.common_framelayout,tempFragment,"dd");
        fragmentTransaction.commit();
    }
}
