package com.pub.presenter;

import android.content.Context;

import com.pub.contract.WdqbContract;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 我的钱包
 * Created by chenjunshan on 2018-01-02.
 */

public class WdqbPresenter extends HttpPresenter implements WdqbContract.Presenter {
    private Context mContext;
    private WdqbContract.View mView;

    public WdqbPresenter(Context mContext, WdqbContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}