package com.ldf.media.structure;

import com.sun.jna.Pointer;

/**
 * mp4信息
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_MP4_INFO extends SdkStructure{
    public int dwSize;

    public MK_MP4_INFO(Pointer pointer) {
        super(pointer);
    }
    public MK_MP4_INFO() {
    }
}
