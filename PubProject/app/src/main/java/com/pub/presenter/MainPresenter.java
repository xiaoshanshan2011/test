package com.pub.presenter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.junshan.pub.utils.PermissionUtis;
import com.junshan.pub.utils.ScreenUtils;
import com.pub.R;
import com.pub.contract.MainContract;
import com.pub.databinding.ActivityMainBinding;
import com.pub.ui.fragment.SlidingmenuFragment;
import com.shan.netlibrary.net.HttpPresenter;

/**
 * 首页
 * Created by chenjunshan on 2017-12-20.
 */

public class MainPresenter extends HttpPresenter implements MainContract.Presenter {
    private Context mContext;
    private MainContract.View mView;
    private ActivityMainBinding mBinding;

    public MainPresenter(Context mContext, MainContract.View mView, ActivityMainBinding mBinding) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
        this.mBinding = mBinding;
    }


    @Override
    public void checkPsermissions() {
        String[] PERMISSIONS = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_COARSE_LOCATION
        };
        PermissionUtis.requestPermissions((Activity) mContext, PermissionUtis.REQUESTCODE, PERMISSIONS);
    }

    @Override
    public void initSlidingMenu() {
        SlidingmenuFragment menuFragment = new SlidingmenuFragment();
        setSlidingMenuWidth(mBinding.flSliding);
        fragmentReplace(menuFragment, R.id.fl_sliding);
    }

    /**
     * 设置slidingmenu宽度
     *
     * @param fl
     */
    private void setSlidingMenuWidth(FrameLayout fl) {
        int width = ScreenUtils.getScreenWidth();
        ViewGroup.LayoutParams params = fl.getLayoutParams();
        params.width = width / 4 * 3;
        fl.setLayoutParams(params);
    }

    /**
     * Fragment 切换
     *
     * @param fragment
     * @param res
     */
    private void fragmentReplace(Fragment fragment, int res) {
        FragmentActivity activity = (FragmentActivity) mContext;
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(res, fragment);
        transaction.commit();
    }

    /**
     * 打开侧滑菜单
     */
    @Override
    public void opentDrawer() {
        if (!mBinding.drawerlayout.isDrawerOpen(Gravity.LEFT)) {
            mBinding.drawerlayout.openDrawer(Gravity.LEFT);
        } else {
            mBinding.drawerlayout.closeDrawer(Gravity.LEFT);
        }
    }

    /**
     * 侧滑菜单打开状态
     *
     * @return
     */
    @Override
    public boolean isOpentDrawer() {
        if (mBinding.drawerlayout.isDrawerOpen(Gravity.LEFT))
            return true;
        else
            return false;
    }
}
