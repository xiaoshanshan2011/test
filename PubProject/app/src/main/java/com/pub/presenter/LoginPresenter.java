package com.pub.presenter;

import android.content.Context;

import com.pub.contract.LoginContract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 登录
 * Created by chenjunshan on 2017-12-19.
 */

public class LoginPresenter extends HttpPresenter implements LoginContract.Presenter {
    private Context mContext;
    private LoginContract.View mView;

    public LoginPresenter(Context mContext, LoginContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}
