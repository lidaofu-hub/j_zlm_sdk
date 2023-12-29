package com.aizuda.callback;

import com.aizuda.structure.MK_FRAME;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * 输出frame回调
 */
public interface IMKFrameOutCallBack extends Callback {
    /**
     * 输出frame回调
     */
    public void invoke(Pointer user_data, MK_FRAME frame);
}