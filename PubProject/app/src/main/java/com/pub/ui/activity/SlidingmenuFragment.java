package com.pub.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import com.junshan.pub.utils.AppUtils;
import com.pub.R;
import com.pub.contract.SlidingmenuContract;
import com.pub.databinding.FgSlidingmenuLayoutBinding;
import com.pub.presenter.SlidingmenuPresenter;
import com.pub.ui.BaseFragment;
import com.shan.merchant.ui.fragment.RzxyFragment;
import com.shan.merchant.ui.fragment.SdFragment;
import com.shan.merchant.ui.fragment.SjtabFragment;
import com.shan.netlibrary.net.BaseBean;

/**
 * 侧滑菜单
 * Created by chenjunshan on 2017-12-21.
 */

public class SlidingmenuFragment extends BaseFragment<FgSlidingmenuLayoutBinding, Object> implements SlidingmenuContract.View {
    private SlidingmenuPresenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.fg_slidingmenu_layout;
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();
        titleBinding.getRoot().setVisibility(View.GONE);
    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        presenter = new SlidingmenuPresenter(getActivity(), this);
        setStatusBar();
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.getRoot().setOnClickListener(this);
        mBinding.llCwsj.setOnClickListener(this);
        mBinding.llGlsd.setOnClickListener(this);
    }

    @Override
    public void onSuccess(BaseBean baseBean, long mTag) {

    }

    @Override
    public void onFailure(Throwable e, long mTag) {

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.ll_cwsj:
                startFragment(RzxyFragment.class, null);
                break;
            case R.id.ll_glsd:
                //startFragment(SjtabFragment.class, null);
                startFragment(SdFragment.class, null);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.cancelAllRequest();
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
