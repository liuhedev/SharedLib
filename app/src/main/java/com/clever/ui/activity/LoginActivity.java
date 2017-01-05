package com.clever.ui.activity;

import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.clever.R;
import com.clever.base.AppBaseActivity;
import com.clever.presenter.LoginPresenter;
import com.clever.ui.interf.LoginView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登录页面
 *
 * @author liuhea
 * @date 2016/12/30
 *  
 */
public class LoginActivity extends AppBaseActivity implements LoginView {

    @BindView(R.id.et_login_username)
    EditText mEtUsername;
    @BindView(R.id.til_login_username)
    TextInputLayout mTilUsername;
    @BindView(R.id.et_login_pwd)
    EditText mEtPwd;
    @BindView(R.id.til_login_pwd)
    TextInputLayout mTilPwd;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.tv_login_newuser)
    TextView mTvNewuser;

    private String mUsername;
    private String mPassword;
    private LoginPresenter mLoginPresenter;

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

    @OnClick({R.id.btn_login, R.id.tv_login_newuser})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                login();
                break;

            case R.id.tv_login_newuser:
                startActivity(RegisterActivity.class, false);
                break;
        }
    }

    /**
     * 登录
     */
    private void login() {
        // 表单校验
        // 服务器校验
        startActivity(TempActivity.class,false);
//        String s = "王晓明".substring(0, 1).toUpperCase();
//        Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();
//        Toast.makeText(mContext, "登录逻辑", Toast.LENGTH_SHORT).show();
//        mLoginPresenter.checkUser(mUsername, mPassword);
    }
}
