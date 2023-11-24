package com.ldf.media.structure;

import com.sun.jna.Pointer;

/**
 * http客户端相关信息
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_SOCK_INFO extends SdkStructure{
    public int dwSize;
    public MK_SOCK_INFO(Pointer pointer) {
        super(pointer);
    }
    public MK_SOCK_INFO() {
    }
}
