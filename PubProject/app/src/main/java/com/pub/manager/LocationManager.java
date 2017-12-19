package com.pub.manager;

import android.content.Context;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

/**
 * Created by chenjunshan on 10/25/17.
 */

public class LocationManager {
    private Context context;
    private BDLocation location;
    private long locationTime = -1;

    public void setLocationTime(long locationTime) {
        this.locationTime = locationTime;
    }

    public BDLocation getmLocation() {
        return location;
    }

    public LocationManager(Context context) {
        this.context = context;
    }

    // 定位相关
    private LocationClient mLocClient;

    public LocationClient getmLocClient() {
        return mLocClient;
    }

    public void start() {
        // 定位初始化
        mLocClient = new LocationClient(context);
        mLocClient.registerLocationListener(new MyLocationListenner());
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setIsNeedAddress(true);
        if (locationTime == -1) {
            option.setScanSpan(5000);
        }
        mLocClient.setLocOption(option);
        mLocClient.start();
    }

    /**
     * 定位SDK监听函数
     */
    public class MyLocationListenner implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation mLocation) {
            // map view 销毁后不在处理新接收的位置
            if (mLocation == null) {
                return;
            }
            location = mLocation;
            if (listener != null) {
                listener.onLocationSuccess(mLocation);
            }
        }
    }

    private OnLocationListener listener;

    public void setListener(OnLocationListener listener) {
        this.listener = listener;
    }

    public interface OnLocationListener {
        void onLocationSuccess(BDLocation mLocation);
    }
}
