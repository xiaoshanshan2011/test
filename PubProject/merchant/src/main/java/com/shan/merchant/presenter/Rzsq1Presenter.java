package com.shan.merchant.presenter;

import android.content.Context;

import com.shan.merchant.contract.Rzsq1Contract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 入驻申请--第一步
 * Created by chenjunshan on 2017-12-27.
 */

public class Rzsq1Presenter extends HttpPresenter implements Rzsq1Contract.Presenter {
    private Context mContext;
    private Rzsq1Contract.View mView;

    public Rzsq1Presenter(Context mContext, Rzsq1Contract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}