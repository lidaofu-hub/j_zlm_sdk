
package com.aizuda.zlm4j.callback;

import com.aizuda.zlm4j.structure.MK_PARSER;
import com.aizuda.zlm4j.structure.MK_SOCK_INFO;
import com.sun.jna.Callback;

/**
 * 在http文件服务器中,收到http访问文件或目录前的广播,通过该事件可以控制http url到文件路径的映射
 */
public interface IMKHttpBeforeAccessCallBack extends Callback {
    /**
     * 在http文件服务器中,收到http访问文件或目录前的广播,通过该事件可以控制http url到文件路径的映射
     * 在该事件中通过自行覆盖path参数，可以做到譬如根据虚拟主机或者app选择不同http根目录的目的
     *
     * @param parser http请求内容对象
     * @param path   文件绝对路径,覆盖之可以重定向到其他文件
     * @param sender http客户端相关信息
     */
    public void invoke(MK_PARSER parser, String path, MK_SOCK_INFO sender);
}