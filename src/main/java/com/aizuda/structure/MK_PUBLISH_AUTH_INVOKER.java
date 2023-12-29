package com.aizuda.structure;

import com.sun.jna.Pointer;

/**
 * 推流鉴权信息
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_PUBLISH_AUTH_INVOKER extends SdkStructure {
    public int dwSize;

    public MK_PUBLISH_AUTH_INVOKER(Pointer pointer) {
        super(pointer);
    }
    public MK_PUBLISH_AUTH_INVOKER() {
    }
}
