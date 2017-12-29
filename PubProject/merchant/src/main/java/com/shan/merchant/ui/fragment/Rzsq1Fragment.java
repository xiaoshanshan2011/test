package com.shan.merchant.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.shan.merchant.R;
import com.shan.merchant.contract.Rzsq1Contract;
import com.shan.merchant.databinding.FgRzsq1LayoutBinding;
import com.shan.merchant.presenter.Rzsq1Presenter;
import com.shan.merchant.ui.BaseFragment;
import com.shan.netlibrary.net.BaseBean;

/**
 * 入驻申请--第一步
 * Created by chenjunshan on 2017-12-27.
 */

public class Rzsq1Fragment extends BaseFragment<FgRzsq1LayoutBinding, Object> implements Rzsq1Contract.View {
    private Rzsq1Presenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.fg_rzsq1_layout;
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();
        setTitle(R.string.str_rzsq);
    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        presenter = new Rzsq1Presenter(getActivity(), this);

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
        mBinding.btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        int i = view.getId();
        if (i == R.id.btn_ok) {
            startFragment(Rzsq3Fragment.class, null);
        }
    }
}
