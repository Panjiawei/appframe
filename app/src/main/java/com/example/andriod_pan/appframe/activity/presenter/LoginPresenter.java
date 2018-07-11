package com.example.andriod_pan.appframe.activity.presenter;

import android.util.Log;

import com.example.andriod_pan.appframe.activity.contract.LoginContract;
import com.example.andriod_pan.appframe.activity.model.LoginModel;
import com.example.andriod_pan.appframe.base.BaseView;
import com.example.andriod_pan.appframe.model.BaseJson;
import com.google.gson.Gson;

/**
 * Created by andriod_pan on 2018/7/11.
 */

public class LoginPresenter extends LoginContract.Presenter {

    @Override
    public void login(String ph) {


//        BaseJson baseJson = new Gson().fromJson(mModel.login(ph), BaseJson.class);
//
//        if (baseJson.code == 200 || baseJson.code == 601) {
//            mView.showMsg("登陆成功");
//            mView.loginSuccess();
//        } else {
//            mView.showMsg("登陆失败");
//        }
        mModel.login(ph, new LoginModel.OnLoginResultListener() {
            @Override
            public void loginSuccess(String s) {
                BaseJson baseJson = new Gson().fromJson(s, BaseJson.class);
                Log.e("String",baseJson.toString());
                Log.e("String",s);
                mView.loginSuccess();
                if (baseJson.code == 200 || baseJson.code == 601) {
                    mView.showMsg("登陆成功");
                    Log.e("showMsg",baseJson.toString());
                    mView.loginSuccess();
                } else {
                    Log.e("showMsg",baseJson.toString());
                    mView.showMsg("登陆失败");
                }
            }

            @Override
            public void loginFailure() {
                mView.showMsg("登陆失败");
            }
        });


    }
}
