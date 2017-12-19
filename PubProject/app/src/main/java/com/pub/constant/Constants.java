package com.pub.constant;

public class Constants {
    public static int toTag = 0;//用来标记支付成功后的跳转
    public static final int toTag0 = 0;//表示不跳转
    public static final int toTag1 = 1;//从订单详情发起支付
    public static final int toTag2 = 2;//从充值体现发起支付
    public static final int toTag3 = 3;//从方案发起支付
    public static final int toTag4 = 4;//从Idea发起支付

    public static final String PAYMENTTYPE_ODER = "1";//paymentContractID,订单
    public static final String PAYMENTTYPE_FA = "5";//paymentContractID,方案
    public static final String PAYMENTTYPE_IDEA = "6";//paymentContractID,Idea

    public static final String BUNDLEINFO = "bundleinfo";//Bundle跳转
    public static final String USERTYPE = "usertype";//聊天类型，客服或者好友
    public static final String KEFU = "kefu";//聊天类型，客服
    public static final String FRIEND = "friend";//聊天类型，好友
    public static final String APPORDERSTATUSTYPE = "appOrderStatusType";
    public static final String CONTRACTINFOID = "ContractInfoID";
    public static final int REQUESTCODE = 2;//requestcode
    public static final String SCANRESULT = "scanresult";//扫描结果
    public static final int SCANCODE = 3;//扫描code
    public static final int BINDMOBILE = 4;//绑定手机号码
    public static final int BINDMOBILEFAILUER = 5;//绑定手机号码失败
    public static final String MAINACTIVITYPAKEGENAME = "com.huixinyunapp.ui.activity.MainActivity";//绑定手机号码失败
    public static final String ZH = "zh";//简体中文
    public static final String TZH = "tzh";//繁体中文
    public static final String EN = "en";//英文
    public static final int CLEARCACHE = 6;//清除缓存
    public static final int TAG_10 = 10;//网络请求标识
    public static final int TAG_11 = 11;//网络请求标识
    public static final int TAG_12 = 12;//网络请求标识
    public static final int TAG_13 = 13;//网络请求标识
    public static final int TAG_15 = 15;//网络请求标识
    public static final int TAG_16 = 16;//网络请求标识
    public static final int TAG_17 = 17;//网络请求标识
    public static final int TAG_18 = 18;//网络请求标识
    public static final int TAG_19 = 19;//网络请求标识
    public static final int TAG_20 = 20;//网络请求标识
    public static final int TAG_21 = 21;//网络请求标识
    public static final int TAG_22 = 22;//网络请求标识
    public static final int TAG_26 = 26;//网络请求标识
    public static final int TAG_28 = 28;//网络请求标识
    public static final int TAG_29 = 29;//网络请求标识
    public static final int REQUEST_CODE = 110;//权限标识
    public static final String FID = "fid";
    public static final String MONEY = "money";
    public static final String NUM = "num";
    public static final int QUITCKLOGINREQUESTCODE = 19;//快捷登录
    public static final int REGISTERREQUESTCODE = 20;//注册
    public static final String BEAN = "bean";
    public static final String FLAG = "flag";

    public static final String PRODUCT = "1";//成熟产品
    public static final String CONTRACT = "2";//合同
    public static final String ADDCONTRACT = "3";//补充合同
    public static final String FAYEZF = "4";//方案余额支付
    public static final String FADTAILSPAY= "5";//11.15 方案详情支付(小费)
    public static final String IDEA= "6";//idea支付
    public static final int TAG_30 = 30;
    public static final String URL = "url";
    public static final String NAME = "name";
}
