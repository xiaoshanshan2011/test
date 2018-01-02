package com.pub.ui.fragment.money;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.pub.R;
import com.pub.contract.YhkContract;
import com.pub.databinding.FgYhkItemLayoutBinding;
import com.pub.presenter.YhkPresenter;
import com.pub.ui.BaseFragment;
import com.shan.netlibrary.net.BaseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 银行卡
 * Created by chenjunshan on 2018-01-02.
 */

public class YhkFragment extends BaseFragment<FgYhkItemLayoutBinding, Object> implements YhkContract.View {
    private YhkPresenter presenter;

    @Override
    public int bindItemLayout() {
        return R.layout.fg_yhk_item_layout;
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();

    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        presenter = new YhkPresenter(getActivity(), this);

    }

    @Override
    public void onSuccess(BaseBean baseBean, long mTag) {

    }

    @Override
    public void onFailure(Throwable e, long mTag) {

    }

    @Override
    protected void getListVewItem(FgYhkItemLayoutBinding binding, Object item, int position) {
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