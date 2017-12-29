package com.shan.merchant.presenter;

import android.content.Context;

import com.shan.merchant.contract.TjspylContract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 添加商品预览
 * Created by chenjunshan on 2017-12-27.
 */

public class TjspylPresenter extends HttpPresenter implements TjspylContract.Presenter {
    private Context mContext;
    private TjspylContract.View mView;

    public TjspylPresenter(Context mContext, TjspylContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}