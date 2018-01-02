package com.pub.ui.fragment.money;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.pub.R;
import com.pub.contract.WdxjqContract;
import com.pub.databinding.FgWdxjqItemLayoutBinding;
import com.pub.presenter.WdxjqPresenter;
import com.pub.ui.BaseFragment;
import com.shan.netlibrary.net.BaseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的现金券
 * Created by chenjunshan on 2018-01-02.
 */

public class WdxjqFragment extends BaseFragment<FgWdxjqItemLayoutBinding, Object> implements WdxjqContract.View {
    private WdxjqPresenter presenter;

    @Override
    public int bindItemLayout() {
        return R.layout.fg_wdxjq_item_layout;
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();

    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        presenter = new WdxjqPresenter(getActivity(), this);

    }

    @Override
    public void onSuccess(BaseBean baseBean, long mTag) {

    }

    @Override
    public void onFailure(Throwable e, long mTag) {

    }

    @Override
    protected void getListVewItem(FgWdxjqItemLayoutBinding binding, Object item, int position) {
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