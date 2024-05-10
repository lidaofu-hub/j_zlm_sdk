package com.aizuda.zlm4j.structure;

import com.sun.jna.Pointer;

/**
 * 录像信息
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_RECORD_INFO extends SdkStructure{
    public int dwSize;

    public MK_RECORD_INFO(Pointer pointer) {
        super(pointer);
    }
    public MK_RECORD_INFO() {
    }
}
