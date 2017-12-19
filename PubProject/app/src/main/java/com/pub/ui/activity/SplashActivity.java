package com.pub.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;

import com.pub.R;
import com.pub.databinding.ActivitySplashBinding;
import com.pub.ui.BaseActivity;


/**
 * 欢迎界面
 * Created by chenjunshan on 17-3-21.
 */

public class SplashActivity extends BaseActivity<ActivitySplashBinding, Object> {
    private String passwd;
    private String name;

    @Override
    public void initTitleBar() {
        super.initTitleBar();
        titleBinding.getRoot().setVisibility(View.GONE);
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_splash;
    }

    //private boolean isFirstIn;

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        isSlidingClose = false;
        handler.postDelayed(runnableMian, 2000);
    }

    private Handler handler = new Handler();

    private Runnable runnableMian = new Runnable() {
        @Override
        public void run() {
            startActivity(LoginActivity.class, null);
            finish();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnableMian);
        handler = null;
    }
}
