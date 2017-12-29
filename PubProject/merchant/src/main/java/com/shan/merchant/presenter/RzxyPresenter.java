package com.shan.merchant.presenter;

import android.content.Context;

import com.shan.merchant.contract.RzxyContract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 入住协议
 * Created by chenjunshan on 2017-12-27.
 */

public class RzxyPresenter extends HttpPresenter implements RzxyContract.Presenter {
    private Context mContext;
    private RzxyContract.View mView;

    public RzxyPresenter(Context mContext, RzxyContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}