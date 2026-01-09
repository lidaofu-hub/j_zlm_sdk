package com.aizuda.zlm4j.callback;

import com.aizuda.zlm4j.structure.MK_BUFFER;
import com.sun.jna.Pointer;

/**
 * 合并帧回调函数
 *
 * @param user_data      用户数据指针
 * @param dts            解码时间戳
 * @param pts            显示时间戳
 * @param buffer         合并后数据buffer对象
 * @param have_key_frame 合并后数据中是否包含关键帧
 *                       [AUTO-TRANSLATED:ff78df4f]
 */
public interface IMKFrameMergerCallBack {

    /**
     * 合并帧回调函数
     *
     * @param user_data      用户数据指针
     * @param dts            解码时间戳
     * @param pts            显示时间戳
     * @param buffer         合并后数据buffer对象
     * @param have_key_frame 合并后数据中是否包含关键帧
     *                       [AUTO-TRANSLATED:ff78df4f]
     */
    public void invoke(Pointer user_data, long dts, long pts, MK_BUFFER buffer, int have_key_frame);
}
