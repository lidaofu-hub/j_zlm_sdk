package com.ldf.media.structure;

import com.sun.jna.Pointer;

/**
 * rtp服务器
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_RTP_SERVER extends SdkStructure{

    public MK_RTP_SERVER(Pointer pointer) {
        super(pointer);
    }
    public MK_RTP_SERVER() {
    }
}
