package com.aizuda.callback;

import com.aizuda.structure.MK_AUTH_INVOKER;
import com.aizuda.structure.MK_MEDIA_INFO;
import com.aizuda.structure.MK_SOCK_INFO;
import com.sun.jna.Callback;

/**
 * 播放rtsp/rtmp/http-flv/hls事件广播，通过该事件控制播放鉴权
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public interface IMKPlayCallBack extends Callback {
    /**
     * 播放rtsp/rtmp/http-flv/hls事件广播，通过该事件控制播放鉴权
     *
     * @param url_info 播放url相关信息
     * @param invoker  执行invoker返回鉴权结果
     * @param sender   播放客户端相关信息
     * @see mk_auth_invoker_do
     */
    public void invoke(MK_MEDIA_INFO url_info, MK_AUTH_INVOKER invoker, MK_SOCK_INFO sender);
}
