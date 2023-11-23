package com.ldf.media.callback;

import com.ldf.media.structure.MK_HTTP_ACCESS_PATH_INVOKER;
import com.ldf.media.structure.MK_MEDIA_SOURCE;
import com.ldf.media.structure.MK_PARSER;
import com.ldf.media.structure.MK_SOCK_INFO;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * 寻找流回调
 */
public interface IMKSourceFindCallBack extends Callback {


    public void invoke(Pointer user_data, MK_MEDIA_SOURCE ctx);
}