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
        mBinding.llYhk.setOnClickListener(this);
        mBinding.llYe.setOnClickListener(this);
        mBinding.llXjq.setOnClickListener(this);
        mBinding.llSmrz.setOnClickListener(this);
        mBinding.llZfsz.setOnClickListener(this);
        mBinding.llCz.setOnClickListener(this);
        mBinding.llTx.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.ll_yhk:
                startFragment(YhkFragment.class, null);
                break;
            case R.id.ll_ye:
                startFragment(YeFragment.class, null);
                break;
            case R.id.ll_xjq:
                startFragment(WdxjqFragment.class, null);
                break;
            case R.id.ll_smrz:
                //startFragment(Smrz.class, null);
                break;
            case R.id.ll_zfsz:
                startFragment(ZfszFragment.class, null);
                break;
            case R.id.ll_cz:
                startFragment(CzFragment.class, null);
                break;
            case R.id.ll_tx:
                startFragment(TxFragment.class, null);
                break;
        }
    }
}
