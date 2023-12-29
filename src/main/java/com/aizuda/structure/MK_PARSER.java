package com.aizuda.structure;

import com.sun.jna.Pointer;

/**
 * http请求内容对象
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_PARSER extends SdkStructure{
    public int dwSize;
    public MK_PARSER(Pointer pointer) {
        super(pointer);
    }
    public MK_PARSER() {
    }
}
