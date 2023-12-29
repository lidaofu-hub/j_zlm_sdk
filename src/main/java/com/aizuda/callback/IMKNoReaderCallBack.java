package com.aizuda.callback;

import com.aizuda.structure.MK_MEDIA_SOURCE;
import com.sun.jna.Callback;

/**
 * 无人观看回调
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public interface IMKNoReaderCallBack extends Callback {
    /**
     * 某个流无人消费时触发，目的为了实现无人观看时主动断开拉流等业务逻辑
     * @param sender 该MediaSource对象
     */
    public void invoke(MK_MEDIA_SOURCE sender);
}
