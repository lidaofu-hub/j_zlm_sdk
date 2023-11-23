package com.ldf.media.callback;

import com.sun.jna.Callback;

/**
 * 发送rtp流失败回调，适用于mk_media_source_start_send_rtp/mk_media_start_send_rtp接口触发的rtp发送
 */
public interface IMKSendRtpStopCallBack extends Callback {
    /**
     * 发送rtp流失败回调，适用于mk_media_source_start_send_rtp/mk_media_start_send_rtp接口触发的rtp发送
     *
     * @param vhost  虚拟主机
     * @param app    应用名
     * @param stream 流id
     * @param ssrc   ssrc的10进制打印，通过atoi转换为整型
     * @param err    错误代码
     * @param msg    错误提示
     */
    public void invoke(String vhost, String app, String stream, String ssrc, int err, String msg);
}