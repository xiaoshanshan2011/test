package com.shan.merchant.presenter;

import android.content.Context;

import com.shan.merchant.contract.PjContract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 评价
 * Created by chenjunshan on 2017-12-27.
 */

public class PjPresenter extends HttpPresenter implements PjContract.Presenter {
    private Context mContext;
    private PjContract.View mView;

    public PjPresenter(Context mContext, PjContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}