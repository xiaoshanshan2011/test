package com.pub.ui.fragment.money;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.pub.R;
import com.pub.contract.YeContract;
import com.pub.databinding.FgYeLayoutBinding;
import com.pub.presenter.YePresenter;
import com.pub.ui.BaseFragment;
import com.shan.netlibrary.net.BaseBean;

/**
 * 余额
 * Created by chenjunshan on 2018-01-02.
 */

public class YeFragment extends BaseFragment<FgYeLayoutBinding, Object> implements YeContract.View {
    private YePresenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.fg_ye_layout;
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();
        setTitle(R.string.str_ye);
        titleBinding.tvRight.setVisibility(View.VISIBLE);
        titleBinding.tvRight.setText(getString(R.string.str_mx));
    }

    @Override
    public void onRightClick() {
        super.onRightClick();
        startFragment(ZhmxFragment.class, null);
    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        presenter = new YePresenter(getActivity(), this);

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
