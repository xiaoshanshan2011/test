package com.shan.merchant.presenter;

import android.content.Context;

import com.shan.merchant.contract.TjspContract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 添加商品
 * Created by chenjunshan on 2017-12-27.
 */

public class TjspPresenter extends HttpPresenter implements TjspContract.Presenter {
    private Context mContext;
    private TjspContract.View mView;

    public TjspPresenter(Context mContext, TjspContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}