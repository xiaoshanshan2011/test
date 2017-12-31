package com.shan.merchant.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.shan.merchant.R;
import com.shan.merchant.contract.SpContract;
import com.shan.merchant.databinding.FgSpLayoutBinding;
import com.shan.merchant.presenter.SpPresenter;
import com.shan.merchant.ui.BaseFragment;
import com.shan.netlibrary.net.BaseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品
 * Created by chenjunshan on 2017-12-27.
 */

public class SpFragment extends BaseFragment<FgSpLayoutBinding, Object> implements SpContract.View {
    private SpPresenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.fg_sp_layout;
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();
        titleBinding.getRoot().setVisibility(View.GONE);
    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        presenter = new SpPresenter(getActivity(), this);
        List<String> data = new ArrayList<>();
        data.add("附近");
        data.add("公厕");
        data.add("百货");
        data.add("工具");
        data.add("海鲜");
        data.add("物料");
        data.add("电器");
        data.add("水果");
        data.add("水果");
        data.add("水果");
        data.add("水果");
        data.add("水果");
        data.add("水果");
        data.add("水果");
        data.add("水果");
        data.add("水果");
        data.add("水果");
        data.add("水果");
        data.add("水果");
        mBinding.topType.bindData(data);
        mBinding.leftType.bindData(data);

        SjsplbFragment sjsplbFragment = new SjsplbFragment();
        fragmentReplace(sjsplbFragment, R.id.fl_content);
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
