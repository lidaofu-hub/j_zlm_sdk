package com.ldf.media.structure;

import com.sun.jna.Pointer;

/**
 * 媒体
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_MEDIA extends SdkStructure{
    public int dwSize;

    public MK_MEDIA(Pointer pointer) {
        super(pointer);
    }
    public MK_MEDIA() {
    }
}
