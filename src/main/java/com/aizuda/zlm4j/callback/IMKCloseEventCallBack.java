package com.aizuda.zlm4j.callback;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * 播放关闭回调
 */
public interface IMKCloseEventCallBack extends Callback {
    /**
     * 播放关闭回调
     */
    public void invoke(Pointer user_data);
}