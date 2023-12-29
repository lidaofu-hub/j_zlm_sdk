package com.aizuda.callback;

import com.aizuda.structure.MK_MEDIA_SOURCE;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * 寻找流回调
 */
public interface IMKSourceFindCallBack extends Callback {


    public void invoke(Pointer user_data, MK_MEDIA_SOURCE ctx);
}