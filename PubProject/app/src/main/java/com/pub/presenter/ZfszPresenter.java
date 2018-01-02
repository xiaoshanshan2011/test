package com.pub.presenter;

import android.content.Context;

import com.pub.contract.ZfszContract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 支付设置
 * Created by chenjunshan on 2018-01-02.
 */

public class ZfszPresenter extends HttpPresenter implements ZfszContract.Presenter {
    private Context mContext;
    private ZfszContract.View mView;

    public ZfszPresenter(Context mContext, ZfszContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}