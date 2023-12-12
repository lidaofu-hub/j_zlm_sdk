package com.ldf.media.callback;

import com.ldf.media.structure.MK_FRAME;
import com.sun.jna.Pointer;

/**
 * 用户自定义free回调函数
 *
 * @author lidaofu
 * @since 2023/12/12
 **/
public interface IMKFrameDataRelease {

    /**
     * 用户自定义free回调函数
     */
    public void invoke(Pointer user_data, Pointer ptr);
}
