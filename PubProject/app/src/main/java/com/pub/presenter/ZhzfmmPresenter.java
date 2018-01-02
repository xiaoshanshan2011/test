package com.pub.presenter;

import android.content.Context;

import com.pub.contract.ZhzfmmContract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 找回支付密码
 * Created by chenjunshan on 2018-01-02.
 */

public class ZhzfmmPresenter extends HttpPresenter implements ZhzfmmContract.Presenter {
    private Context mContext;
    private ZhzfmmContract.View mView;

    public ZhzfmmPresenter(Context mContext, ZhzfmmContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}