package com.aizuda.zlm4j.structure;

import com.sun.jna.Pointer;

/**
 * 代理对象
 */
public class MK_PROXY_PLAYER extends SdkStructure {
    public int dwSize;
    public MK_PROXY_PLAYER(Pointer pointer) {
        super(pointer);
    }
    public MK_PROXY_PLAYER() {
    }

}