package com.aizuda.zlm4j.structure;

import com.sun.jna.Pointer;

/**
 * rtsp鉴权
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_RTSP_AUTH_INVOKER extends SdkStructure{
    public int dwSize;
    public MK_RTSP_AUTH_INVOKER(Pointer pointer) {
        super(pointer);
    }
    public MK_RTSP_AUTH_INVOKER() {
    }
}
