package com.shan.merchant.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.shan.merchant.R;
import com.shan.merchant.contract.Test211Contract;
import com.shan.merchant.databinding.FgTest211ItemLayoutBinding;
import com.shan.merchant.presenter.Test211Presenter;
import com.shan.merchant.ui.BaseFragment;
import com.shan.netlibrary.net.BaseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 侧滑菜单
 * Created by chenjunshan on 2017-12-22.
 */

public class Test211Fragment extends BaseFragment<FgTest211ItemLayoutBinding, Object> implements Test211Contract.View {
    private Test211Presenter presenter;

    @Override
    public int bindItemLayout() {
        return R.layout.fg_test211_item_layout;
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();

    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        presenter = new Test211Presenter(getActivity(), this);

    }

    @Override
    public void onSuccess(BaseBean baseBean, long mTag) {

    }

    @Override
    public void onFailure(Throwable e, long mTag) {

    }

    @Override
    protected void getListVewItem(FgTest211ItemLayoutBinding binding, Object item, int position) {
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