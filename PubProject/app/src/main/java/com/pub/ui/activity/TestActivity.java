package com.pub.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.pub.R;
import com.pub.databinding.TestLayoutBinding;
import com.pub.ui.BaseActivity;

/**
 * Created by chenjunshan on 12/29/17.
 */

public class TestActivity extends BaseActivity<TestLayoutBinding, Object> {
    @Override
    public int bindLayout() {

        return R.layout.test_layout;
    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        isSlidingClose = false;
    }
}
