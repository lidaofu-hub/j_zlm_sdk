package com.aizuda.structure;

import com.sun.jna.Pointer;

/**
 * buffer
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_BUFFER extends SdkStructure{
    public int dwSize;
    public MK_BUFFER(Pointer pointer) {
        super(pointer);
    }
    public MK_BUFFER() {
    }
}
