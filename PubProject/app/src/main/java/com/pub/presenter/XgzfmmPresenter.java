package com.pub.presenter;

import android.content.Context;

import com.pub.contract.XgzfmmContract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 修改支付密码
 * Created by chenjunshan on 2018-01-02.
 */

public class XgzfmmPresenter extends HttpPresenter implements XgzfmmContract.Presenter {
    private Context mContext;
    private XgzfmmContract.View mView;

    public XgzfmmPresenter(Context mContext, XgzfmmContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}