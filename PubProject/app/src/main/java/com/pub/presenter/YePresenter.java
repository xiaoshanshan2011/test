package com.pub.presenter;

import android.content.Context;

import com.pub.contract.YeContract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 余额
 * Created by chenjunshan on 2018-01-02.
 */

public class YePresenter extends HttpPresenter implements YeContract.Presenter {
    private Context mContext;
    private YeContract.View mView;

    public YePresenter(Context mContext, YeContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}