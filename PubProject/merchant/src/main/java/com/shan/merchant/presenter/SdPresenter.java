package com.shan.merchant.presenter;

import android.content.Context;

import com.shan.merchant.contract.SdContract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 商店
 * Created by chenjunshan on 2017-12-27.
 */

public class SdPresenter extends HttpPresenter implements SdContract.Presenter {
    private Context mContext;
    private SdContract.View mView;

    public SdPresenter(Context mContext, SdContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}