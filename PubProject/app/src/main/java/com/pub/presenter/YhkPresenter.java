package com.pub.presenter;

import android.content.Context;

import com.pub.contract.YhkContract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 银行卡
 * Created by chenjunshan on 2018-01-02.
 */

public class YhkPresenter extends HttpPresenter implements YhkContract.Presenter {
    private Context mContext;
    private YhkContract.View mView;

    public YhkPresenter(Context mContext, YhkContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}