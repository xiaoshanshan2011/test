package com.pub.ui.fragment.money;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.pub.R;
import com.pub.contract.TjyhkContract;
import com.pub.databinding.FgTjyhkLayoutBinding;
import com.pub.presenter.TjyhkPresenter;
import com.pub.ui.BaseFragment;
import com.shan.netlibrary.net.BaseBean;

/**
 * 添加银行卡
 * Created by chenjunshan on 2018-01-02.
 */

public class TjyhkFragment extends BaseFragment<FgTjyhkLayoutBinding, Object> implements TjyhkContract.View {
    private TjyhkPresenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.fg_tjyhk_layout;
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();

    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        presenter = new TjyhkPresenter(getActivity(), this);

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
