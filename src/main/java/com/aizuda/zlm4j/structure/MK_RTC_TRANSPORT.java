package com.aizuda.zlm4j.structure;

import com.sun.jna.Pointer;

/**
 * rtc数据通道对象
 *
 * @author lidaofu
 * @since 2024/5/7
 **/
public class MK_RTC_TRANSPORT extends SdkStructure {
    public int dwSize;

    public MK_RTC_TRANSPORT(Pointer pointer) {
        super(pointer);
    }

    public MK_RTC_TRANSPORT() {
    }
}
