package com.aizuda.zlm4j.callback;

import com.aizuda.zlm4j.structure.MK_MEDIA_INFO;
import com.aizuda.zlm4j.structure.MK_SOCK_INFO;
import com.sun.jna.Callback;

/**
 * 未找到流后会广播该事件，请在监听该事件后去拉流或其他方式产生流，这样就能按需拉流了
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public interface IMKNoFoundCallBack extends Callback {
    /**
     * 未找到流后会广播该事件，请在监听该事件后去拉流或其他方式产生流，这样就能按需拉流了
     *
     * @param url_info 播放url相关信息
     * @param sender   播放客户端相关信息
     * @return 1 直接关闭
     * 0 等待流注册
     */
    public int invoke(MK_MEDIA_INFO url_info, MK_SOCK_INFO sender);
}
