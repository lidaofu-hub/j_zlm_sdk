package com.aizuda.zlm4j.callback;

import com.aizuda.zlm4j.structure.MK_MEDIA_INFO;
import com.aizuda.zlm4j.structure.MK_RTSP_AUTH_INVOKER;
import com.aizuda.zlm4j.structure.MK_SOCK_INFO;
import com.sun.jna.Callback;

/**
 * 该rtsp流是否需要认证？是的话调用invoker并传入realm,否则传入空的realm
 */
public interface IMKRtspGetRealmCallBack extends Callback {
    /**
     * 该rtsp流是否需要认证？是的话调用invoker并传入realm,否则传入空的realm
     * @param url_info 请求rtsp url相关信息
     * @param invoker 执行invoker返回是否需要rtsp专属认证
     * @param sender rtsp客户端相关信息
     */
    public void invoke(MK_MEDIA_INFO url_info, String realm, String user_name, int must_no_encrypt, MK_RTSP_AUTH_INVOKER invoker, MK_SOCK_INFO sender);
}
