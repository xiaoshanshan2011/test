package com.shan.merchant.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;

import com.junshan.pub.adapter.ViewPagerAdapter;
import com.junshan.pub.utils.AppUtils;
import com.shan.merchant.R;
import com.shan.merchant.contract.SjtabContract;
import com.shan.merchant.databinding.FgSjtabLayoutBinding;
import com.shan.merchant.presenter.SjtabPresenter;
import com.shan.merchant.ui.BaseFragment;
import com.shan.netlibrary.net.BaseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 商家Tab
 * Created by chenjunshan on 2017-12-27.
 */

public class SjtabFragment extends BaseFragment<FgSjtabLayoutBinding, Object> implements SjtabContract.View {
    private SjtabPresenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.fg_sjtab_layout;
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();
        titleBinding.getRoot().setVisibility(View.GONE);
    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        setStatusBar();
        presenter = new SjtabPresenter(getActivity(), this);
        SdFragment tab1 = new SdFragment();
        SpFragment tab2 = new SpFragment();
        List<Fragment> list = new ArrayList<>();
        list.add(tab1);
        list.add(tab2);
        List<String> titles = new ArrayList<>();
        titles.add(getString(R.string.str_sd));
        titles.add(getString(R.string.str_sp));
        mBinding.viewPager.setAdapter(new ViewPagerAdapter(getActivity().getSupportFragmentManager(), list, titles));
        mBinding.tabs.setViewPager(mBinding.viewPager);
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
        mBinding.btnLeft.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        int i = view.getId();
        if (i == R.id.btn_left) {
            getActivity().finish();
        }
    }

    /**
     * 初始化状态栏
     */
    private void setStatusBar() {
        if (AppUtils.getSystemVersion() >= 19) {
            LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) mBinding.bar.getLayoutParams();
            linearParams.height = AppUtils.getStatusBarHeight();
            mBinding.bar.setLayoutParams(linearParams);
        }
    }
}
