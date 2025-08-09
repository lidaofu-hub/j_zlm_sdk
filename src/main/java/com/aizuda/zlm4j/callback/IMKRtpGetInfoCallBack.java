package com.aizuda.zlm4j.callback;

import com.sun.jna.Callback;

public interface IMKRtpGetInfoCallBack extends Callback {

    /**
     * rtp信息获取回调
     *
     * @param exist      存在rtp信息 0: 不存在 1: 存在
     * @param peer_ip    连接ip
     * @param peer_port  连接端口
     * @param local_ip   本地ip
     * @param local_port 本地端口
     * @param identifier 身份信息
     */
    public void invoke(int exist, String peer_ip, short peer_port, String local_ip, short local_port, String identifier);
}
