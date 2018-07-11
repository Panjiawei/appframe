package com.example.andriod_pan.appframe.activity.presenter;

import com.example.andriod_pan.appframe.activity.contract.LoginContract;
import com.example.andriod_pan.appframe.base.BaseView;
import com.example.andriod_pan.appframe.model.BaseJson;
import com.google.gson.Gson;

/**
 * Created by andriod_pan on 2018/7/11.
 */

public class LoginPresenter extends LoginContract.Presenter {

    @Override
    public void login(String ph) {


        BaseJson baseJson = new Gson().fromJson(mModel.login(ph), BaseJson.class);

        if (baseJson.code == 200 || baseJson.code == 601) {
            mView.showMsg("登陆成功");
            mView.loginSuccess();
        } else {
            mView.showMsg("登陆失败");
        }

    }
}
