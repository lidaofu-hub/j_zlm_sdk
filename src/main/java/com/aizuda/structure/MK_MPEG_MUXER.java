package com.aizuda.structure;

import com.sun.jna.Pointer;

/**
 * 打包器
 *
 * @author lidaofu
 * @since 2023/12/12
 **/
public class MK_MPEG_MUXER extends SdkStructure {
    public int dwSize;

    public MK_MPEG_MUXER(Pointer pointer) {
        super(pointer);
    }

    public MK_MPEG_MUXER() {
    }
}
