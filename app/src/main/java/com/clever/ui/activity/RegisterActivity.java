package com.clever.ui.activity;

import android.support.design.widget.TextInputLayout;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.clever.R;
import com.clever.base.AppBaseActivity;
import com.clever.presenter.RegisterPresenter;
import com.clever.presenter.impl.RegisterPresenterImpl;
import com.clever.ui.interf.RegisterView;
import com.cleverlib.utils.LogUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 注册页面
 *
 * @author liuhea
 * @date 2016/12/30
 *  
 */
public class RegisterActivity extends AppBaseActivity implements RegisterView, TextView.OnEditorActionListener {


    @BindView(R.id.et_login_username)
    EditText mEtLoginUsername;
    @BindView(R.id.til_login_username)
    TextInputLayout mTilLoginUsername;
    @BindView(R.id.et_login_pwd)
    EditText mEtLoginPwd;
    @BindView(R.id.til_login_pwd)
    TextInputLayout mTilLoginPwd;
    @BindView(R.id.btn_login)
    Button mBtnRegister;

    private RegisterPresenter mRegisterPresenter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initListener() {
        super.initListener();
        // 监听键盘输入 .
        mEtLoginPwd.setOnEditorActionListener(this);
    }

    @OnClick(R.id.btn_login)
    public void onClick() {
        registerUser();
    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (v.getId() == R.id.et_login_pwd && actionId == EditorInfo.IME_ACTION_DONE) {
            registerUser();
            return true;
        }
        return false;
    }

    /**
     * 注册新用户
     */
    private void registerUser() {
        String username = mEtLoginUsername.getText().toString().trim();
        String password = mEtLoginPwd.getText().toString().trim();

        mRegisterPresenter = new RegisterPresenterImpl(this);
        mRegisterPresenter.createUser(username, password);
    }

    @Override
    public void onRegisterUserSuccess() {
        Toast.makeText(mContext, "注册成功", Toast.LENGTH_SHORT).show();
        startActivity(LoginActivity.class, true);
    }

    @Override
    public void onRegisterUserFailed(String msg) {
        LogUtils.e(msg);
    }
}
