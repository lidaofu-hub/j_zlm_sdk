package com.aizuda.callback;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * 推流结果或推流中断事件的回调
 */
public interface IMKPushEventCallBack extends Callback {
    /**
     * 推流结果或推流中断事件的回调
     * @param user_data 用户数据指针
     * @param err_code 错误代码，0为成功
     * @param err_msg 错误提示
     */
    public void invoke(Pointer user_data, int err_code,String err_msg);
}