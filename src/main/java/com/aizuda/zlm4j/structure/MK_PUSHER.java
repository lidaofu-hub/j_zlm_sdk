package com.aizuda.zlm4j.structure;

import com.sun.jna.Pointer;

/**
 *推流器
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_PUSHER extends SdkStructure{
    public int dwSize;
    public MK_PUSHER(Pointer pointer) {
        super(pointer);
    }
    public MK_PUSHER() {
    }
}
