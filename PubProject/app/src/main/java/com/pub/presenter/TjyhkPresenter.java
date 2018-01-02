package com.pub.presenter;

import android.content.Context;

import com.pub.contract.TjyhkContract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 添加银行卡
 * Created by chenjunshan on 2018-01-02.
 */

public class TjyhkPresenter extends HttpPresenter implements TjyhkContract.Presenter {
    private Context mContext;
    private TjyhkContract.View mView;

    public TjyhkPresenter(Context mContext, TjyhkContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}