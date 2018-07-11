package com.example.andriod_pan.appframe.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.andriod_pan.appframe.R;
import com.example.andriod_pan.appframe.activity.contract.LoginContract;
import com.example.andriod_pan.appframe.activity.model.LoginModel;
import com.example.andriod_pan.appframe.activity.presenter.LoginPresenter;
import com.example.andriod_pan.appframe.base.BaseActivity;
import com.example.andriod_pan.appframe.utils.JumpUtil;
import com.example.andriod_pan.appframe.utils.ToastUtil;

public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View, View.OnClickListener {

    EditText et_mobile;
    Button btn_next;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        et_mobile = findViewById(R.id.et_mobile);
        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);
    }

    @Override
    public void loginSuccess() {
        JumpUtil.GotoActivity(this, MainActivity.class);
    }

    @Override
    public void showMsg(String msg) {
        ToastUtil.show(msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_next:
                mPresenter.login(et_mobile.getText().toString().trim());

                break;

        }
    }
}