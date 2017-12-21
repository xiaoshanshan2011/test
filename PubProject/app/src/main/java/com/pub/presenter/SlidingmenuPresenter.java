package com.pub.presenter;

import android.content.Context;

import com.pub.contract.SlidingmenuContract;
import com.pub.net.HttpPresenter;

/**
 * 侧滑菜单
 * Created by chenjunshan on 2017-12-21.
 */

public class SlidingmenuPresenter extends HttpPresenter implements SlidingmenuContract.Presenter {
    private Context mContext;
    private SlidingmenuContract.View mView;

    public SlidingmenuPresenter(Context mContext, SlidingmenuContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }
}
