package com.aizuda.zlm4j.callback;

import com.aizuda.zlm4j.structure.MK_RECORD_INFO;
import com.sun.jna.Callback;

/**
 * 录制ts分片文件成功后广播
 */
public interface IMKRecordTsCallBack extends Callback {
    /**
     * 录制ts分片文件成功后广播
     */
    public void invoke(MK_RECORD_INFO record);
}
