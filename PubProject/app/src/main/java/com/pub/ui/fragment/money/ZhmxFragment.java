package com.pub.ui.fragment.money;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.pub.R;
import com.pub.contract.ZhmxContract;
import com.pub.databinding.FgZhmxItemLayoutBinding;
import com.pub.presenter.ZhmxPresenter;
import com.pub.ui.BaseFragment;
import com.shan.netlibrary.net.BaseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 账户明细
 * Created by chenjunshan on 2018-01-02.
 */

public class ZhmxFragment extends BaseFragment<FgZhmxItemLayoutBinding, Object> implements ZhmxContract.View {
    private ZhmxPresenter presenter;

    @Override
    public int bindItemLayout() {
        return R.layout.fg_zhmx_item_layout;
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();

    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        presenter = new ZhmxPresenter(getActivity(), this);

    }

    @Override
    public void onSuccess(BaseBean baseBean, long mTag) {

    }

    @Override
    public void onFailure(Throwable e, long mTag) {

    }

    @Override
    protected void getListVewItem(FgZhmxItemLayoutBinding binding, Object item, int position) {
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