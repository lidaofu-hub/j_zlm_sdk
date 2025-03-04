package com.aizuda.zlm4j.callback;

import com.aizuda.zlm4j.structure.MK_TRACK;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * 播放结果或播放中断事件的回调
 */
public interface IMKPlayEventCallBack extends Callback {
    /**
     * 播放结果或播放中断事件的回调
     */
    public void invoke(Pointer user_data, int err_code, String err_msg,Pointer  tracks, int track_count);
}