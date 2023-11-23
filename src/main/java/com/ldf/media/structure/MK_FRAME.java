package com.ldf.media.structure;

import com.sun.jna.Pointer;

/**
 * 帧
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_FRAME extends SdkStructure{
    public int dwSize;
    public MK_FRAME(Pointer pointer) {
        super(pointer);
    }
    public MK_FRAME() {
    }
}
