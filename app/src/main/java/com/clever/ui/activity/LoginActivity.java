package com.clever.ui.activity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.clever.R;
import com.clever.base.AppBaseActivity;

import butterknife.BindView;

public class LoginActivity extends AppBaseActivity {



    @BindView(R.id.et_login_username)
    EditText mEtUsername;
    @BindView(R.id.et_login_pwd)
    EditText mEtPwd;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.tv_login_newuser)
    TextView mTvNewuser;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        super.initData();

        /**
         * 1. 输入账号密码，校验是否已经存在
         * 2. 不存在：提示新建，如有需要跳转新建页面
         * 3. 存在：
         *  3.1 密码正确：MainActivity
         *  3.2 密码错误：提示
         */

    }

}
