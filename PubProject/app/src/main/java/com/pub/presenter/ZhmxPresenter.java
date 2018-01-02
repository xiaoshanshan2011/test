package com.pub.presenter;

import android.content.Context;

import com.pub.contract.ZhmxContract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 账户明细
 * Created by chenjunshan on 2018-01-02.
 */

public class ZhmxPresenter extends HttpPresenter implements ZhmxContract.Presenter {
    private Context mContext;
    private ZhmxContract.View mView;

    public ZhmxPresenter(Context mContext, ZhmxContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}