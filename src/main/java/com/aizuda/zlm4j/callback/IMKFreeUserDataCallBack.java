package com.aizuda.zlm4j.callback;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * 回调user_data回调函数
 */
public interface IMKFreeUserDataCallBack extends Callback {
    /**
     * 回调user_data回调函数
     */
    public void invoke(Pointer user_data);
}