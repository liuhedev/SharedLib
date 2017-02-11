package com.clever.ui.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.clever.R;
import com.clever.base.AppBaseActivity;

public class AppBarActivity extends AppBaseActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_appbar;
    }

    @Override
    protected void onAfterSetContentLayout(Bundle savedInstanceState) {
        super.onAfterSetContentLayout(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
