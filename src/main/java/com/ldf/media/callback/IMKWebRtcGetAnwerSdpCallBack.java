package com.ldf.media.callback;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * 获取webrtc answer sdp回调函数
 */
public interface IMKWebRtcGetAnwerSdpCallBack extends Callback {
    /**
     * 获取webrtc answer sdp回调函数
     */
    public void invoke(Pointer user_data, String answer, String err);
}