package com.shan.merchant.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.shan.merchant.R;
import com.shan.merchant.contract.SjsplbContract;
import com.shan.merchant.databinding.FgSjsplbItemLayoutBinding;
import com.shan.merchant.presenter.SjsplbPresenter;
import com.shan.merchant.ui.BaseFragment;
import com.shan.netlibrary.net.BaseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 商家--商品列表
 * Created by chenjunshan on 2017-12-29.
 */

public class SjsplbFragment extends BaseFragment<FgSjsplbItemLayoutBinding, Object> implements SjsplbContract.View {
    private SjsplbPresenter presenter;

    @Override
    public int bindItemLayout() {
        return R.layout.fg_sjsplb_item_layout;
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();
        titleBinding.getRoot().setVisibility(View.GONE);
    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        lvBinding.getRoot().setBackgroundColor(Color.WHITE);
        presenter = new SjsplbPresenter(getActivity(), this);
        setRecycViewGrid(2);
    }

    @Override
    public void onSuccess(BaseBean baseBean, long mTag) {

    }

    @Override
    public void onFailure(Throwable e, long mTag) {

    }

    @Override
    protected void getListVewItem(FgSjsplbItemLayoutBinding binding, Object item, int position) {
        super.getListVewItem(binding, item, position);

    }

    @Override
    public void onRefresh() {
        super.onRefresh();

    }

    @Override
    public void onLoadMore() {
        super.onLoadMore();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.cancelAllRequest();
    }

    @Override
    protected void initData() {
        super.initData();
        List<Object> data = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            data.add("");
        }
        setData(data);
    }
}