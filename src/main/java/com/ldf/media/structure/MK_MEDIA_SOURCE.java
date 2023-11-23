package com.ldf.media.structure;

import com.sun.jna.Pointer;

/**
 * 媒体源信息
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_MEDIA_SOURCE extends SdkStructure {
    public int dwSize;
    public MK_MEDIA_SOURCE(Pointer pointer) {
        super(pointer);
    }
    public MK_MEDIA_SOURCE() {
    }
}
