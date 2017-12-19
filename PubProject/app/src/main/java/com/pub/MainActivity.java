package com.pub;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.pub.databinding.ActivityMainBinding;
import com.pub.manager.LocationManager;
import com.pub.ui.BaseActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding, Object> implements LocationManager.OnLocationListener, SensorEventListener {
    private BaiduMap mBaiduMap;
    private SensorManager mSensorManager;
    private LocationManager locationManager;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
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
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);//获取传感器管理服务
        mBinding.bmapView.removeViewAt(1);//移除百度图标
        mBinding.bmapView.showZoomControls(true);//不显示地图缩放控件（按钮控制栏）
        mBaiduMap = mBinding.bmapView.getMap();
        UiSettings uiSettings = mBaiduMap.getUiSettings();
        uiSettings.setCompassEnabled(false);

        initLocation();
    }

    private void initLocation() {
        //定位
        locationManager = new LocationManager(this);
        locationManager.setListener(this);
        locationManager.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBinding.bmapView.onResume();
        //为系统的方向传感器注册监听器
        mSensorManager.registerListener((SensorEventListener) MainActivity.this, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //取消注册传感器监听
        mSensorManager.unregisterListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding.bmapView.onDestroy();
        mBaiduMap.setMyLocationEnabled(false);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mBinding.bmapView.onPause();
    }

    private MyLocationData locData;
    boolean isFirstLoc = true; // 是否首次定位
    private int mCurrentDirection = 0;
    private double mCurrentLon = 0.0;

    @Override
    public void onLocationSuccess(BDLocation location) {
        // map view 销毁后不在处理新接收的位置
        if (location == null || mBinding.bmapView == null) {
            return;
        }
        mCurrentLat = location.getLatitude();
        mCurrentLon = location.getLongitude();
        mCurrentAccracy = location.getRadius();
        locData = new MyLocationData.Builder()
                .accuracy(location.getRadius())
                // 此处设置开发者获取到的方向信息，顺时针0-360
                .direction(mCurrentDirection).latitude(location.getLatitude())
                .longitude(location.getLongitude()).build();
        mBaiduMap.setMyLocationData(locData);
        if (isFirstLoc) {
            isFirstLoc = false;
            LatLng ll = new LatLng(location.getLatitude(),
                    location.getLongitude());
            MapStatus.Builder builder = new MapStatus.Builder();
            builder.target(ll).zoom(13.0f);
            mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
        }
    }


    private Double lastX = 0.0;
    private float mCurrentAccracy = 0;
    private double mCurrentLat = 0.0;

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        double x = sensorEvent.values[SensorManager.DATA_X];
        if (Math.abs(x - lastX) > 1.0) {
            mCurrentDirection = (int) x;
            locData = new MyLocationData.Builder()
                    .accuracy(mCurrentAccracy)
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(mCurrentDirection).latitude(mCurrentLat)
                    .longitude(mCurrentLon).build();
            mBaiduMap.setMyLocationData(locData);
        }
        lastX = x;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
