package com.aizuda.structure;

import com.sun.jna.Pointer;

/**
 * 播放器
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_PLAYER extends SdkStructure{
    public int dwSize;
    public MK_PLAYER(Pointer pointer) {
        super(pointer);
    }
    public MK_PLAYER() {
    }
}
