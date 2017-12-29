package com.shan.merchant.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.shan.merchant.R;
import com.shan.merchant.contract.SpContract;
import com.shan.merchant.databinding.FgSpLayoutBinding;
import com.shan.merchant.presenter.SpPresenter;
import com.shan.merchant.ui.BaseFragment;
import com.shan.netlibrary.net.BaseBean;

/**
 * 商品
 * Created by chenjunshan on 2017-12-27.
 */

public class SpFragment extends BaseFragment<FgSpLayoutBinding, Object> implements SpContract.View {
    private SpPresenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.fg_sp_layout;
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();

    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        presenter = new SpPresenter(getActivity(), this);

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
