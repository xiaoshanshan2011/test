package com.shan.merchant.presenter;

import android.content.Context;

import com.shan.merchant.contract.Test211Contract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 侧滑菜单
 * Created by chenjunshan on 2017-12-22.
 */

public class Test211Presenter extends HttpPresenter implements Test211Contract.Presenter {
    private Context mContext;
    private Test211Contract.View mView;

    public Test211Presenter(Context mContext, Test211Contract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}