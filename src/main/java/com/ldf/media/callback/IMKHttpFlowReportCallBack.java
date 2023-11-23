package com.ldf.media.callback;

import com.ldf.media.structure.MK_MEDIA_INFO;
import com.ldf.media.structure.MK_SOCK_INFO;
import com.sun.jna.Callback;

/**
 * 停止rtsp/rtmp/http-flv会话后流量汇报事件广播
 */
public interface IMKHttpFlowReportCallBack extends Callback {
    /**
     * 停止rtsp/rtmp/http-flv会话后流量汇报事件广播
     * @param url_info 播放url相关信息
     * @param total_bytes 耗费上下行总流量，单位字节数
     * @param total_seconds 本次tcp会话时长，单位秒
     * @param is_player 客户端是否为播放器
     */
    public void invoke(MK_MEDIA_INFO url_info, long total_bytes, long total_seconds, int is_player, MK_SOCK_INFO sender);
}