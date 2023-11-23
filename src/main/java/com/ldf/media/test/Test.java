package com.ldf.media.test;

import com.ldf.media.callback.*;
import com.ldf.media.core.ZLMApi;
import com.ldf.media.structure.*;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

/**
 * 1
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class Test {
    public static ZLMApi ZLM_API = Native.load("D:\\ZLMediaKit\\source\\out\\install\\x64-Debug\\bin\\mk_api.dll", ZLMApi.class);

    public static void main(String[] args) throws InterruptedException {
        MK_INI mkIni = ZLM_API.mk_ini_default();
        ZLM_API.mk_ini_set_option_int(mkIni, "protocol.auto_close", 1);
        MK_EVENTS mkEvents = new MK_EVENTS();
        mkEvents.on_mk_media_changed= (regist, sender) -> {
            System.out.println("这里是流改变回调通知");
        };
        mkEvents.on_mk_media_no_reader= sender -> {
            System.out.println("这里是无人观看回调通知");
        };
        ZLM_API.mk_events_listen(mkEvents);
        //Pointer iniPointer = ZLM_API.mk_ini_dump_string(mkIni);
        //初始化zmk服务器
        ZLM_API.mk_env_init1(1, 1, 1, null, 0, 0, null, 0, null, null);
        //创建http服务器
        short http_server_id = ZLM_API.mk_http_server_start((short) 7788, 0);
        //创建rtsp服务器
        short rtsp_server_id = ZLM_API.mk_rtsp_server_start((short) 7554, 0);
        //创建rtmp服务器
        short rtmp_server_id = ZLM_API.mk_rtmp_server_start((short) 7935, 0);

        //创建mk代理
        MK_PROXY_PLAYER mk_proxy = ZLM_API.mk_proxy_player_create("__defaultVhost__", "live", "test", 0, 0);
        //开始播放
        IMKProxyPlayCloseCallBack imkProxyPlayCloseCallBack = new IMKProxyPlayCloseCallBack() {
            @Override
            public void invoke(Pointer pUser, int err, String what, int sys_err) {
                ZLM_API.mk_proxy_player_release(new MK_PROXY_PLAYER(pUser));
            }
        };
        ZLM_API.mk_proxy_player_play(mk_proxy, "rtsp://admin:telit123@172.16.6.236/h264/ch1/main/av_stream");
        ZLM_API.mk_proxy_player_set_on_close(mk_proxy, imkProxyPlayCloseCallBack, mk_proxy.getPointer());

        Thread.sleep(10000L);
        Thread.sleep(30000L);
      //  ZLM_API.mk_proxy_player_release(mk_proxy);
       /* ZLM_API.mk_ini_release(mkIni);*/
        //停止所有服务器
        ZLM_API.mk_stop_all_server();

    }
}
