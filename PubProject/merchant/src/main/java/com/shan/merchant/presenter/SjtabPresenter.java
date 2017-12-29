package com.shan.merchant.presenter;

import android.content.Context;

import com.shan.merchant.contract.SjtabContract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 商家Tab
 * Created by chenjunshan on 2017-12-27.
 */

public class SjtabPresenter extends HttpPresenter implements SjtabContract.Presenter {
    private Context mContext;
    private SjtabContract.View mView;

    public SjtabPresenter(Context mContext, SjtabContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}