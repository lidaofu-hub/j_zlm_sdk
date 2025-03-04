package com.aizuda.zlm4j.callback;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

public interface IMKPsDecoderStreamCallBack extends Callback {

    /**
     * ps流回调可选
     */
    public void invoke(Pointer user_data, int stream, int codecid, Pointer ext, long ext_len, int finish);
}
