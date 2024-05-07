package com.aizuda.zlm4j.callback;

import com.aizuda.zlm4j.structure.MK_RTC_TRANSPORT;
import com.sun.jna.Callback;

/**
 * rtc数据通道发送数据回调
 *
 * @author lidaofu
 * @since 2024/5/7
 **/
public interface IMKRtcSctpSend extends Callback {

    /**
     * rtc数据通道发送数据回调
     *
     * @param mkRtcTransport
     */
    public void invoke(MK_RTC_TRANSPORT mkRtcTransport,byte msg, long len);
}
