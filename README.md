# 📌 zlm4j 📌
[![star](https://gitee.com/aizuda/zlm4j/badge/star.svg?theme=white)](https://gitee.com/aizuda/zlm4j/stargazers)  [![fork](https://gitee.com/aizuda/zlm4j/badge/fork.svg?theme=white)](https://gitee.com/aizuda/zlm4j/members)
## 😁项目简介

**zlm4j开源流媒体服务框架 ZLMediaKit C Api 的 Java 实现**

感谢 [@夏楚](https://github.com/xia-chu) 提供了这么好的开源流媒体服务框架[ZLMediaKit ](https://github.com/ZLMediaKit/ZLMediaKit)

本项目是对 ZLMediaKit 提供的 C Api 的 Java Api 封装(部分封装)。采用 JNA 对 ZLMediaKit C Api 进行解析，并进行微调和修改，基于 ZLMediaKit 项目的调用原始风格，各位网友可以参照 ZLMediaKit 原始项目文档编写应用程序。

使用此项目可以实现现有项目快速集成流媒体服务功能，无需部署额外的流媒体服务器，利用原始流事件回调更加方便的操作流(推拉流鉴权、按需拉流、自动关流、转协议、截图、录制、国标GB推流)

具体如何集成到项目可以参考[JMediaServer](https://github.com/lidaofu-hub/j_media_server)

## 😁SDK功能
- **流媒体服务**：支持自定义HTTP/RTSP/RTMP流媒体服务端口，支持原生ZLMediaKit各种配置
- **推流功能**：支持ZLMediaKit提供的RTSP/RTMP/RTC/SRT/GB28181/WebRTC等协议推流，支持推流鉴权
- **拉流功能**：支持RTSP/RTMP/HTTP-FLV/WS-FLV/WS-HLS/FMP4等流协议输出
- **流代理功能**：支持RTSP/RTMP/HTTP-FLV/HLS等流接入，支持拉流鉴权、按需拉流、无人观看自动关流、流量统计
- **录制功能**：支持录制MP4/FLV/M3U8等格式，支持MP4分片大小控制
- **事件**：支持流上下线、推拉流、流录制完成、无人观看、RTSP鉴权等回调

## 😁项目组成

1. 本项目拉取基于 2023-11-23 master 分支编译开发
2. 本项目不包含所需的动态链接库 mk_api.dll\libmk_api.so 请拉取对应版本编译(或使用[JMediaServer](https://github.com/lidaofu-hub/j_media_server)项目中/resource/win32-x86-64&/resource/linux-x86-64 下)
3. 相关配置项及翻译在resources/conf.ini中，配置方式参见示例代码，或者导入配置文件
3. 本项目包含 core、callback、structure、test 模块
- **core**：为核心模块，封装常用大部分 API，如有没有添加想要的，可以添加对应的 API 到 ZLMApi
- **callback**：对应 C Api 中回调
- **structure**：对应 C Api 中结构体 注意由于 C Api 中结构体为空，所以 dwSize 为添加的默认参数，否则运行会报错
- **test**：为该工程为演示/测试程序，测试可以跑在 Windows10_x64、Ubuntu22.04.2LTS_x64、CentOs7.9_x64，其他环境请编译对应的链接库测试下。

## 😁实例代码

``` java
public class Test {
	//动态链接库放在/resource/win32-x86-64&/resource/linux-x86-64下JNA会自动查找目录
	//public static ZLMApi ZLM_API = Native.load("mk_api", ZLMApi.class);
    //Windows环境测试 自定义动态链接库目录 
    public static ZLMApi ZLM_API = Native.load("D:\\ZLMediaKit\\source\\release\\windows\\Debug\\mk_api.dll", ZLMApi.class);
    //Linux环境测试 自定义动态链接库目录 
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

```

## 😁集成项目

1. 可直接复制代码到自己的项目中，方便修改参数进行二次开发

2. 由于此项目暂未发布到中央仓库，可以下载此项目然后打包到本地仓库（mvn install）然后项目引入

``` xml
        <dependency>
            <groupId>com.aizuda</groupId>
            <artifactId>zlm4j</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
```



## 😁常见问题

1. 在 windows 环境运行出现 java.lang.UnsatisfiedLinkError 问题，请安装 openssl 库 参见[OpenSSL 下载 ](https://slproweb.com/products/Win32OpenSSL.html) 或者复制libssl-3-x64.dll&libcrypto-3-x64.dll到系统动态链接库下

## 😁学习探讨

    wx：L746101210
