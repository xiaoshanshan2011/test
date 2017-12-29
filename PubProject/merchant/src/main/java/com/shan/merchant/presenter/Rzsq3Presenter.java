package com.shan.merchant.presenter;

import android.content.Context;

import com.shan.merchant.contract.Rzsq3Contract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 入驻申请--第三步
 * Created by chenjunshan on 2017-12-27.
 */

public class Rzsq3Presenter extends HttpPresenter implements Rzsq3Contract.Presenter {
    private Context mContext;
    private Rzsq3Contract.View mView;

    public Rzsq3Presenter(Context mContext, Rzsq3Contract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}