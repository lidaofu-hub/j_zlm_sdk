package com.aizuda.zlm4j.callback;

import com.aizuda.zlm4j.structure.MK_INI;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * 获取内存数据统计
 *
 * @author lidaofu
 * @since 2024/5/20
 **/
public interface IMKGetStatisticCallBack extends Callback {


    public void invoke(Pointer user_data, MK_INI ini);

}
