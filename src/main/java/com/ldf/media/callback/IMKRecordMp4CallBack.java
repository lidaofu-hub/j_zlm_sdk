package com.ldf.media.callback;

import com.ldf.media.structure.MK_HTTP_RESPONSE_INVOKER;
import com.ldf.media.structure.MK_MP4_INFO;
import com.ldf.media.structure.MK_PARSER;
import com.ldf.media.structure.MK_SOCK_INFO;
import com.sun.jna.Callback;
import com.sun.jna.ptr.IntByReference;

/**
 * 录制mp4分片文件成功后广播
 */
public interface IMKRecordMp4CallBack extends Callback {
    /**
     * 录制mp4分片文件成功后广播
     */
    public void invoke(MK_MP4_INFO mp4);
}
