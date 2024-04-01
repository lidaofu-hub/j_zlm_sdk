package com.aizuda.zlm4j.callback;

import com.sun.jna.Callback;

/**
 * 日志输出广播
 */
public interface IMKLogCallBack extends Callback {
    /**
     * 日志输出广播
     *
     * @param level    日志级别
     * @param file     源文件名
     * @param line     源文件行
     * @param function 源文件函数名
     * @param message  日志内容
     */
    public void invoke(int level, String file, int line, String function, String message);
}