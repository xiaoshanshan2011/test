package com.pub;

import android.animation.Animator;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.junshan.pub.utils.AppUtils;
import com.pub.contract.MainContract;
import com.pub.databinding.ActivityMainBinding;
import com.pub.manager.LocationManager;
import com.pub.net.BaseBean;
import com.pub.presenter.MainPresenter;
import com.pub.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends BaseActivity<ActivityMainBinding, Object> implements LocationManager.OnLocationListener, SensorEventListener, MainContract.View {
    private BaiduMap mBaiduMap;
    private SensorManager mSensorManager;
    private LocationManager locationManager;
    private MainPresenter presenter;

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
        presenter = new MainPresenter(this, this, mBinding);
        presenter.checkPsermissions();
        presenter.initSlidingMenu();
        isSlidingClose = false;
        setStatusBar();
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
            builder.target(ll).zoom(17.0f);
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

    /**
     * 初始化状态栏
     */
    private void setStatusBar() {
        if (AppUtils.getSystemVersion() >= 19) {
            LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) mBinding.bar.getLayoutParams();
            linearParams.height = AppUtils.getStatusBarHeight();
            mBinding.bar.setLayoutParams(linearParams);
        }
    }

    @Override
    protected void initData() {
        super.initData();
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
        data.add("水果");
        data.add("水果");
        data.add("水果");
        data.add("水果");
        data.add("水果");
        data.add("水果");
        mBinding.hsType.bindData(data);

        addImg(data);
    }


    // 初始化全局 bitmap 信息，不用时及时 recycle
    private void addImg(final List<String> datas) {
        Random random = new Random();
        recycBitmap();
        imgs = new ArrayList<>();
        bds = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            //设置经纬度
            double latRandom = 0;
            double lonRandom = 0;
            int rd = random.nextInt(4);
            if (rd == 0) {
                latRandom = (random.nextInt(10) + 1) * 0.0003;
                lonRandom = (random.nextInt(10) + 1) * 0.0003;
            } else if (rd == 1) {
                latRandom = -(random.nextInt(10) + 1) * 0.0003;
                lonRandom = -(random.nextInt(10) + 1) * 0.0003;
            } else if (rd == 2) {
                latRandom = (random.nextInt(10) + 1) * 0.0003;
                lonRandom = -(random.nextInt(10) + 1) * 0.0003;
            } else if (rd == 3) {
                latRandom = -(random.nextInt(10) + 1) * 0.0003;
                lonRandom = (random.nextInt(10) + 1) * 0.0003;
            }
            double t = 22.639424;
            double n = 114.038094;
            double lat = t + latRandom;
            double lon = n + lonRandom;
            final int j = i;
            initOverlay(j, lat, lon);
        }
    }

    private List<ImageView> imgs;

    /**
     * 初始化覆盖物
     */
    private void initOverlay(int i, double lat, double lon) {
        //drawable = ImageUtils.zoomDrawable(drawable, overlayWidth, overlayWidth);
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_location3);
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(drawable);
        imgs.add(imageView);
        LatLng llB = new LatLng(lat, lon);
        BitmapDescriptor bd = BitmapDescriptorFactory.fromView(imageView);
        bds.add(bd);
        MarkerOptions ooB = new MarkerOptions().position(llB).icon(bd)
                .zIndex(9).draggable(true);
        Marker mMarker = (Marker) (mBaiduMap.addOverlay(ooB));
        mMarker.setZIndex(i);
    }

    private List<BitmapDescriptor> bds;

    /**
     * 回收图片占用的内存
     */
    private void recycBitmap() {
        if (bds != null && bds.size() > 0) {
            mBaiduMap.clear();
            for (int i = 0; i < bds.size(); i++) {
                bds.get(i).recycle();
            }
        }
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.btnLocation.setOnClickListener(this);
        mBinding.ivLeft.setOnClickListener(this);
        mBinding.ivRight.setOnClickListener(this);
        mBinding.btnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.btn_location:
                isFirstLoc = true;
                if (locationManager.getmLocation() != null) {
                    onLocationSuccess(locationManager.getmLocation());
                }
                break;
            case R.id.btn_search:
                mBinding.sv.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.ZoomInUp)
                        .duration(400)
                        .repeat(0)
                        .onEnd(new YoYo.AnimatorCallback() {
                            @Override
                            public void call(Animator animator) {

                            }
                        })
                        .playOn(findViewById(R.id.sv));
                break;
            case R.id.iv_left:
                presenter.opentDrawer();
                break;
            case R.id.iv_right:

                break;
        }
    }

    @Override
    public void onSuccess(BaseBean baseBean, long mTag) {

    }

    @Override
    public void onFailure(Throwable e, long mTag) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //关闭搜索
            if (mBinding.sv.getVisibility() == View.VISIBLE) {
                YoYo.with(Techniques.ZoomOutDown)
                        .duration(400)
                        .repeat(0)
                        .onEnd(new YoYo.AnimatorCallback() {
                            @Override
                            public void call(Animator animator) {
                                mBinding.sv.setVisibility(View.GONE);
                            }
                        })
                        .playOn(findViewById(R.id.sv));
                return true;
            }
            //关闭抽屉
            if (presenter.isOpentDrawer()) {
                presenter.opentDrawer();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
