## 项目简介
开源流媒体服务框架ZLMediaKit C Api的Java实现

感谢 [@夏楚](https://github.com/xia-chu) 提供了这么好的开源流媒体服务器软件[ZLMediaKit ](https://github.com/ZLMediaKit/ZLMediaKit)

本项目是对ZLMediaKit提供的C Api的 Java Api封装(部分封装)。采用 JNA 对 ZLMediaKit 进行解析，并进行微调和修改，基于 ZLMediaKit 项目的调用原始风格，各位网友可以参照 ZLMediaKit 原始项目文档编写应用程序。

## 项目组成
1. 本项目拉取基于2023-11-23 master分支编译开发
2. 本项目不包含所需的动态链接库mk_api.dll\libmk_api.so 请拉取对应版本编译
3. 本项目包含core、callback、structure、test模块
    - core：为核心模块，封装常用大部分API，如有没有添加想要的，可以添加对应的API到ZLMApi
    - callback：对应C Api中回调
    - structure：对应C Api中结构体 注意由于C Api中结构体为空，所以dwSize为添加的默认参数，否则运行会报错
    - test：为该工程为演示/测试程序，测试可以跑在Windows10_x64、Ubuntu22.04.2LTS_x64、CentOs7.9_x64，其他环境请编译对应的链接库测试下。