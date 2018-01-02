package com.pub.ui.fragment.money;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.pub.R;
import com.pub.contract.WdqbContract;
import com.pub.databinding.FgWdqbLayoutBinding;
import com.pub.presenter.WdqbPresenter;
import com.pub.ui.BaseFragment;
import com.shan.netlibrary.net.BaseBean;

/**
 * 我的钱包
 * Created by chenjunshan on 2018-01-02.
 */

public class WdqbFragment extends BaseFragment<FgWdqbLayoutBinding, Object> implements WdqbContract.View {
    private WdqbPresenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.fg_wdqb_layout;
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();
        setTitle(R.string.str_wdqb);
    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        presenter = new WdqbPresenter(getActivity(), this);

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
}
