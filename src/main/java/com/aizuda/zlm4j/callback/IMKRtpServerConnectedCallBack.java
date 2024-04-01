package com.aizuda.zlm4j.callback;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * TCP 主动模式时连接到服务器是否成功的回调
 */
public interface IMKRtpServerConnectedCallBack extends Callback {
    /**
     * TCP 主动模式时连接到服务器是否成功的回调
     */
    public void invoke(Pointer user_data);
}