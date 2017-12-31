package com.shan.merchant.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.junshan.pub.adapter.CommonAdapter;
import com.shan.merchant.R;
import com.shan.merchant.bean.SplbBean;
import com.shan.merchant.contract.SdContract;
import com.shan.merchant.databinding.FgSdItemLayoutBinding;
import com.shan.merchant.databinding.FgSdLayoutBinding;
import com.shan.merchant.presenter.SdPresenter;
import com.shan.merchant.ui.BaseFragment;
import com.shan.netlibrary.net.BaseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 商店
 * Created by chenjunshan on 2017-12-27.
 */

public class SdFragment extends BaseFragment<FgSdLayoutBinding, Object> implements SdContract.View {
    private SdPresenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.fg_sd_layout;
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();
        setTitle(R.string.str_sd);
        titleBinding.getRoot().setVisibility(View.GONE);
    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        presenter = new SdPresenter(getActivity(), this);

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

    @Override
    protected void initData() {
        super.initData();
        List<SplbBean> data = new ArrayList<>();
        data.add(new SplbBean("", ""));
        data.add(new SplbBean("", ""));
        data.add(new SplbBean("", ""));
        data.add(new SplbBean("", ""));
        data.add(new SplbBean("", ""));
        data.add(new SplbBean("", ""));
        data.add(new SplbBean("", ""));
        data.add(new SplbBean("", ""));

        mBinding.gv.setAdapter(new CommonAdapter<FgSdItemLayoutBinding, SplbBean>(getActivity(), R.layout.fg_sd_item_layout, data) {
            @Override
            protected void getItem(FgSdItemLayoutBinding binding, SplbBean bean, int position) {

            }

            @Override
            protected void itemOnclick(FgSdItemLayoutBinding binding, SplbBean bean, int position) {

            }
        });
    }
}
