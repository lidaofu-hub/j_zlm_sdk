package com.aizuda.zlm4j.structure;

import com.sun.jna.Pointer;

public class MK_FRAME_MERGER  extends SdkStructure{
    public int dwSize;

    public MK_FRAME_MERGER(Pointer pointer) {
        super(pointer);
    }

    public MK_FRAME_MERGER() {
    }
}
