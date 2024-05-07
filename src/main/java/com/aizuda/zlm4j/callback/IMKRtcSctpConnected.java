package com.aizuda.zlm4j.callback;

import com.aizuda.zlm4j.structure.MK_RTC_TRANSPORT;
import com.sun.jna.Callback;

/**
 * rtc sctp连接成功回调
 *
 * @author lidaofu
 * @since 2024/5/7
 **/
public interface IMKRtcSctpConnected extends Callback {

    /**
     * rtc sctp连接成功回调
     *
     * @param mkRtcTransport
     */
    public void invoke(MK_RTC_TRANSPORT mkRtcTransport);
}
