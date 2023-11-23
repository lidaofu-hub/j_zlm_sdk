package com.ldf.media.structure;

import com.sun.jna.Pointer;

/**
 *  执行invoker返回本次访问文件的结果
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_HTTP_ACCESS_PATH_INVOKER extends SdkStructure{
    public int dwSize;
    public MK_HTTP_ACCESS_PATH_INVOKER(Pointer pointer) {
        super(pointer);
    }
    public MK_HTTP_ACCESS_PATH_INVOKER() {
    }
}
