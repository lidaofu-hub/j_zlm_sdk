package com.ldf.media.structure;

import com.sun.jna.Pointer;

/**
 * 配置
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class MK_CONFIG extends SdkStructure {

    // 线程数
    public int thread_num;
    // 日志级别,支持0~4
    public int log_level;
    //控制日志输出的掩模，请查看LOG_CONSOLE、LOG_FILE、LOG_CALLBACK等宏
    public int log_mask;
    //文件日志保存路径,路径可以不存在(内部可以创建文件夹)，设置为NULL关闭日志输出至文件
    public String log_file_path;
    //文件日志保存天数,设置为0关闭日志文件
    public int log_file_days;
    // 配置文件是内容还是路径
    public int ini_is_path;
    // 配置文件内容或路径，可以为NULL,如果该文件不存在，那么将导出默认配置至该文件
    public String ini;
    // ssl证书是内容还是路径
    public int ssl_is_path;
    // ssl证书内容或路径，可以为NULL
    public String ssl;
    // 证书密码，可以为NULL
    public String ssl_pwd;
    public MK_CONFIG(Pointer pointer) {
        super(pointer);
    }
    public MK_CONFIG() {
    }
}
