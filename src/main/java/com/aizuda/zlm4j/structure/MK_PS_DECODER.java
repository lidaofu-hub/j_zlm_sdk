package com.aizuda.zlm4j.structure;

import com.sun.jna.Pointer;

/**
 * ps解码器
 *
 * @author lidaofu
 * @since 2025/3/27
 **/
public class MK_PS_DECODER extends SdkStructure{
    public int dwSize;
    public MK_PS_DECODER(Pointer pointer) {
        super(pointer);
    }
    public MK_PS_DECODER() {
    }
}
