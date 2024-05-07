package com.aizuda.zlm4j.callback;

import com.aizuda.zlm4j.structure.MK_RTC_TRANSPORT;
import com.sun.jna.Callback;

/**
 * rtc数据通道接收数据回调
 *
 * @author lidaofu
 * @since 2024/5/7
 **/
public interface IMKRtcSctpReceived extends Callback {

    /**
     * rtc数据通道接收数据回调
     *
     * @param mkRtcTransport
     */
    public void invoke(MK_RTC_TRANSPORT mkRtcTransport, short streamId, int ppid, byte msg, long len);
}
