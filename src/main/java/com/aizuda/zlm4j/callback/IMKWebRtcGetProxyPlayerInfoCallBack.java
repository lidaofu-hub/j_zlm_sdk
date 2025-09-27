package com.aizuda.zlm4j.callback;

import com.sun.jna.Callback;

/**
 * 获取webrtc proxy player 信息回调函数
 */
public interface IMKWebRtcGetProxyPlayerInfoCallBack extends Callback {
    /**
     * 获取webrtc proxy player信息回调函数
     */
    public void invoke(String info_json, String err);
}