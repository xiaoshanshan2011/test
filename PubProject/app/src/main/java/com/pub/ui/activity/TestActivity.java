package com.pub.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.junshan.pub.dialog.BottomSelectDialog;
import com.junshan.pub.utils.ToastUtils;
import com.pub.R;
import com.pub.databinding.TestLayoutBinding;
import com.pub.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;

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
        mBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final List<String> data = new ArrayList<>();
                data.add("减肥减肥减肥");
                data.add("减肥减肥减肥");
                data.add("减肥减肥减肥");
                BottomSelectDialog dialog = new BottomSelectDialog(TestActivity.this) {
                    @Override
                    protected void onSuccess(int position, String content) {
                        tempPostion = position;
                        ToastUtils.toast(data.get(position));
                    }
                };
                dialog.show(data, tempPostion);
            }
        });
    }

    private int tempPostion = 0;
}
