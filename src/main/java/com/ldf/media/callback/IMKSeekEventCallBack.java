package com.ldf.media.callback;

import com.ldf.media.structure.MK_TRACK;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * 收到客户端的seek请求时触发该回调
 */
public interface IMKSeekEventCallBack extends Callback {
    /**
     * 收到客户端的seek请求时触发该回调
     * @param user_data 用户数据指针,通过mk_media_set_on_seek设置
     * @param stamp_ms seek至的时间轴位置，单位毫秒
     * @return 1代表将处理seek请求，0代表忽略该请求
     */
    public void invoke(Pointer user_data, int stamp_ms);
}