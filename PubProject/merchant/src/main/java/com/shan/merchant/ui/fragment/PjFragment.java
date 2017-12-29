package com.shan.merchant.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.shan.merchant.R;
import com.shan.merchant.contract.PjContract;
import com.shan.merchant.databinding.FgPjItemLayoutBinding;
import com.shan.merchant.presenter.PjPresenter;
import com.shan.merchant.ui.BaseFragment;
import com.shan.netlibrary.net.BaseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 评价
 * Created by chenjunshan on 2017-12-27.
 */

public class PjFragment extends BaseFragment<FgPjItemLayoutBinding, Object> implements PjContract.View {
    private PjPresenter presenter;

    @Override
    public int bindItemLayout() {
        return R.layout.fg_pj_item_layout;
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();

    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        presenter = new PjPresenter(getActivity(), this);

    }

    @Override
    public void onSuccess(BaseBean baseBean, long mTag) {

    }

    @Override
    public void onFailure(Throwable e, long mTag) {

    }

    @Override
    protected void getListVewItem(FgPjItemLayoutBinding binding, Object item, int position) {
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