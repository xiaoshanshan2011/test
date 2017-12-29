package com.shan.merchant.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.shan.merchant.R;
import com.shan.merchant.contract.RzxyContract;
import com.shan.merchant.databinding.FgRzxyLayoutBinding;
import com.shan.merchant.presenter.RzxyPresenter;
import com.shan.merchant.ui.BaseFragment;
import com.shan.netlibrary.net.BaseBean;

/**
 * 入驻协议
 * Created by chenjunshan on 2017-12-27.
 */

public class RzxyFragment extends BaseFragment<FgRzxyLayoutBinding, Object> implements RzxyContract.View {
    private RzxyPresenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.fg_rzxy_layout;
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();
        setTitle(R.string.str_rzxy);
    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        presenter = new RzxyPresenter(getActivity(), this);

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
        mBinding.btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(Rzsq1Fragment.class,null);
            }
        });
    }
}
