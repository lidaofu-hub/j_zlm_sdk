package com.aizuda.zlm4j.structure;

import com.sun.jna.Pointer;

/**
 * 数据
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_RTSP_GET_REALM_INVOKER extends SdkStructure{
    public int dwSize;
    public MK_RTSP_GET_REALM_INVOKER(Pointer pointer) {
        super(pointer);
    }
    public MK_RTSP_GET_REALM_INVOKER() {
    }
}
