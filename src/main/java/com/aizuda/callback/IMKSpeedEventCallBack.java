package com.aizuda.callback;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * 收到客户端的speed请求时触发该回调
 */
public interface IMKSpeedEventCallBack extends Callback {
    /**
     * 收到客户端的speed请求时触发该回调
     * @param user_data 用户数据指针,通过mk_media_set_on_pause设置
     * @param speed 0.5 1.0 2.0
     */
    public void invoke(Pointer user_data, float speed);
}