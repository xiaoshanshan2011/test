package com.pub.presenter;

import android.content.Context;

import com.pub.contract.TxContract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 提现
 * Created by chenjunshan on 2018-01-02.
 */

public class TxPresenter extends HttpPresenter implements TxContract.Presenter {
    private Context mContext;
    private TxContract.View mView;

    public TxPresenter(Context mContext, TxContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}