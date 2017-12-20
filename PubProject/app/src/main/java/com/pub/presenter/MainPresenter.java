package com.pub.presenter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;

import com.junshan.pub.utils.PermissionUtis;
import com.pub.contract.MainContract;
import com.pub.net.HttpPresenter;

/**
 * 首页
 * Created by chenjunshan on 2017-12-20.
 */

public class MainPresenter extends HttpPresenter implements MainContract.Presenter {
    private Context mContext;
    private MainContract.View mView;

    public MainPresenter(Context mContext, MainContract.View mView) {
        super(mContext, mView);
        this.mContext = mContext;
        this.mView = mView;
    }


    @Override
    public void checkPsermissions() {
        String[] PERMISSIONS = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_COARSE_LOCATION
        };
        PermissionUtis.requestPermissions((Activity) mContext, PermissionUtis.REQUESTCODE, PERMISSIONS);
    }
}
