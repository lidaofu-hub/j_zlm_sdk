package com.aizuda.callback;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * GB28181 RTP 服务器接收流超时时触发
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public interface IMKRtpServerDetachCallBack extends Callback {

    /**
     *  GB28181 RTP 服务器接收流超时时触发
     * @param user_data
     */
    public void invoke(Pointer user_data);
}
