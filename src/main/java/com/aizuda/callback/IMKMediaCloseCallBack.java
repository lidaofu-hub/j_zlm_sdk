
package com.aizuda.callback;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * MediaSource.close()回调事件
 */
public interface IMKMediaCloseCallBack extends Callback {
    /**
     * MediaSource.close()回调事件
     * 在选择关闭一个关联的MediaSource时，将会最终触发到该回调
     * 你应该通过该事件调用mk_media_release函数并且释放其他资源
     * 如果你不调用mk_media_release函数，那么MediaSource.close()操作将无效
     *
     * @param pUser 用户数据指针，通过mk_media_set_on_close函数设置
     */
    public void invoke(Pointer pUser);
}