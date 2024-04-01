package com.aizuda.zlm4j.callback;

import com.aizuda.zlm4j.structure.MK_MEDIA_SOURCE;
import com.sun.jna.Callback;

/**
 * 注册或反注册MediaSource事件广播
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public interface IMKStreamChangeCallBack extends Callback {
    /**
     * 注册或反注册MediaSource事件广播
     * @param regist 注册为1，注销为0
     * @param sender 该MediaSource对象
     */
    public void invoke(int regist, MK_MEDIA_SOURCE sender);
}
