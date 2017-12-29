package com.shan.merchant.presenter;

import android.content.Context;

import com.shan.merchant.contract.Rzsq4Contract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 入驻申请--第四步
 * Created by chenjunshan on 2017-12-27.
 */

public class Rzsq4Presenter extends HttpPresenter implements Rzsq4Contract.Presenter {
    private Context mContext;
    private Rzsq4Contract.View mView;

    public Rzsq4Presenter(Context mContext, Rzsq4Contract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}