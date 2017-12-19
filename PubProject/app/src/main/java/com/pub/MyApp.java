package com.pub;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.junshan.pub.App;
import com.junshan.pub.utils.LogUtils;

/**
 * Created by chenjunshan on 2017/3/9.
 */
public class MyApp extends App {
    private static MyApp instance;

    public static MyApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.isLog = true;//是否打印日志
        init();
    }

    /**
     * MyApp初始化操作
     */
    private void init() {
        instance = (MyApp) getApplicationContext();
        // 在使用 SDK 各组间之前初始化 context 信息，传入 ApplicationContext
        SDKInitializer.initialize(this);
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL);
    }
}
