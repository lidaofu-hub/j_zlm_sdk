package com.aizuda.zlm4j.callback;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

public interface IMKPsDecoderFrameCallBack extends Callback {

    /**
     * ps帧回调可选
     */
    public void invoke(Pointer user_data, int stream, int codecid, int flags, long pts, long dts, Pointer data, long bytes);
}
