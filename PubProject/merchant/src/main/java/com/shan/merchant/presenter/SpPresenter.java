package com.shan.merchant.presenter;

import android.content.Context;

import com.shan.merchant.contract.SpContract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 商品
 * Created by chenjunshan on 2017-12-27.
 */

public class SpPresenter extends HttpPresenter implements SpContract.Presenter {
    private Context mContext;
    private SpContract.View mView;

    public SpPresenter(Context mContext, SpContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}