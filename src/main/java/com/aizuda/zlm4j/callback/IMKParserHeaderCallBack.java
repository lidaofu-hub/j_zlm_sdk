package com.aizuda.zlm4j.callback;

import com.aizuda.zlm4j.structure.MK_FRAME;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * 请求头回调
 */
public interface IMKParserHeaderCallBack extends Callback {
    /**
     * 请求头回调
     */
    public void invoke(Pointer user_data, MK_FRAME frame);
}