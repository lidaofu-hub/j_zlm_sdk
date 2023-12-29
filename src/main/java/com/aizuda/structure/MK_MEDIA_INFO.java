package com.aizuda.structure;

import com.sun.jna.Pointer;

/**
 * 媒体对象
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_MEDIA_INFO extends SdkStructure{
    public int dwSize;
    public MK_MEDIA_INFO(Pointer pointer) {
        super(pointer);
    }
    public MK_MEDIA_INFO() {
    }



}
