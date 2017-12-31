package com.shan.merchant.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.junshan.pub.dialog.BottomSelectDialog;
import com.shan.merchant.R;
import com.shan.merchant.contract.Rzsq3Contract;
import com.shan.merchant.databinding.FgRzsq3LayoutBinding;
import com.shan.merchant.presenter.Rzsq3Presenter;
import com.shan.merchant.ui.BaseFragment;
import com.shan.netlibrary.net.BaseBean;

import java.util.ArrayList;
import java.util.List;

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
        mBinding.tvJylx.setOnClickListener(this);
        mBinding.tvShlx.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        int i = view.getId();
        if (i == R.id.btn_ok) {
            startFragment(Rzsq4Fragment.class, null);
        } else if (i == R.id.tv_shlx) {
            show1();
        } else if (i == R.id.tv_jylx) {
            show2();
        }
    }

    private BottomSelectDialog dialog1;
    private BottomSelectDialog dialog2;
    private int tempPos1;
    private int tempPos2;
    private List<String> data1;
    private List<String> data2;

    private void show1() {
        if (dialog1 == null) {
            data1 = new ArrayList<>();
            data1.add("企业");
            data1.add("个人");
            dialog1 = new BottomSelectDialog(getActivity()) {
                @Override
                protected void onSuccess(int position, String content) {
                    tempPos1 = position;
                    mBinding.tvShlx.setText(content);
                }
            };
        }
        dialog1.show(data1, tempPos1);
    }

    private void show2() {
        if (dialog2 == null) {
            data2 = new ArrayList<>();
            data2.add("企业");
            data2.add("个人");
            dialog2 = new BottomSelectDialog(getActivity()) {
                @Override
                protected void onSuccess(int position, String content) {
                    tempPos2 = position;
                    mBinding.tvJylx.setText(content);
                }
            };
        }
        dialog2.show(data2, tempPos2);
    }
}
