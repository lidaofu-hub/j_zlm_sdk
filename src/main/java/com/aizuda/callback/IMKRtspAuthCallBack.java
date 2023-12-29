package com.aizuda.callback;

import com.aizuda.structure.MK_MEDIA_INFO;
import com.aizuda.structure.MK_RTSP_AUTH_INVOKER;
import com.aizuda.structure.MK_SOCK_INFO;
import com.sun.jna.Callback;

/**
 * 请求认证用户密码事件，user_name为用户名，must_no_encrypt如果为true，则必须提供明文密码(因为此时是base64认证方式),否则会导致认证失败
 */
public interface IMKRtspAuthCallBack extends Callback {
    /**
     * 请求认证用户密码事件，user_name为用户名，must_no_encrypt如果为true，则必须提供明文密码(因为此时是base64认证方式),否则会导致认证失败
     * 获取到密码后请调用invoker并输入对应类型的密码和密码类型，invoker执行时会匹配密码
     *
     * @param url_info        请求rtsp url相关信息
     * @param realm           rtsp认证realm
     * @param user_name       rtsp认证用户名
     * @param must_no_encrypt 如果为true，则必须提供明文密码(因为此时是base64认证方式),否则会导致认证失败
     * @param invoker         执行invoker返回rtsp专属认证的密码
     * @param sender          rtsp客户端信息
     */
    public void invoke(MK_MEDIA_INFO url_info, String realm, String user_name, int must_no_encrypt, MK_RTSP_AUTH_INVOKER invoker, MK_SOCK_INFO sender);
}
