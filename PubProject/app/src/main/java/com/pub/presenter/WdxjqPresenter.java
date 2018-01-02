package com.pub.presenter;

import android.content.Context;

import com.pub.contract.WdxjqContract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 我的现金券
 * Created by chenjunshan on 2018-01-02.
 */

public class WdxjqPresenter extends HttpPresenter implements WdxjqContract.Presenter {
    private Context mContext;
    private WdxjqContract.View mView;

    public WdxjqPresenter(Context mContext, WdxjqContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}