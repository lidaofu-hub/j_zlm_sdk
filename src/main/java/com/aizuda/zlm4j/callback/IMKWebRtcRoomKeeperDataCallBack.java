package com.aizuda.zlm4j.callback;

import com.sun.jna.Callback;

/**
 * 获取WebRTC-Peer查看注册信息、WebRTC-信令服务器查看注册信息回调
 */
public interface IMKWebRtcRoomKeeperDataCallBack extends Callback {
    /**
     * 获取WebRTC-Peer查看注册信息、WebRTC-信令服务器查看注册信息回调
     */
    public void invoke(String data);
}