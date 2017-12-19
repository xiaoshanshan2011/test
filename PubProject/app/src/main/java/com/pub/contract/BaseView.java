package com.pub.contract;


import com.pub.net.BaseBean;

/**
 * Created by chenjunshan on 8/30/17.
 */

public interface BaseView {
    void onSuccess(BaseBean baseBean, long mTag);

    void onFailure(Throwable e, long mTag);
}
