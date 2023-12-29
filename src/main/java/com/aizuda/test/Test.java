package com.aizuda.test;

import com.aizuda.callback.IMKProxyPlayCloseCallBack;
import com.aizuda.core.ZLMApi;
import com.aizuda.structure.MK_EVENTS;
import com.aizuda.structure.MK_INI;
import com.aizuda.structure.MK_PROXY_PLAYER;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

/**
 * 测试程序  展示了服务器配置 系统配置 流媒体服务启动 回调监听  拉流代理
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public class Test {
    //动态链接库放在/resource/win32-x86-64&/resource/linux-x86-64下JNA会自动查找目录
    //public static ZLMApi ZLM_API = Native.load("mk_api", ZLMApi.class);
    //Windows环境测试
    public static ZLMApi ZLM_API = Native.load("D:\\ZLMediaKit\\source\\release\\windows\\Debug\\mk_api.dll", ZLMApi.class);
    //Linux环境测试
    //public static ZLMApi ZLM_API = Native.load("/opt/media/libmk_api.so", ZLMApi.class);

    public static void main(String[] args) throws InterruptedException {
        //初始化环境配置
        MK_INI mkIni = ZLM_API.mk_ini_default();
        //配置参数 打开自动关流 对应conf.ini中配置[protocol] auto_close
        ZLM_API.mk_ini_set_option_int(mkIni, "protocol.auto_close", 1);
        ZLM_API.mk_ini_set_option_int(mkIni,"protocol.enable_fmp4",0);
        ZLM_API.mk_ini_set_option_int(mkIni,"protocol.enable_hls",0);
        ZLM_API.mk_ini_set_option_int(mkIni,"protocol.enable_ts",0);
        //全局回调
        MK_EVENTS mkEvents = new MK_EVENTS();
        mkEvents.on_mk_media_changed= (regist, sender) -> {
            System.out.println("这里是流改变回调通知:"+regist);
        };
        mkEvents.on_mk_media_no_reader= sender -> {
            System.out.println("这里是无人观看回调通知");
            ZLM_API.mk_media_source_close(sender,1);
        };
        mkEvents.on_mk_media_publish= (url_info, invoker, sender) -> {
            ZLM_API.mk_publish_auth_invoker_do(invoker,"0",0,0);
        };
        //添加全局回调
        ZLM_API.mk_events_listen(mkEvents);
        //Pointer iniPointer = ZLM_API.mk_ini_dump_string(mkIni);
        //初始化zmk服务器
        ZLM_API.mk_env_init1(1, 1, 1, null, 0, 0, null, 0, null, null);
        //创建http服务器 0:失败,非0:端口号
        short http_server_port = ZLM_API.mk_http_server_start((short) 7788, 0);
        //创建rtsp服务器 0:失败,非0:端口号
        short rtsp_server_port = ZLM_API.mk_rtsp_server_start((short) 7554, 0);
        //创建rtmp服务器 0:失败,非0:端口号
        short rtmp_server_port  = ZLM_API.mk_rtmp_server_start((short) 7935, 0);
        //创建拉流代理
        MK_PROXY_PLAYER mk_proxy = ZLM_API.mk_proxy_player_create("__defaultVhost__", "live", "test", 0, 0);
        //回调关闭时间
        IMKProxyPlayCloseCallBack imkProxyPlayCloseCallBack = new IMKProxyPlayCloseCallBack() {
            @Override
            public void invoke(Pointer pUser, int err, String what, int sys_err) {
                //这里Pointer是ZLM维护的不需要我们释放 遵循谁申请谁释放原则
                ZLM_API.mk_proxy_player_release(new MK_PROXY_PLAYER(pUser));
            }
        };
        //开始播放
        ZLM_API.mk_proxy_player_play(mk_proxy, "rtsp://admin:telit123@172.16.6.236/h264/ch1/main/av_stream");
        //添加代理关闭回调 并把代理客户端传过去释放
        ZLM_API.mk_proxy_player_set_on_close(mk_proxy, imkProxyPlayCloseCallBack, mk_proxy.getPointer());

        //阻塞60s
        Thread.sleep(60000L);
        //停止所有服务器
        ZLM_API.mk_stop_all_server();
    }
}
