

📌 zlm4j 📌

[![star](https://gitee.com/aizuda/zlm4j/badge/star.svg?theme=white)](https://gitee.com/aizuda/zlm4j/stargazers)  [![fork](https://gitee.com/aizuda/zlm4j/badge/fork.svg?theme=white)](https://gitee.com/aizuda/zlm4j/members)

## 😁 项目文档
[飞书文档直达 https://ux5phie02ut.feishu.cn/wiki/NA2ywJRY2ivALSkPfUycZFM4nUB?from=from_copylink ](https://ux5phie02ut.feishu.cn/wiki/NA2ywJRY2ivALSkPfUycZFM4nUB?from=from_copylink)

## 😁 项目简介
**zlm4j开源流媒体服务框架 ZLMediaKit C Api 的 Java 实现**

感谢 [@夏楚](https://github.com/xia-chu) 提供优秀的开源流媒体服务框架 [ZLMediaKit ](https://github.com/ZLMediaKit/ZLMediaKit)

本项目是对 ZLMediaKit 提供的 C Api 的 Java Api 封装(部分封装)。采用 JNA 对 ZLMediaKit C Api 进行解析，并基于原始调用风格进行微调和修改，方便开发者参照 ZLMediaKit 项目文档进行应用程序开发。

使用此项目可实现现有项目快速集成流媒体服务功能，无需部署额外服务器，利用流事件回调便于操作流(推拉流鉴权、按需拉流、自动关流、协议转换、截图、录制、国标GB推流)。

## 😁 版本更新
- v1.7.2 基于2025-11-26-master分支开发：1.优化部分功能
- v1.7.1 基于2025-11-4-master分支开发：1.优化部分功能
- v1.7.0 基于2025-10-16-master分支开发：增加更多视频编码支持
- v1.6.1 升级jna到最新版本
- v1.6.0 基于2025-09-264-master分支编译开发 1.增加webrtc推拉流代理 2.增加webrtc p2p模式及相关函数 3.优化部分功能
- v1.5.3 基于2025-9-11-master分支开发：修复优化部分功能
- v1.5.3 基于2025-9-11-master分支开发：修复优化部分功能
- v1.5.2 基于2025-8-11-master分支开发：新增mk_media_source_set_speed函数
- v1.5.1 基于2025-8-11-master分支开发：修复优化部分功能
- v1.5.0 基于2025-8-9-master分支开发：新增录制任务、RTP多路复用等接口，支持流速配置
- 更多版本更新请查看完整更新日志

## 😁 SDK功能
- **流媒体服务**：支持HTTP/RTSP/RTMP端口自定义，兼容ZLMediaKit配置
- **推流**：支持RTSP/RTMP/RTC/SRT/GB28181/WebRTC协议，支持推流鉴权
- **拉流**：支持RTSP/RTMP/FLV/HLS/FMP4等协议输出
- **代理功能**：支持拉流接入，具备鉴权、按需拉流、自动关流、流量统计
- **录制功能**：支持MP4/FLV/M3U8格式，支持MP4分片控制
- **事件回调**：支持流上下线、推拉流、录制完成、无人观看、RTSP鉴权等回调

## 😁 项目组成
1. 项目包含win64/linux64/linux_arm64/mac64/mac_arm64动态库(mk_api.dll/libmk_api.so/libmk_api.dylib)，其他系统可自行编译并放置对应目录
2. 配置文件resources/conf.ini，配置方式参见示例代码
3. 项目包含core、callback、structure模块
   - **core**：核心API封装
   - **callback**：回调接口实现
   - **structure**：结构体定义（含默认dwSize参数）

## 😁 示例代码
```java
public class Test {
    //动态链接库自动加载
    public static ZLMApi ZLM_API = Native.load("mk_api", ZLMApi.class);

    public static void main(String[] args) throws InterruptedException {
        //初始化SDK
        ZLM_API.mk_env_init2(1, 1, 1, null, 0, 0, null, 0, null, null);
        
        //配置服务器参数
        MK_INI mkIni = ZLM_API.mk_ini_default();
        ZLM_API.mk_ini_set_option(mkIni, "general.mediaServerId", "JMediaServer");
        
        //注册全局回调
        MK_EVENTS mkEvents = new MK_EVENTS();
        mkEvents.on_mk_media_changed = (regist, sender) -> {
            System.out.println("流状态变化: " + regist);
        };
        
        //启动服务
        ZLM_API.mk_events_listen(mkEvents);
        short httpPort = ZLM_API.mk_http_server_start((short)7788, 0);
        short rtspPort = ZLM_API.mk_rtsp_server_start((short)554, 0);
        
        // ... 启动其他服务
        
        //阻塞并释放资源
        Thread.sleep(60000L);
        ZLM_API.mk_stop_all_server();
    }
}
```

## 😁 集成方式
1. 可直接复制代码到项目进行二次开发
2. Maven中央仓库集成：
```xml
<dependency>
    <groupId>com.aizuda</groupId>
    <artifactId>zlm4j</artifactId>
    <version>${lasted}</version>
</dependency>
```

## 😁 鸣谢
感谢JetBrains对开源项目的支持，项目使用CLion/IDEA进行开发调试

## 😁 常见问题
1. 参见 [ZLM4J常见问题 ](https://ux5phie02ut.feishu.cn/wiki/SzIAwyxnpilVMlkccS4cfJFGn1g)

## 😁 学习探讨
扫码加入交流群获取最新动态：
![交流群二维码](doc/images/qun.jpg)
