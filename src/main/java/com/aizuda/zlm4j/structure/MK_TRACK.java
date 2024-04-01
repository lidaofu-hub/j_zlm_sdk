package com.aizuda.zlm4j.structure;

import com.sun.jna.Pointer;

/**
 * track信息
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_TRACK extends SdkStructure {
    public int dwSize;

    public MK_TRACK(Pointer pointer){
        super(pointer);
    }
    public MK_TRACK() {
    }
}
