<p align="center">
  <a >
   <img alt="zlm4j-Logo" src="doc/images/logo.jpg" width="350px">
  </a>
</p>

# 📌 zlm4j 📌

[![star](https://gitee.com/aizuda/zlm4j/badge/star.svg?theme=white)](https://gitee.com/aizuda/zlm4j/stargazers)  [![fork](https://gitee.com/aizuda/zlm4j/badge/fork.svg?theme=white)](https://gitee.com/aizuda/zlm4j/members)

## 😁项目文档
[飞书文档直达 https://ux5phie02ut.feishu.cn/wiki/NA2ywJRY2ivALSkPfUycZFM4nUB?from=from_copylink ](https://ux5phie02ut.feishu.cn/wiki/NA2ywJRY2ivALSkPfUycZFM4nUB?from=from_copylink)
## 😁项目简介

**zlm4j开源流媒体服务框架 ZLMediaKit C Api 的 Java 实现**

感谢 [@夏楚](https://github.com/xia-chu)
提供了这么好的开源流媒体服务框架[ZLMediaKit ](https://github.com/ZLMediaKit/ZLMediaKit)

本项目是对 ZLMediaKit 提供的 C Api 的 Java Api 封装(部分封装)。采用 JNA 对 ZLMediaKit C Api 进行解析，并进行微调和修改，基于
ZLMediaKit 项目的调用原始风格，各位网友可以参照 ZLMediaKit 原始项目文档编写应用程序。

使用此项目可以实现现有项目快速集成流媒体服务功能，无需部署额外的流媒体服务器，利用原始流事件回调更加方便的操作流(
推拉流鉴权、按需拉流、自动关流、转协议、截图、录制、国标GB推流)

具体如何集成到项目可以参考[JMediaServer](https://gitee.com/daofuli/j_media_server)

## 😁版本更新
- v1.2.4 拉取基于2025-03-09-master分支编译开发 1.修复优化部分功能
- v1.2.3 拉取基于2025-03-03-master分支编译开发 1.编译降低GLIBC版本，增加兼容性 2.增加PS解封装器 3.修复优化部分功能
- v1.2.2 拉取基于2025-01-19-master分支编译开发 1.修复优化部分功能
- v1.2.1 拉取基于2024-12-04-master分支编译开发 1.修复1.2.0 win64库链接问题
- v1.2.0 拉取基于2024-12-04-master分支编译开发 1.修复优化部分功能
- v1.1.9 拉取基于2024-10-18-master分支编译开发 1.增加文件夹MP4文件夹点播功能 2.补充h264分帧功能 3.修复优化部分功能
- v1.1.8 拉取基于2024-08-22-master分支编译开发 1.确保start_send_rtp相关线程安全，同时新增多个接口支持指定配置参数
- v1.1.7 拉取基于2024-08-14-master分支编译开发 1.同步ZLMediaKit滚动更新
- v1.1.6 拉取基于2024-07-28-master分支编译开发 1.同步ZLMediaKit滚动更新 2.增加GB28181模式，支持TCP/UDP主动被动
- v1.1.5 拉取基于2024-07-10-master分支编译开发 1.同步ZLMediaKit滚动更新 2.增加添加RTP服务配置 vhost及app功能 3.增加获取http请求头信息列表
- v1.1.4 拉取基于2024-06-28-master分支编译开发 1.同步ZLMediaKit滚动更新 2.增加RTSP回放流倍速配置
- v1.1.3 拉取基于2024-06-16-master分支编译开发 1.同步增加部分api 2.优化部分功能
- v1.1.2 拉取基于2024-06-12-master分支编译开发 1.修复RTP单端口断言导致问题
- v1.1.1 拉取基于2024-06-10-master分支编译开发 1.增加拉流代理mk_proxy_player_set_on_play_result回调 2.修改IMKProxyPlayCloseCallBack=>IMKProxyPlayerCallBack
- v1.1.0 拉取基于2024-06-03-master分支编译开发 1.增加Linux_aarch64支持
- v1.0.9 拉取基于2024-06-03-master分支编译开发 1.同步ZLMediaKit滚动更新 2.增加Mac_arm64支持
- v1.0.8.1 修改支持jdk1.8
- v1.0.8 拉取基于2024-05-29-master分支编译开发 1.增加拉流重试次数配置
- v1.0.7 拉取基于2024-05-20-master分支编译开发 1.增加内存数据统计相关api及回调
- v1.0.6 拉取基于2024-05-16-master分支编译开发 1.创建流增加x264编码库支持 2.创建流增加faac编码库支持
- v1.0.5 拉取基于2024-05-10-master分支编译开发 1.增加on_record_ts回调 2.修改mk_mp4_info为mk_record_info
- v1.0.4 拉取基于2024-05-07-master分支编译开发 1.增加rtc相关回调及函数
- v1.0.3 拉取基于2024-04-02-master分支编译开发 1.增加MediaSource获取源地址 源类型 创建时间戳
- v1.0.2 拉取基于2024-04-01-master分支编译开发 1.增加mac环境包 2.修改包名域
- v1.0.1 拉取基于2024-02-05-master分支编译开发 增加拉流代理参数配置
- v1.0-SNAPSHOT (初始版本)拉取基于2023-11-23-master分支开发

## 😁SDK功能

- **流媒体服务**：支持自定义HTTP/RTSP/RTMP流媒体服务端口，支持原生ZLMediaKit各种配置
- **推流功能**：支持ZLMediaKit提供的RTSP/RTMP/RTC/SRT/GB28181/WebRTC等协议推流，支持推流鉴权
- **拉流功能**：支持RTSP/RTMP/HTTP-FLV/WS-FLV/WS-HLS/FMP4等流协议输出
- **流代理功能**：支持RTSP/RTMP/HTTP-FLV/HLS等流接入，支持拉流鉴权、按需拉流、无人观看自动关流、流量统计
- **录制功能**：支持录制MP4/FLV/M3U8等格式，支持MP4分片大小控制
- **事件**：支持流上下线、推拉流、流录制完成、无人观看、RTSP鉴权等回调

## 😁项目组成

1. 本项目已包含所需的win64/linux64/linux_arm64/mac64/mac_arm64动态链接库mk_api.dll\libmk_api.so\libmk_api.dylib,其他系统链接库请自行编译，并放到自己系统对应的目录中即可使用 ~~如ARM64版本mac电脑需要放到自己项目的resources/darwin-aarch64下~~ 。
2. 相关配置项及翻译在resources/conf.ini中，配置方式参见示例代码，或者导入配置文件
3. 本项目包含 core、callback、structure 模块

- **core**：为核心模块，封装常用大部分 API，如有没有添加想要的，可以添加对应的 API 到 ZLMApi
- **callback**：对应 C Api 中回调
- **structure**：对应 C Api 中结构体 注意由于 C Api 中结构体为空，所以 dwSize 为添加的默认参数，否则运行会报错

## 😁示例代码
**注意示例代码只提供部分功能演示，更多功能请阅读项目文档。**
``` java
public class Test {
    //动态链接库放在/resource/win32-x86-64&/resource/linux-x86-64下JNA会自动查找目录
    public static ZLMApi ZLM_API = Native.load("mk_api", ZLMApi.class);
    //Windows环境测试
    //public static ZLMApi ZLM_API = Native.load("E:\\ZLMediaKit\\release\\windows\\Debug\\mk_api.dll", ZLMApi.class);
    //Linux环境测试
    //public static ZLMApi ZLM_API = Native.load("/opt/media/libmk_api.so", ZLMApi.class);

    public static void main(String[] args) throws InterruptedException {
        //初始化sdk配置
        ZLM_API.mk_env_init2(1, 1, 1, null, 0, 0, null, 0, null, null);
        //初始化环境配置 SDK参数配置详见ZLM4J参数配置
        MK_INI mkIni = ZLM_API.mk_ini_default();
        //配置参数 全部配置参数及说明见(resources/conf.ini) 
        ZLM_API.mk_ini_set_option(mkIni, "general.mediaServerId", "JMediaServer");
        ZLM_API.mk_ini_set_option(mkIni, "http.notFound", "<h1 style=\"text-align:center;\">Media Server V1.0 By LiDaoFu</h1>");
        ZLM_API.mk_ini_set_option_int(mkIni, "protocol.auto_close", 0);
        ZLM_API.mk_ini_set_option_int(mkIni, "general.streamNoneReaderDelayMS", 30000);
        ZLM_API.mk_ini_set_option_int(mkIni, "general.maxStreamWaitMS", 30000);
        ZLM_API.mk_ini_set_option_int(mkIni, "protocol.enable_ts", 1);
        ZLM_API.mk_ini_set_option_int(mkIni, "protocol.enable_hls", 1);
        ZLM_API.mk_ini_set_option_int(mkIni, "protocol.enable_fmp4", 1);
        ZLM_API.mk_ini_set_option_int(mkIni, "protocol.enable_rtsp", 1);
        ZLM_API.mk_ini_set_option_int(mkIni, "protocol.enable_rtmp", 1);
        ZLM_API.mk_ini_set_option_int(mkIni, "protocol.enable_mp4", 1);
        ZLM_API.mk_ini_set_option_int(mkIni, "protocol.enable_hls_fmp4", 1);
        ZLM_API.mk_ini_set_option_int(mkIni, "protocol.enable_audio", 1);
        ZLM_API.mk_ini_set_option_int(mkIni, "protocol.mp4_as_player", 1);
        ZLM_API.mk_ini_set_option_int(mkIni, "protocol.mp4_max_second", 3600);
        ZLM_API.mk_ini_set_option(mkIni, "http.rootPath", "D:/www");
        ZLM_API.mk_ini_set_option(mkIni, "protocol.mp4_save_path", "D:/www");
        ZLM_API.mk_ini_set_option(mkIni, "protocol.hls_save_path", "D:/www");
        ZLM_API.mk_ini_set_option_int(mkIni, "protocol.hls_demand", 0);
        ZLM_API.mk_ini_set_option_int(mkIni, "protocol.rtsp_demand", 0);
        ZLM_API.mk_ini_set_option_int(mkIni, "protocol.rtmp_demand", 0);
        ZLM_API.mk_ini_set_option_int(mkIni, "protocol.ts_demand", 0);
        ZLM_API.mk_ini_set_option_int(mkIni, "protocol.fmp4_demand", 0);
        //全局回调 全部回调见MK_EVENTS内所有的回调属性，如果配置了推流回调、播放回调请务必执行invoker_do，否则无法推流、回放
        MK_EVENTS mkEvents = new MK_EVENTS();
        //流状态改变回调
        mkEvents.on_mk_media_changed = (regist, sender) -> {
            System.out.println("app:" + ZLM_API.mk_media_source_get_app(sender));
            System.out.println("stream:" + ZLM_API.mk_media_source_get_stream(sender));
            System.out.println("schema:" + ZLM_API.mk_media_source_get_schema(sender));
            System.out.println("这里是流改变回调通知:" + regist);
        };
        //无人观看回调
        mkEvents.on_mk_media_no_reader = sender -> {
            System.out.println("这里是无人观看回调通知");
            ZLM_API.mk_media_source_close(sender, 1);
        };
        //推流回调 可控制鉴权、录制、转协议控制等
        mkEvents.on_mk_media_publish = (url_info, invoker, sender) -> {
            //这里拿到访问路径后(例如rtmp://xxxx/xxx/xxx?token=xxxx其中?后面就是拿到的参数)的参数
            // err_msg返回 空字符串表示鉴权成功 否则鉴权失败提示
            //String param = ZLM_API.mk_media_info_get_params(url_info);
            MK_INI option = ZLM_API.mk_ini_create();
            ZLM_API.mk_ini_set_option_int(option, "enable_mp4", 1);
            ZLM_API.mk_ini_set_option_int(option, "enable_audio", 1);
            ZLM_API.mk_ini_set_option_int(option, "enable_fmp4",1);
            ZLM_API.mk_ini_set_option_int(option, "enable_ts", 1);
            ZLM_API.mk_ini_set_option_int(option, "enable_hls",1);
            ZLM_API.mk_ini_set_option_int(option, "enable_rtsp", 1);
            ZLM_API.mk_ini_set_option_int(option, "enable_rtmp", 1);
            ZLM_API.mk_ini_set_option_int(option, "auto_close", 0);
            ZLM_API.mk_ini_set_option(option, "stream_replace", "test1");
            //流名称替换
            //ZLM_API.mk_ini_set_option(option, "stream_replace", "test1");
            ZLM_API.mk_publish_auth_invoker_do2(invoker, "", option);
            ZLM_API.mk_ini_release(option);
            //ZLM_API.mk_publish_auth_invoker_do(invoker, "", 0, 0);
        };
        //添加全局回调
        ZLM_API.mk_events_listen(mkEvents);
        //创建http服务器 0:失败,非0:端口号
        short http_server_port = ZLM_API.mk_http_server_start((short) 7788, 0);
        //创建rtsp服务器 0:失败,非0:端口号
        short rtsp_server_port = ZLM_API.mk_rtsp_server_start((short) 554, 0);
        //创建rtmp服务器 0:失败,非0:端口号
        short rtmp_server_port = ZLM_API.mk_rtmp_server_start((short) 1935, 0);
        //创建RTC服务器 0:失败,非0:端口号
        short rtc_server_port = ZLM_API.mk_rtc_server_start((short) 8000);
        /*****************************下面为推流及播放********************************/
        // 推流：利用obs、ffmpeg 进行推流 RTMP推流：rtmp://127.0.0.1:rtmp_port/流APP/流名称  RTSP推流：rtsp://127.0.0.1:rtsp_port/流APP/流名称
        // 下面是各协议拉流播放的访问格式
        // HTTP-FLV拉流：http://ip:http_port/流APP/流名称.live.flv
        // WS-FLV拉流：ws://ip:http_port/流APP/流名称.live.flv
        // HLS拉流：http://ip:http_port/流APP/流名称/hls.m3u8
        // RTMP拉流：rtmp://ip:rtmp_port/流APP/流名称
        // RTSP拉流：rtsp://ip:rtsp_port/流APP/流名称
        /*****************************下面为流代理演示********************************/
        //创建拉流代理
        MK_INI option = ZLM_API.mk_ini_create();
        ZLM_API.mk_ini_set_option_int(option, "enable_mp4", 0);
        ZLM_API.mk_ini_set_option_int(option, "enable_audio", 0);
        ZLM_API.mk_ini_set_option_int(option, "enable_fmp4", 0);
        ZLM_API.mk_ini_set_option_int(option, "enable_ts", 0);
        ZLM_API.mk_ini_set_option_int(option, "enable_hls", 0);
        ZLM_API.mk_ini_set_option_int(option, "enable_rtsp", 1);
        ZLM_API.mk_ini_set_option_int(option, "enable_rtmp", 1);
        ZLM_API.mk_ini_set_option_int(option, "mp4_max_second", 3600);
        //ZLM_API.mk_ini_set_option(option,"mp4_save_path","D:/record");
        //ZLM_API.mk_ini_set_option(option,"hls_save_path","D:/record");
        ZLM_API.mk_ini_set_option_int(option, "add_mute_audio", 0);
        ZLM_API.mk_ini_set_option_int(option, "auto_close", 1);
        MK_PROXY_PLAYER mk_proxy = ZLM_API.mk_proxy_player_create4("__defaultVhost__", "live", "test",option,2);
        //设置代理参数 rtp_type  rtsp播放方式:RTP_TCP = 0, RTP_UDP = 1, RTP_MULTICAST = 2
        ZLM_API.mk_proxy_player_set_option(mk_proxy, "rtp_type", "1");
        //设置代理参数 protocol_timeout_ms  协议超时时间 毫秒
        ZLM_API.mk_proxy_player_set_option(mk_proxy, "protocol_timeout_ms", "2000");
        //开始播放
        ZLM_API.mk_proxy_player_play(mk_proxy, "rtsp://admin:hk123456@192.168.1.64/h264/ch1/sub/av_stream");
        //释放资源
        ZLM_API.mk_ini_release(option);
        //第一次代理结果获取
        IMKProxyPlayerCallBack imkProxyPlayerCallBack = new IMKProxyPlayerCallBack() {
            @Override
            public void invoke(Pointer pUser, int err, String what, int sys_err) {
                if (err == 0){
                    System.out.println("代理播放成功");
                }else{
                    System.out.println("代理播放失败："+what);
                    ZLM_API.mk_proxy_player_release(new MK_PROXY_PLAYER(pUser));
                }
            }
        };
        ZLM_API.mk_proxy_player_set_on_play_result(mk_proxy,imkProxyPlayerCallBack , mk_proxy.getPointer(),null);
        //回调关闭事件
        IMKProxyPlayerCallBack imkProxyPlayCloseCallBack = new IMKProxyPlayerCallBack() {
            @Override
            public void invoke(Pointer pUser, int err, String what, int sys_err) {
                System.out.println("拉流代理关闭");
                //这里Pointer是ZLM维护的不需要我们释放 遵循谁申请谁释放原则
                ZLM_API.mk_proxy_player_release(new MK_PROXY_PLAYER(pUser));
            }
        };
        //添加代理关闭回调 并把代理客户端传过去释放
        ZLM_API.mk_proxy_player_set_on_close(mk_proxy, imkProxyPlayCloseCallBack, mk_proxy.getPointer());
        /*****************************end********************************/

        //阻塞60s
        Thread.sleep(60000L);
        //停止所有服务器
        ZLM_API.mk_stop_all_server();
    }
}



```

## 😁集成项目

1. 可直接复制代码到自己的项目中，方便修改参数进行二次开发

2. jar已发布到maven重要仓库，如需修改动态链接库请拉取项目install，并把动态链接库放入对应的目录。

``` xml
        <dependency>
            <groupId>com.aizuda</groupId>
            <artifactId>zlm4j</artifactId>
            <version>${lasted}</version>
        </dependency>
```

## 😁鸣谢
同时感谢JetBrains对开源项目的支持，本项目使用CLion/IDEA开发与调试：
 <p align="left">
  <a >
   <img alt="zlm4j-qun" src="doc/images/clion.png" width="350px">
    <img alt="zlm4j-qun" src="doc/images/idea.png" width="350px">
  </a>
</p>



## 😁常见问题

1. 参见[ZLM4J常见问题 ](https://ux5phie02ut.feishu.cn/wiki/SzIAwyxnpilVMlkccS4cfJFGn1g)

## 😁学习探讨

 <p align="center">
  <a >
   <img alt="zlm4j-qun" src="doc/images/qun.jpg" width="350px">
  </a>
</p>
