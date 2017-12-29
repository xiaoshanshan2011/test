package com.shan.merchant.presenter;

import android.content.Context;

import com.shan.merchant.contract.PsfsszContract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 配送方式设置
 * Created by chenjunshan on 2017-12-27.
 */

public class PsfsszPresenter extends HttpPresenter implements PsfsszContract.Presenter {
    private Context mContext;
    private PsfsszContract.View mView;

    public PsfsszPresenter(Context mContext, PsfsszContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}