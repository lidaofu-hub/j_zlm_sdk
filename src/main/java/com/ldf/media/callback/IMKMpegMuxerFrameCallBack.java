package com.ldf.media.callback;

import com.ldf.media.structure.MK_MPEG_MUXER;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * 打包器输出回调函数
 */
public interface IMKMpegMuxerFrameCallBack extends Callback {
    /**
     * mpeg-ps/ts 打包器输出回调函数
     *
     * @param user_data 设置回调时的用户数据指针
     * @param muxer     对象
     * @param frame     帧数据
     * @param size      帧数据长度
     * @param timestamp 时间戳
     * @param key_pos   是否关键帧
     */
    public void invoke(Pointer user_data, MK_MPEG_MUXER muxer, Pointer frame, long size, long timestamp, int key_pos);
}