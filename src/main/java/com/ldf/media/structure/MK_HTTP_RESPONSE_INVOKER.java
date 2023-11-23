package com.ldf.media.structure;

import com.sun.jna.Pointer;

/**
 * http请求体
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_HTTP_RESPONSE_INVOKER extends SdkStructure{
    public int dwSize;

    public MK_HTTP_RESPONSE_INVOKER(Pointer pointer) {
        super(pointer);
    }
    public MK_HTTP_RESPONSE_INVOKER() {
    }
}
