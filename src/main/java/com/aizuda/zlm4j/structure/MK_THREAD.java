package com.aizuda.zlm4j.structure;

import com.sun.jna.Pointer;

/**
 * 线程
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_THREAD extends SdkStructure {

    public int dwSize;

    public MK_THREAD(Pointer pointer) {
        super(pointer);
    }
    public MK_THREAD() {
    }
}
