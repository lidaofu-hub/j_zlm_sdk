package com.aizuda.zlm4j.structure;

import com.sun.jna.Pointer;

/**
 * flv录制器
 *
 * @author lidaofu
 * @since 2023/12/1
 **/
public class MK_FLV_RECORDER extends SdkStructure{
    public int dwSize;

    public MK_FLV_RECORDER() {
    }

    public MK_FLV_RECORDER(Pointer pointer) {
        super(pointer);
    }
}
