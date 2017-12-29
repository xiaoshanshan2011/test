package com.shan.merchant.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.shan.merchant.R;
import com.shan.merchant.contract.Rzsq3Contract;
import com.shan.merchant.databinding.FgRzsq3LayoutBinding;
import com.shan.merchant.presenter.Rzsq3Presenter;
import com.shan.merchant.ui.BaseFragment;
import com.shan.netlibrary.net.BaseBean;

/**
 * 入驻申请--第三步
 * Created by chenjunshan on 2017-12-27.
 */

public class Rzsq3Fragment extends BaseFragment<FgRzsq3LayoutBinding, Object> implements Rzsq3Contract.View {
    private Rzsq3Presenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.fg_rzsq3_layout;
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();
        setTitle(R.string.str_shxx);
    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        presenter = new Rzsq3Presenter(getActivity(), this);

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
            startFragment(Rzsq4Fragment.class, null);
        }
    }
}
