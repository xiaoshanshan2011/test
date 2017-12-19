package com.pub.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.pub.MainActivity;
import com.pub.R;
import com.pub.contract.LoginContract;
import com.pub.databinding.FgLoginLayoutBinding;
import com.pub.net.BaseBean;
import com.pub.presenter.LoginPresenter;
import com.pub.ui.BaseActivity;

/**
 * 登录
 * Created by chenjunshan on 2017-12-19.
 */

public class LoginActivity extends BaseActivity<FgLoginLayoutBinding, Object> implements LoginContract.View {
    private LoginPresenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.fg_login_layout;
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();
        titleBinding.getRoot().setVisibility(View.GONE);
    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        isSlidingClose = false;
        presenter = new LoginPresenter(this, this);

    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.btnNext.setOnClickListener(this);
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
            case R.id.btn_next:
                startActivity(MainActivity.class, null);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.cancelAllRequest();
    }
}
