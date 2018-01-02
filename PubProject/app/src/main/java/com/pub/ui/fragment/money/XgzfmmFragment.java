package com.pub.ui.fragment.money;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.pub.R;
import com.pub.contract.XgzfmmContract;
import com.pub.databinding.FgXgzfmmLayoutBinding;
import com.pub.presenter.XgzfmmPresenter;
import com.pub.ui.BaseFragment;
import com.shan.netlibrary.net.BaseBean;

/**
 * 修改支付密码
 * Created by chenjunshan on 2018-01-02.
 */

public class XgzfmmFragment extends BaseFragment<FgXgzfmmLayoutBinding, Object> implements XgzfmmContract.View {
    private XgzfmmPresenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.fg_xgzfmm_layout;
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();

    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        presenter = new XgzfmmPresenter(getActivity(), this);

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
