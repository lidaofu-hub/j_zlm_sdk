package com.aizuda.zlm4j.callback;

import com.aizuda.zlm4j.structure.MK_H264_SPLITTER;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;

public interface IMKH264SplitterFrame extends Callback {

    /**
     *
     * h264 分帧器输出回调函数
     * @param user_data 设置回调时的用户数据指针
     * @param splitter 对象
     * @param frame 帧数据
     * @param size 帧数据长度
     */
    public void invoke(Pointer user_data, MK_H264_SPLITTER splitter, Pointer frame, int size);
}
