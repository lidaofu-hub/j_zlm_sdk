package com.aizuda.callback;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * rtp推流成功与否的回调(第一次成功后，后面将一直重试)
 */
public interface IMKSourceSendRtpResultCallBack extends Callback {


    /**
     * rtp推流成功与否的回调(第一次成功后，后面将一直重试)
     */
    public void invoke(Pointer user_data, short local_port, int err, String msg);
}