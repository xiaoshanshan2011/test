package com.shan.merchant.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.shan.merchant.R;
import com.shan.merchant.contract.Rzsq4Contract;
import com.shan.merchant.databinding.FgRzsq4LayoutBinding;
import com.shan.merchant.presenter.Rzsq4Presenter;
import com.shan.merchant.ui.BaseFragment;
import com.shan.netlibrary.net.BaseBean;

/**
 * 入驻申请--第四步
 * Created by chenjunshan on 2017-12-27.
 */

public class Rzsq4Fragment extends BaseFragment<FgRzsq4LayoutBinding, Object> implements Rzsq4Contract.View {
    private Rzsq4Presenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.fg_rzsq4_layout;
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();
        setTitle(R.string.str_qrxx);
    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        presenter = new Rzsq4Presenter(getActivity(), this);

    }

    @Override
    public void onSuccess(BaseBean baseBean, long mTag) {

    }

    @Override
    public void onFailure(Throwable e, long mTag) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.cancelAllRequest();
    }

    @Override
    protected void initEvent() {
        super.initEvent();

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {

        }
    }
}
