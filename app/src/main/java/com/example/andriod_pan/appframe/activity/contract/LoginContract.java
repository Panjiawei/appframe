package com.example.andriod_pan.appframe.activity.contract;

import com.example.andriod_pan.appframe.base.BaseModel;
import com.example.andriod_pan.appframe.base.BasePresenter;
import com.example.andriod_pan.appframe.base.BaseView;

/**
 * Created by andriod_pan on 2018/7/11.
 */

public interface LoginContract {

    interface View extends BaseView {
        void loginSuccess();

        void showMsg(String msg);
    }

    interface Model extends BaseModel {
        String login(String username);
    }

    abstract class Presenter extends BasePresenter<Model, View> {

        @Override
        public void onStart() {

        }

        public abstract void login(String username);
    }

}