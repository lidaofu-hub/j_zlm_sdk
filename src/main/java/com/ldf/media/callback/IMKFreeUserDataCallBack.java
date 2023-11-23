package com.ldf.media.callback;

import com.ldf.media.structure.MK_HTTP_ACCESS_PATH_INVOKER;
import com.ldf.media.structure.MK_PARSER;
import com.ldf.media.structure.MK_SOCK_INFO;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * 回调user_data回调函数
 */
public interface IMKFreeUserDataCallBack extends Callback {
    /**
     * 回调user_data回调函数
     */
    public void invoke(Pointer user_data);
}