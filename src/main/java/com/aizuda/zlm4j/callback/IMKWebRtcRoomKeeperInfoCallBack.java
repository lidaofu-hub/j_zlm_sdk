package com.aizuda.zlm4j.callback;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * WebRTC-注册到信令服务器、WebRTC-从信令服务器注销回调函数
 */
public interface IMKWebRtcRoomKeeperInfoCallBack extends Callback {
    /**
     * WebRTC-注册到信令服务器、WebRTC-从信令服务器注销回调函数
     */
    public void invoke(Pointer user_data, String room_key, String err);
}
