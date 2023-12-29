package com.aizuda.structure;

import com.sun.jna.Pointer;

/**
 * 配置项目
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_INI extends SdkStructure{
    public int dwSize;
    public MK_INI(Pointer pointer) {
        super(pointer);
    }
    public MK_INI() {
    }
}
