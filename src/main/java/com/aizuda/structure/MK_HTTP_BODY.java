package com.aizuda.structure;

import com.sun.jna.Pointer;

/**
 * http请求提
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_HTTP_BODY extends SdkStructure {
    public int dwSize;
    public MK_HTTP_BODY(Pointer pointer) {
        super(pointer);
    }
    public MK_HTTP_BODY() {
    }
}
