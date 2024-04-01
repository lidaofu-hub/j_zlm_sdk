package com.aizuda.zlm4j.callback;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * 收到客户端的pause或resume请求时触发该回调
 */
public interface IMKPauseEventCallBack extends Callback {
    /**
     * 收到客户端的pause或resume请求时触发该回调
     * @param user_data 用户数据指针,通过mk_media_set_on_pause设置
     * @param pause 1:暂停, 0: 恢复
     */
    public void invoke(Pointer user_data, int pause);
}