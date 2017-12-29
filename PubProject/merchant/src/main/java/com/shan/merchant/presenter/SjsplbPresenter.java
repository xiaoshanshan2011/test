package com.shan.merchant.presenter;

import android.content.Context;

import com.shan.merchant.contract.SjsplbContract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 商家--商品列表
 * Created by chenjunshan on 2017-12-29.
 */

public class SjsplbPresenter extends HttpPresenter implements SjsplbContract.Presenter {
    private Context mContext;
    private SjsplbContract.View mView;

    public SjsplbPresenter(Context mContext, SjsplbContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}