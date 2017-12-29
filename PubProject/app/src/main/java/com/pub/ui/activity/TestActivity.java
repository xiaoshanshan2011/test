package com.pub.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.pub.R;
import com.pub.databinding.TestLayoutBinding;
import com.pub.ui.BaseFragment;
import com.shan.merchant.ui.fragment.SjsplbFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenjunshan on 12/29/17.
 */

public class TestActivity extends BaseFragment<TestLayoutBinding, Object> {
    @Override
    public int bindLayout() {

        return R.layout.test_layout;
    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
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
}
