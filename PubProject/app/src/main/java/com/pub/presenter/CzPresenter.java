package com.pub.presenter;

import android.content.Context;

import com.pub.contract.CzContract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 充值
 * Created by chenjunshan on 2018-01-02.
 */

public class CzPresenter extends HttpPresenter implements CzContract.Presenter {
    private Context mContext;
    private CzContract.View mView;

    public CzPresenter(Context mContext, CzContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}