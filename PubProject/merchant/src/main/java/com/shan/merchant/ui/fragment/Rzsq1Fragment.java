package com.shan.merchant.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.junshan.pub.utils.ToastUtils;
import com.shan.merchant.R;
import com.shan.merchant.contract.Rzsq1Contract;
import com.shan.merchant.databinding.FgRzsq1LayoutBinding;
import com.shan.merchant.presenter.Rzsq1Presenter;
import com.shan.merchant.ui.BaseFragment;
import com.shan.merchant.widget.PhotoSelectDialog;
import com.shan.netlibrary.net.BaseBean;

/**
 * 入驻申请--第一步
 * Created by chenjunshan on 2017-12-27.
 */

public class Rzsq1Fragment extends BaseFragment<FgRzsq1LayoutBinding, Object> implements Rzsq1Contract.View {
    private Rzsq1Presenter presenter;
    private int position = 0;

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
        mBinding.ivYyzz.setOnClickListener(this);
        mBinding.ivZm.setOnClickListener(this);
        mBinding.ivFm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        int i = view.getId();
        if (i == R.id.btn_ok) {
            startFragment(Rzsq3Fragment.class, null);
        } else if (i == R.id.iv_zm) {
            position = 0;
            PhotoSelectDialog.open(this);
        } else if (i == R.id.iv_fm) {
            position = 1;
            PhotoSelectDialog.open(this);
        } else if (i == R.id.iv_yyzz) {
            position = 2;
            PhotoSelectDialog.open(this);
        }
    }

    @Override
    public void photoResult(String path) {
        super.photoResult(path);
        Glide.with(getActivity()).load(path).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                ToastUtils.toast(getString(R.string.str_sccg));
                if (position == 0) {
                    mBinding.ivZm.setBackgroundDrawable(resource);
                } else if (position == 1) {
                    mBinding.ivFm.setBackgroundDrawable(resource);
                } else if (position == 2) {
                    mBinding.ivYyzz.setBackgroundDrawable(resource);
                }
            }
        });
    }
}
