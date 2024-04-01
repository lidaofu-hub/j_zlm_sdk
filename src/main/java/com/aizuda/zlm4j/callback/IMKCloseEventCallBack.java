package com.aizuda.zlm4j.callback;

import com.aizuda.zlm4j.structure.MK_TRACK;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * 播放关闭回调
 */
public interface IMKCloseEventCallBack extends Callback {
    /**
     * 播放关闭回调
     */
    public void invoke(Pointer user_data, int err_code, String err_msg, MK_TRACK tracks[], int track_count);
}