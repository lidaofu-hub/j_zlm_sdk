package com.aizuda.zlm4j.core;

import com.aizuda.zlm4j.callback.*;
import com.aizuda.zlm4j.structure.*;
import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

/**
 * ZLMediaKit C Api
 *
 * @author lidaofu
 * @since 2023/11/23
 **/
public interface ZLMApi extends Library {
    /*******************************初始化与配置相关**********************************/
    /**
     * 初始化环境，调用该库前需要先调用此函数
     *
     * @param cfg 库运行相关参数
     */
    void mk_env_init(MK_CONFIG cfg);

    /**
     * 服务器初始化
     *
     * @param thread_num
     * @param log_level
     * @param log_mask
     * @param log_file_path
     * @param log_file_days
     * @param ini_is_path
     * @param ini
     * @param ssl_is_path
     * @param ssl
     * @param ssl_pwd
     */
    void mk_env_init1(int thread_num, int log_level, int log_mask, String log_file_path, int log_file_days, int ini_is_path, Pointer ini, int ssl_is_path, String ssl, String ssl_pwd);


    /**
     * 创建ini配置对象
     */
    MK_INI mk_ini_create();

    /**
     * 返回全局默认ini配置
     *
     * @return 全局默认ini配置，请勿用mk_ini_release释放它
     */
    MK_INI mk_ini_default();


    /**
     * 加载ini配置文件内容
     *
     * @param ini ini对象
     * @param str 配置文件内容
     */
    void mk_ini_load_string(MK_INI ini, String str);

    /**
     * 加载ini配置文件
     *
     * @param ini  ini对象
     * @param file 配置文件路径
     */
    void mk_ini_load_file(MK_INI ini, String file);


    /**
     * 销毁ini配置对象
     */
    void mk_ini_release(MK_INI ini);

    /**
     * 导出为配置文件内容
     *
     * @param ini 配置对象
     * @return 配置文件内容字符串，用完后需要自行mk_free
     */
    Pointer mk_ini_dump_string(MK_INI ini);

    /**
     * 导出配置文件到文件
     *
     * @param ini  配置对象
     * @param file 配置文件路径
     */
    void mk_ini_dump_file(MK_INI ini, String file);


    /**
     * 添加或覆盖配置项
     *
     * @param ini   配置对象
     * @param key   配置名，两段式，如：field.key
     * @param value 配置值
     */
    void mk_ini_set_option(MK_INI ini, String key, String value);

    void mk_ini_set_option_int(MK_INI ini, String key, int value);


    /**
     * 获取配置项
     *
     * @param ini 配置对象
     * @param key 配置名，两段式，如：field.key
     * @return 配置不存在返回NULL，否则返回配置值
     */
    String mk_ini_get_option(MK_INI ini, String key);

    /**
     * 删除配置项
     *
     * @param ini 配置对象
     * @param key 配置名，两段式，如：field.key
     * @return 1: 成功，0: 该配置不存在
     */
    int mk_ini_del_option(MK_INI ini, String key);


    /**
     * 释放mk api内部malloc的资源
     */
    void mk_free(Pointer pointer);


    /**
     * 设置日志文件
     *
     * @param file_max_size  单个切片文件大小(MB)
     * @param file_max_count 切片文件个数
     */
    void mk_set_log(int file_max_size, int file_max_count);

    /**
     * 设置配置项
     *
     * @param key 配置项名
     * @param val 配置项值
     * @deprecated 请使用mk_ini_set_option替代
     */
    void mk_set_option(String key, String val);

    /**
     * 获取配置项的值
     *
     * @param key 配置项名
     * @deprecated 请使用mk_ini_get_option替代
     */
    String mk_get_option(String key);

    /**
     * 创建http[s]服务器
     *
     * @param port htt监听端口，推荐80，传入0则随机分配
     * @param ssl  是否为ssl类型服务器
     * @return 0:失败,非0:端口号
     */
    short mk_http_server_start(short port, int ssl);

    /**
     * 创建rtsp[s]服务器
     *
     * @param port rtsp监听端口，推荐554，传入0则随机分配
     * @param ssl  是否为ssl类型服务器
     * @return 0:失败,非0:端口号
     */
    short mk_rtsp_server_start(short port, int ssl);

    /**
     * 创建rtmp[s]服务器
     *
     * @param port rtmp监听端口，推荐1935，传入0则随机分配
     * @param ssl  是否为ssl类型服务器
     * @return 0:失败,非0:端口号
     */
    short mk_rtmp_server_start(short port, int ssl);

    /**
     * 创建rtp服务器
     *
     * @param port rtp监听端口(包括udp/tcp)
     * @return 0:失败,非0:端口号
     */
    short mk_rtp_server_start(short port);

    /**
     * 创建rtc服务器
     *
     * @param port rtc监听端口
     * @return 0:失败,非0:端口号
     */
    short mk_rtc_server_start(short port);


    /**
     * webrtc交换sdp，根据offer sdp生成answer sdp
     *
     * @param user_data 回调用户指针
     * @param cb        回调函数
     * @param type      webrtc插件类型，支持echo,play,push
     * @param offer     webrtc offer sdp
     * @param url       rtc url, 例如 rtc://__defaultVhost/app/stream?key1=val1&key2=val2
     */
    void mk_webrtc_get_answer_sdp(Pointer user_data, IMKWebRtcGetAnwerSdpCallBack cb, String type, String offer, String url);

    void mk_webrtc_get_answer_sdp2(Pointer user_data, IMKFreeUserDataCallBack user_data_free, IMKWebRtcGetAnwerSdpCallBack cb, String type, String offer, String url);

    /**
     * 创建srt服务器
     *
     * @param port srt监听端口
     * @return 0:失败,非0:端口号
     */
    short mk_srt_server_start(short port);


    /**
     * 创建shell服务器
     *
     * @param port shell监听端口
     * @return 0:失败,非0:端口号
     */
    short mk_shell_server_start(short port);

    /**
     * 关闭所有服务器，请在main函数退出时调用
     */
    void mk_stop_all_server();


    /*******************************流代理相关**********************************/
    /**
     * 创建一个代理播放器
     *
     * @param vhost       虚拟主机名，一般为__defaultVhost__
     * @param app         应用名
     * @param stream      流名
     * @param hls_enabled 是否生成hls
     * @param mp4_enabled 是否生成mp4
     * @return 对象指针
     */
    MK_PROXY_PLAYER mk_proxy_player_create(String vhost, String app, String stream, int hls_enabled, int mp4_enabled);

    /**
     * 创建一个代理播放器
     *
     * @param vhost  虚拟主机名，一般为__defaultVhost__
     * @param app    应用名
     * @param stream 流名
     * @param option ProtocolOption相关配置
     * @return 对象指针
     */
    MK_PROXY_PLAYER mk_proxy_player_create2(String vhost, String app, String stream, MK_INI option);


    /**
     * 销毁代理播放器
     *
     * @param ctx 对象指针
     */
    void mk_proxy_player_release(MK_PROXY_PLAYER ctx);


    /**
     * 开始播放
     *
     * @param ctx 对象指针
     * @param url 播放url,支持rtsp/rtmp
     */
    void mk_proxy_player_play(MK_PROXY_PLAYER ctx, String url);


    /**
     * 设置代理播放器配置选项
     *
     * @param ctx 代理播放器指针
     * @param key 配置项键,支持 net_adapter/rtp_type/rtsp_user/rtsp_pwd/protocol_timeout_ms/media_timeout_ms/beat_interval_ms
     * @param val 配置项值,如果是整形，需要转换成统一转换成string
     */
    void mk_proxy_player_set_option(MK_PROXY_PLAYER ctx, String key, String val);


    /**
     * 监听MediaSource.close()事件
     * 在选择关闭一个关联的MediaSource时，将会最终触发到该回调
     * 你应该通过该事件调用mk_proxy_player_release函数并且释放其他资源
     *
     * @param ctx       对象指针
     * @param cb        回调指针
     * @param user_data 用户数据指针
     */
    void mk_proxy_player_set_on_close(MK_PROXY_PLAYER ctx, IMKProxyPlayCloseCallBack cb, Pointer user_data);

    void mk_proxy_player_set_on_close2(MK_PROXY_PLAYER ctx, IMKProxyPlayCloseCallBack cb, Pointer user_data, IMKFreeUserDataCallBack user_data_free);

    /**
     * 获取总的观看人数
     *
     * @param ctx 对象指针
     * @return 观看人数
     */
    int mk_proxy_player_total_reader_count(MK_PROXY_PLAYER ctx);


    /*******************************RTP相关**********************************/
    /**
     * 创建GB28181 RTP 服务器
     *
     * @param port      监听端口，0则为随机
     * @param tcp_mode  tcp模式(0: 不监听端口 1: 监听端口 2: 主动连接到服务端)
     * @param stream_id 该端口绑定的流id
     * @return
     */
    MK_RTP_SERVER mk_rtp_server_create(short port, int tcp_mode, String stream_id);


    /**
     * TCP 主动模式时连接到服务器
     *
     * @param @param    ctx 服务器对象
     * @param dst_url   服务端地址
     * @param dst_port  服务端端口
     * @param cb        连接到服务器是否成功的回调
     * @param user_data 用户数据指针
     * @return
     */
    void mk_rtp_server_connect(MK_RTP_SERVER ctx, String dst_url, short dst_port, IMKRtpServerConnectedCallBack cb, Pointer user_data);

    void mk_rtp_server_connect2(MK_RTP_SERVER ctx, String dst_url, short dst_port, IMKRtpServerConnectedCallBack cb, Pointer user_data, IMKFreeUserDataCallBack user_data_free);

    /**
     * 销毁GB28181 RTP 服务器
     *
     * @param ctx 服务器对象
     */
    void mk_rtp_server_release(MK_RTP_SERVER ctx);

    /**
     * 获取本地监听的端口号
     *
     * @param ctx 服务器对象
     * @return 端口号
     */
    short mk_rtp_server_port(MK_RTP_SERVER ctx);


    /**
     * 监听B28181 RTP 服务器接收流超时事件
     *
     * @param ctx       服务器对象
     * @param cb        回调函数
     * @param user_data 回调函数用户数据指针
     */

    void mk_rtp_server_set_on_detach(MK_RTP_SERVER ctx, IMKRtpServerDetachCallBack cb, Pointer user_data);

    void mk_rtp_server_set_on_detach2(MK_RTP_SERVER ctx, IMKRtpServerDetachCallBack cb, Pointer user_data, IMKFreeUserDataCallBack user_data_free);

    /*******************************播放相关**********************************/
    /**
     * 创建一个媒体源
     *
     * @param vhost       虚拟主机名，一般为__defaultVhost__
     * @param app         应用名，推荐为live
     * @param stream      流id，例如camera
     * @param duration    时长(单位秒)，直播则为0
     * @param hls_enabled 是否生成hls
     * @param mp4_enabled 是否生成mp4
     * @return 对象指针
     */
    MK_MEDIA mk_media_create(String vhost, String app, String stream, float duration, int hls_enabled, int mp4_enabled);

    /**
     * 创建一个媒体源
     *
     * @param vhost    虚拟主机名，一般为__defaultVhost__
     * @param app      应用名，推荐为live
     * @param stream   流id，例如camera
     * @param duration 时长(单位秒)，直播则为0
     * @param option   ProtocolOption相关配置
     * @return 对象指针
     */
    MK_MEDIA mk_media_create2(String vhost, String app, String stream, float duration, MK_INI option);

    /**
     * 销毁媒体源
     *
     * @param ctx 对象指针
     */
    void mk_media_release(MK_MEDIA ctx);

    /**
     * 添加音视频track
     *
     * @param ctx   mk_media对象
     * @param track mk_track对象，音视频轨道
     */
    void mk_media_init_track(MK_MEDIA ctx, MK_TRACK track);

    /**
     * 添加视频轨道，请改用mk_media_init_track方法
     *
     * @param ctx      对象指针
     * @param codec_id 0:CodecH264/1:CodecH265
     * @param width    视频宽度; 在编码时才有效
     * @param height   视频高度; 在编码时才有效
     * @param fps      视频fps; 在编码时才有效
     * @param bit_rate 视频比特率,单位bps; 在编码时才有效
     * @param width    视频宽度
     * @param height   视频高度
     * @param fps      视频fps
     * @return 1代表成功，0失败
     */
    int mk_media_init_video(MK_MEDIA ctx, int codec_id, int width, int height, float fps, int bit_rate);

    /**
     * 添加音频轨道，请改用mk_media_init_track方法
     *
     * @param ctx         对象指针
     * @param codec_id    2:CodecAAC/3:CodecG711A/4:CodecG711U/5:OPUS
     * @param channels    通道数
     * @param sample_bit  采样位数，只支持16
     * @param sample_rate 采样率
     * @return 1代表成功，0失败
     */
    int mk_media_init_audio(MK_MEDIA ctx, int codec_id, int sample_rate, int channels, int sample_bit);

    /**
     * 初始化h264/h265/aac完毕后调用此函数，
     * 在单track(只有音频或视频)时，因为ZLMediaKit不知道后续是否还要添加track，所以会多等待3秒钟
     * 如果产生的流是单Track类型，请调用此函数以便加快流生成速度，当然不调用该函数，影响也不大(会多等待3秒)
     *
     * @param ctx 对象指针
     */
    void mk_media_init_complete(MK_MEDIA ctx);

    /**
     * 输入frame对象
     *
     * @param ctx   mk_media对象
     * @param frame 帧对象
     * @return 1代表成功，0失败
     */
    int mk_media_input_frame(MK_MEDIA ctx, MK_FRAME frame);

    /**
     * 输入单帧H264视频，帧起始字节00 00 01,00 00 00 01均可，请改用mk_media_input_frame方法
     *
     * @param ctx  对象指针
     * @param data 单帧H264数据
     * @param len  单帧H264数据字节数
     * @param dts  解码时间戳，单位毫秒
     * @param pts  播放时间戳，单位毫秒
     * @return 1代表成功，0失败
     */
    int mk_media_input_h264(MK_MEDIA ctx, Pointer data, int len, long dts, long pts);

    /**
     * 输入单帧H265视频，帧起始字节00 00 01,00 00 00 01均可，请改用mk_media_input_frame方法
     *
     * @param ctx  对象指针
     * @param data 单帧H265数据
     * @param len  单帧H265数据字节数
     * @param dts  解码时间戳，单位毫秒
     * @param pts  播放时间戳，单位毫秒
     * @return 1代表成功，0失败
     */
    int mk_media_input_h265(MK_MEDIA ctx, Pointer data, int len, long dts, long pts);

    /**
     * 输入YUV视频数据
     *
     * @param ctx      对象指针
     * @param yuv      yuv420p数据
     * @param linesize yuv420p linesize
     * @param cts      视频采集时间戳，单位毫秒
     */
    void mk_media_input_yuv(MK_MEDIA ctx, Pointer yuv, Pointer linesize, long cts);

    /**
     * 输入单帧AAC音频(单独指定adts头)，请改用mk_media_input_frame方法
     *
     * @param ctx  对象指针
     * @param data 不包含adts头的单帧AAC数据，adts头7个字节
     * @param len  单帧AAC数据字节数
     * @param dts  时间戳，毫秒
     * @param adts adts头，可以为null
     * @return 1代表成功，0失败
     */
    int mk_media_input_aac(MK_MEDIA ctx, Pointer data, int len, long dts, Pointer adts);

    /**
     * 输入单帧PCM音频,启用ENABLE_FAAC编译时，该函数才有效
     *
     * @param ctx  对象指针
     * @param data 单帧PCM数据
     * @param len  单帧PCM数据字节数
     * @param pts  时间戳，毫秒
     * @return 1代表成功，0失败
     */
    int mk_media_input_pcm(MK_MEDIA ctx, Pointer data, int len, long pts);

    /**
     * 输入单帧OPUS/G711音频帧，请改用mk_media_input_frame方法
     *
     * @param ctx  对象指针
     * @param data 单帧音频数据
     * @param len  单帧音频数据字节数
     * @param dts  时间戳，毫秒
     * @return 1代表成功，0失败
     */
    int mk_media_input_audio(MK_MEDIA ctx, Pointer data, int len, long dts);


    /**
     * 监听MediaSource.close()事件
     * 在选择关闭一个关联的MediaSource时，将会最终触发到该回调
     * 你应该通过该事件调用mk_media_release函数并且释放其他资源
     *
     * @param ctx       对象指针
     * @param cb        回调指针
     * @param user_data 用户数据指针
     */
    void mk_media_set_on_close(MK_MEDIA ctx, IMKCloseEventCallBack cb, Pointer user_data);

    void mk_media_set_on_close2(MK_MEDIA ctx, IMKCloseEventCallBack cb, Pointer user_data, IMKFreeUserDataCallBack user_data_free);

    /**
     * 监听播放器seek请求事件
     *
     * @param ctx       对象指针
     * @param cb        回调指针
     * @param user_data 用户数据指针
     */
    void mk_media_set_on_seek(MK_MEDIA ctx, IMKSeekEventCallBack cb, Pointer user_data);

    void mk_media_set_on_seek2(MK_MEDIA ctx, IMKSeekEventCallBack cb, Pointer user_data, IMKFreeUserDataCallBack user_data_free);

    /**
     * 监听播放器pause请求事件
     *
     * @param ctx       对象指针
     * @param cb        回调指针
     * @param user_data 用户数据指针
     */
    void mk_media_set_on_pause(MK_MEDIA ctx, IMKPauseEventCallBack cb, Pointer user_data);

    void mk_media_set_on_pause2(MK_MEDIA ctx, IMKPauseEventCallBack cb, Pointer user_data, IMKFreeUserDataCallBack user_data_free);

    /**
     * 监听播放器pause请求事件
     *
     * @param ctx       对象指针
     * @param cb        回调指针
     * @param user_data 用户数据指针
     */
    void mk_media_set_on_speed(MK_MEDIA ctx, IMKSpeedEventCallBack cb, Pointer user_data);

    void mk_media_set_on_speed2(MK_MEDIA ctx, IMKSpeedEventCallBack cb, Pointer user_data, IMKFreeUserDataCallBack user_data_free);

    /**
     * 获取总的观看人数
     *
     * @param ctx 对象指针
     * @return 观看人数
     */
    int mk_media_total_reader_count(MK_MEDIA ctx);

    /**
     * 设置MediaSource注册或注销事件回调函数
     *
     * @param ctx       对象指针
     * @param cb        回调指针
     * @param user_data 用户数据指针
     */
    void mk_media_set_on_regist(MK_MEDIA ctx, IMKSourceRegisterEventCallBack cb, Pointer user_data);

    void mk_media_set_on_regist2(MK_MEDIA ctx, IMKSourceRegisterEventCallBack cb, Pointer user_data, IMKFreeUserDataCallBack user_data_free);

    /**
     * 开始发送一路ps-rtp流(通过ssrc区分多路)，此api线程安全
     *
     * @param ctx       对象指针
     * @param dst_url   目标ip或域名
     * @param dst_port  目标端口
     * @param ssrc      rtp的ssrc，10进制的字符串打印
     * @param is_udp    是否为udp
     * @param cb        启动成功或失败回调
     * @param user_data 回调用户指针
     */
    void mk_media_start_send_rtp(MK_MEDIA ctx, String dst_url, short dst_port, String ssrc, int is_udp, IMKSourceSendRtpResultCallBack cb, Pointer user_data);

    void mk_media_start_send_rtp2(MK_MEDIA ctx, String dst_url, short dst_port, String ssrc, int is_udp, IMKSourceSendRtpResultCallBack cb, Pointer user_data, IMKFreeUserDataCallBack user_data_free);

    /**
     * 停止某路或全部ps-rtp发送，此api线程安全
     *
     * @param ctx  对象指针
     * @param ssrc rtp的ssrc，10进制的字符串打印，如果为null或空字符串，则停止所有rtp推流
     */
    void mk_media_stop_send_rtp(MK_MEDIA ctx, String ssrc);

    /**
     * 获取所属线程
     *
     * @param ctx 对象指针
     */
    MK_THREAD mk_media_get_owner_thread(MK_MEDIA ctx);

    /*******************************轨道相关**********************************/
    /**
     * 创建track对象引用
     *
     * @param codec_id 请参考MKCodecXXX 常量定义
     * @param args     视频或音频参数
     * @return track对象引用
     */
    MK_TRACK mk_track_create(int codec_id, CodecArgs args);

    /**
     * 减引用track对象
     *
     * @param track track对象
     */
    void mk_track_unref(MK_TRACK track);

    /**
     * 引用track对象
     *
     * @param track track对象
     * @return 新的track引用对象
     */
    MK_TRACK mk_track_ref(MK_TRACK track);


    /*
     * 获取track 编码codec类型，请参考MKCodecXXX定义
     */
    int mk_track_codec_id(MK_TRACK track);

    /**
     * 获取编码codec名称
     */
    String mk_track_codec_name(MK_TRACK track);

    /**
     * 获取比特率信息
     */
    int mk_track_bit_rate(MK_TRACK track);

    /**
     * track是否为视频
     */
    int mk_track_is_video(MK_TRACK track);

    /**
     * 获取视频宽度
     */
    int mk_track_video_width(MK_TRACK track);

    /**
     * 获取视频高度
     */
    int mk_track_video_height(MK_TRACK track);

    /**
     * 获取视频帧率
     */
    int mk_track_video_fps(MK_TRACK track);

    /**
     * 获取音频采样率
     */
    int mk_track_audio_sample_rate(MK_TRACK track);

    /**
     * 获取音频通道数
     */
    int mk_track_audio_channel(MK_TRACK track);

    /**
     * 获取音频位数，一般为16bit
     */
    int mk_track_audio_sample_bit(MK_TRACK track);

    /**
     * 监听frame输出事件
     *
     * @param track     track对象
     * @param cb        frame输出回调
     * @param user_data frame输出回调用户指针参数
     */
    void mk_track_add_delegate(MK_TRACK track, IMKFrameOutCallBack cb, Pointer user_data);

    void mk_track_add_delegate2(MK_TRACK track, IMKFrameOutCallBack cb, Pointer user_data, IMKFreeUserDataCallBack user_data_free);

    /**
     * 取消frame输出事件监听
     *
     * @param track track对象
     * @param tag   mk_track_add_delegate返回值
     */
    void mk_track_del_delegate(MK_TRACK track, Pointer tag);

    /**
     * 输入frame到track，通常你不需要调用此api
     */
    void mk_track_input_frame(MK_TRACK track, MK_FRAME frame);

    /*******************************推流相关**********************************/


    /**
     * 绑定的MediaSource对象并创建rtmp[s]/rtsp[s]推流器
     * MediaSource通过mk_media_create或mk_proxy_player_create或推流生成
     * 该MediaSource对象必须已注册
     *
     * @param schema 绑定的MediaSource对象所属协议，支持rtsp/rtmp
     * @param vhost  绑定的MediaSource对象的虚拟主机，一般为__defaultVhost__
     * @param app    绑定的MediaSource对象的应用名，一般为live
     * @param stream 绑定的MediaSource对象的流id
     * @return 对象指针
     */
    MK_PUSHER mk_pusher_create(String schema, String vhost, String app, String stream);

    /**
     * 绑定的MediaSource对象并创建rtmp[s]/rtsp[s]推流器
     * MediaSource通过mk_media_create或mk_proxy_player_create或推流生成
     * 该MediaSource对象必须已注册
     *
     * @param src MediaSource对象
     * @return 对象指针
     */
    MK_PUSHER mk_pusher_create_src(MK_MEDIA_SOURCE src);

    /**
     * 释放推流器
     *
     * @param ctx 推流器指针
     */
    void mk_pusher_release(MK_PUSHER ctx);

    /**
     * 设置推流器配置选项
     *
     * @param ctx 推流器指针
     * @param key 配置项键,支持 net_adapter/rtp_type/rtsp_user/rtsp_pwd/protocol_timeout_ms/media_timeout_ms/beat_interval_ms
     * @param val 配置项值,如果是整形，需要转换成统一转换成string
     */
    void mk_pusher_set_option(MK_PUSHER ctx, String key, String val);

    /**
     * 开始推流
     *
     * @param ctx 推流器指针
     * @param url 推流地址，支持rtsp[s]/rtmp[s]
     */
    void mk_pusher_publish(MK_PUSHER ctx, String url);

    /**
     * 设置推流器推流结果回调函数
     *
     * @param ctx       推流器指针
     * @param cb        回调函数指针,不得为null
     * @param user_data 用户数据指针
     */
    void mk_pusher_set_on_result(MK_PUSHER ctx, IMKPushEventCallBack cb, Pointer user_data);

    void mk_pusher_set_on_result2(MK_PUSHER ctx, IMKPushEventCallBack cb, Pointer user_data, IMKFreeUserDataCallBack user_data_free);

    /**
     * 设置推流被异常中断的回调
     *
     * @param ctx       推流器指针
     * @param cb        回调函数指针,不得为null
     * @param user_data 用户数据指针
     */
    void mk_pusher_set_on_shutdown(MK_PUSHER ctx, IMKPushEventCallBack cb, Pointer user_data);

    void mk_pusher_set_on_shutdown2(MK_PUSHER ctx, IMKPushEventCallBack cb, Pointer user_data, IMKFreeUserDataCallBack user_data_free);

    /*******************************播放相关**********************************/


    /**
     * 创建一个播放器,支持rtmp[s]/rtsp[s]
     *
     * @return 播放器指针
     */
    MK_PLAYER mk_player_create();

    /**
     * 销毁播放器
     *
     * @param ctx 播放器指针
     */
    void mk_player_release(MK_PLAYER ctx);

    /**
     * 设置播放器配置选项
     *
     * @param ctx 播放器指针
     * @param key 配置项键,支持 net_adapter/rtp_type/rtsp_user/rtsp_pwd/protocol_timeout_ms/media_timeout_ms/beat_interval_ms/wait_track_ready
     * @param val 配置项值,如果是整形，需要转换成统一转换成string
     */
    void mk_player_set_option(MK_PLAYER ctx, String key, String val);

    /**
     * 开始播放url
     *
     * @param ctx 播放器指针
     * @param url rtsp[s]/rtmp[s] url
     */
    void mk_player_play(MK_PLAYER ctx, String url);

    /**
     * 暂停或恢复播放，仅对点播有用
     *
     * @param ctx   播放器指针
     * @param pause 1:暂停播放，0：恢复播放
     */
    void mk_player_pause(MK_PLAYER ctx, int pause);

    /**
     * 倍数播放，仅对点播有用
     *
     * @param ctx   播放器指针
     * @param speed 0.5 1.0 2.0
     */
    void mk_player_speed(MK_PLAYER ctx, float speed);

    /**
     * 设置点播进度条
     *
     * @param ctx      对象指针
     * @param progress 取值范围未 0.0～1.0
     */
    void mk_player_seekto(MK_PLAYER ctx, float progress);

    /**
     * 设置点播进度条
     *
     * @param ctx      对象指针
     * @param seek_pos 取值范围 相对于开始时间增量 单位秒
     */
    void mk_player_seekto_pos(MK_PLAYER ctx, int seek_pos);

    /**
     * 设置播放器开启播放结果回调函数
     *
     * @param ctx       播放器指针
     * @param cb        回调函数指针,设置null立即取消回调
     * @param user_data 用户数据指针
     */
    void mk_player_set_on_result(MK_PLAYER ctx, IMKPlayEventCallBack cb, Pointer user_data);

    void mk_player_set_on_result2(MK_PLAYER ctx, IMKPlayEventCallBack cb, Pointer user_data, IMKFreeUserDataCallBack user_data_free);

    /**
     * 设置播放被异常中断的回调
     *
     * @param ctx       播放器指针
     * @param cb        回调函数指针,设置null立即取消回调
     * @param user_data 用户数据指针
     */
    void mk_player_set_on_shutdown(MK_PLAYER ctx, IMKPlayEventCallBack cb, Pointer user_data);

    void mk_player_set_on_shutdown2(MK_PLAYER ctx, IMKPlayEventCallBack cb, Pointer user_data, IMKFreeUserDataCallBack user_data_free);

///////////////////////////获取音视频相关信息接口在播放成功回调触发后才有效///////////////////////////////

    /**
     * 获取点播节目时长，如果是直播返回0，否则返回秒数
     */
    float mk_player_duration(MK_PLAYER ctx);

    /**
     * 获取点播播放进度，取值范围 0.0～1.0
     */
    float mk_player_progress(MK_PLAYER ctx);

    /**
     * 获取点播播放进度位置，取值范围 相对于开始时间增量 单位秒
     */
    int mk_player_progress_pos(MK_PLAYER ctx);

    /**
     * 获取丢包率，rtsp时有效
     *
     * @param ctx        对象指针
     * @param track_type 0：视频，1：音频
     */
    float mk_player_loss_rate(MK_PLAYER ctx, int track_type);


    /*******************************录制相关**********************************/
    /**
     * 创建flv录制器
     *
     * @return
     */
    MK_FLV_RECORDER mk_flv_recorder_create();

    /**
     * 释放flv录制器
     *
     * @param ctx
     */
    void mk_flv_recorder_release(MK_FLV_RECORDER ctx);

    /**
     * 开始录制flv
     *
     * @param ctx       flv录制器
     * @param vhost     虚拟主机
     * @param app       绑定的RtmpMediaSource的 app名
     * @param stream    绑定的RtmpMediaSource的 stream名
     * @param file_path 文件存放地址
     * @return 0:开始超过，-1:失败,打开文件失败或该RtmpMediaSource不存在
     */
    int mk_flv_recorder_start(MK_FLV_RECORDER ctx, String vhost, String app, String stream, String file_path);

///////////////////////////////////////////hls/mp4录制/////////////////////////////////////////////

    /**
     * 获取录制状态
     *
     * @param type   0:hls,1:MP4
     * @param vhost  虚拟主机
     * @param app    应用名
     * @param stream 流id
     * @return 录制状态, 0:未录制, 1:正在录制
     */
    int mk_recorder_is_recording(int type, String vhost, String app, String stream);

    /**
     * 开始录制
     *
     * @param type            0:hls-ts,1:MP4,2:hls-fmp4,3:http-fmp4,4:http-ts
     * @param vhost           虚拟主机
     * @param app             应用名
     * @param stream          流id
     * @param customized_path 录像文件保存自定义目录，默认为空或null则自动生成
     * @param max_second      mp4录制最大切片时间，单位秒，置0则采用配置文件配置
     * @return 1代表成功，0代表失败
     */
    int mk_recorder_start(int type, String vhost, String app, String stream, String customized_path, long max_second);

    /**
     * 停止录制
     *
     * @param type   0:hls-ts,1:MP4,2:hls-fmp4,3:http-fmp4,4:http-ts
     * @param vhost  虚拟主机
     * @param app    应用名
     * @param stream 流id
     * @return 1:成功，0：失败
     */
    int mk_recorder_stop(int type, String vhost, String app, String stream);


    /*******************************事件相关**********************************/

    void mk_events_listen(MK_EVENTS events);

    /*******************************结构体相关**********************************/
    ///////////////////////////////////////////MP4Info/////////////////////////////////////////////
//MP4Info对象的C映射
    // GMT 标准时间，单位秒
    long mk_mp4_info_get_start_time(MK_MP4_INFO ctx);

    // 录像长度，单位秒
    float mk_mp4_info_get_time_len(MK_MP4_INFO ctx);

    // 文件大小，单位 BYTE
    long mk_mp4_info_get_file_size(MK_MP4_INFO ctx);

    // 文件路径
    String mk_mp4_info_get_file_path(MK_MP4_INFO ctx);

    // 文件名称
    String mk_mp4_info_get_file_name(MK_MP4_INFO ctx);

    // 文件夹路径
    String mk_mp4_info_get_folder(MK_MP4_INFO ctx);

    // 播放路径
    String mk_mp4_info_get_url(MK_MP4_INFO ctx);

    // 应用名称
    String mk_mp4_info_get_vhost(MK_MP4_INFO ctx);

    // 流 ID
    String mk_mp4_info_get_app(MK_MP4_INFO ctx);

    // 虚拟主机
    String mk_mp4_info_get_stream(MK_MP4_INFO ctx);

    ///////////////////////////////////////////Parser/////////////////////////////////////////////
//Parser对象的C映射

    //Parser::Method(),获取命令字，譬如GET/POST
    String mk_parser_get_method(MK_PARSER ctx);

    //Parser::Url(),获取HTTP的访问url(不包括?后面的参数)
    String mk_parser_get_url(MK_PARSER ctx);

    //Parser::Params(),?后面的参数字符串
    String mk_parser_get_url_params(MK_PARSER ctx);

    //Parser::getUrlArgs()["key"],获取?后面的参数中的特定参数
    String mk_parser_get_url_param(MK_PARSER ctx, String key);

    //Parser::Tail()，获取协议相关信息，譬如 HTTP/1.1
    String mk_parser_get_tail(MK_PARSER ctx);

    //Parser::getValues()["key"],获取HTTP头中特定字段
    String mk_parser_get_header(MK_PARSER ctx, String key);

    //Parser::Content(),获取HTTP body
    String mk_parser_get_content(MK_PARSER ctx, long length);

    ///////////////////////////////////////////MediaInfo/////////////////////////////////////////////
//MediaInfo对象的C映射
//MediaInfo::param_strs
    String mk_media_info_get_params(MK_MEDIA_INFO ctx);

    //MediaInfo::schema
    String mk_media_info_get_schema(MK_MEDIA_INFO ctx);

    //MediaInfo::vhost
    String mk_media_info_get_vhost(MK_MEDIA_INFO ctx);

    //MediaInfo::app
    String mk_media_info_get_app(MK_MEDIA_INFO ctx);

    //MediaInfo::stream
    String mk_media_info_get_stream(MK_MEDIA_INFO ctx);

    //MediaInfo::host
    String mk_media_info_get_host(MK_MEDIA_INFO ctx);

    //MediaInfo::port
    short mk_media_info_get_port(MK_MEDIA_INFO ctx);


    ///////////////////////////////////////////MediaSource/////////////////////////////////////////////


    //MediaSource::getSchema()
    String mk_media_source_get_schema(MK_MEDIA_SOURCE ctx);

    //MediaSource::getVhost()
    String mk_media_source_get_vhost(MK_MEDIA_SOURCE ctx);

    //MediaSource::getApp()
    String mk_media_source_get_app(MK_MEDIA_SOURCE ctx);

    //MediaSource::getId()
    String mk_media_source_get_stream(MK_MEDIA_SOURCE ctx);

    //MediaSource::readerCount()
    int mk_media_source_get_reader_count(MK_MEDIA_SOURCE ctx);

    //MediaSource::totalReaderCount()
    int mk_media_source_get_total_reader_count(MK_MEDIA_SOURCE ctx);

    // get track count from MediaSource
    int mk_media_source_get_track_count(MK_MEDIA_SOURCE ctx);

    // copy track reference by index from MediaSource, please use mk_track_unref to release it
    MK_TRACK mk_media_source_get_track(MK_MEDIA_SOURCE ctx, int index);

    // MediaSource::broadcastMessage
    int mk_media_source_broadcast_msg(MK_MEDIA_SOURCE ctx, String msg, long len);

    // MediaSource::getOriginUrl()
    String mk_media_source_get_origin_url(MK_MEDIA_SOURCE ctx);

    // MediaSource::getOriginType()
    int mk_media_source_get_origin_type(MK_MEDIA_SOURCE ctx);

    // MediaSource::getCreateStamp()
    long mk_media_source_get_create_stamp(MK_MEDIA_SOURCE ctx);

    // MediaSource::isRecording()
    int mk_media_source_is_recording(MK_MEDIA_SOURCE ctx, int type);

    /**
     * 直播源在ZLMediaKit中被称作为MediaSource，
     * 目前支持3种，分别是RtmpMediaSource、RtspMediaSource、HlsMediaSource
     * 源的产生有被动和主动方式:
     * 被动方式分别是rtsp/rtmp/rtp推流、mp4点播
     * 主动方式包括mk_media_create创建的对象(DevChannel)、mk_proxy_player_create创建的对象(PlayerProxy)
     * 被动方式你不用做任何处理，ZLMediaKit已经默认适配了MediaSource::close()事件，都会关闭直播流
     * 主动方式你要设置这个事件的回调，你要自己选择删除对象
     * 通过mk_proxy_player_set_on_close、mk_media_set_on_close函数可以设置回调,
     * 请在回调中删除对象来完成媒体的关闭，否则又为什么要调用mk_media_source_close函数？
     *
     * @param ctx   对象
     * @param force 是否强制关闭，如果强制关闭，在有人观看的情况下也会关闭
     * @return 0代表失败，1代表成功
     */
    int mk_media_source_close(MK_MEDIA_SOURCE ctx, int force);

    //MediaSource::seekTo()
    int mk_media_source_seek_to(MK_MEDIA_SOURCE ctx, int stamp);

    /**
     * rtp推流成功与否的回调(第一次成功后，后面将一直重试)
     */

    //MediaSource::startSendRtp,请参考mk_media_start_send_rtp,注意ctx参数类型不一样
    void mk_media_source_start_send_rtp(MK_MEDIA_SOURCE ctx, String dst_url, short dst_port, String ssrc, int is_udp, IMKSourceSendRtpResultCallBack cb, Pointer user_data);

    void mk_media_source_start_send_rtp2(MK_MEDIA_SOURCE ctx, String dst_url, short dst_port, String ssrc, int is_udp, IMKSourceSendRtpResultCallBack cb, Pointer user_data, IMKFreeUserDataCallBack user_data_free);

    //MediaSource::stopSendRtp，请参考mk_media_stop_send_rtp,注意ctx参数类型不一样
    int mk_media_source_stop_send_rtp(MK_MEDIA_SOURCE ctx);

    //MediaSource::find()
    void mk_media_source_find(String schema, String vhost, String app, String stream, int from_mp4, Pointer user_data, IMKSourceFindCallBack cb);


    MK_MEDIA_SOURCE mk_media_source_find2(String schema, String vhost, String app, String stream, int from_mp4);

    //MediaSource::for_each_media()
    void mk_media_source_for_each(Pointer user_data, IMKSourceFindCallBack cb, String schema, String vhost, String app, String stream);

    ///////////////////////////////////////////HttpBody/////////////////////////////////////////////
//HttpBody对象的C映射

    /**
     * 生成HttpStringBody
     *
     * @param str 字符串指针
     * @param len 字符串长度，为0则用strlen获取
     */
    MK_HTTP_BODY mk_http_body_from_string(String str, long len);

    /**
     * 生成HttpBufferBody
     *
     * @param buffer mk_buffer对象
     */
    MK_HTTP_BODY mk_http_body_from_buffer(MK_BUFFER buffer);


    /**
     * 生成HttpFileBody
     *
     * @param file_path 文件完整路径
     */
    MK_HTTP_BODY mk_http_body_from_file(String file_path);

    /**
     * 生成HttpMultiFormBody
     *
     * @param key_val   参数key-value
     * @param file_path 文件完整路径
     */
    MK_HTTP_BODY mk_http_body_from_multi_form(String key_val[], String file_path);

    /**
     * 销毁HttpBody
     */
    void mk_http_body_release(MK_HTTP_BODY ctx);

    ///////////////////////////////////////////HttpResponseInvoker/////////////////////////////////////////////
//HttpSession::HttpResponseInvoker对象的C映射

    /**
     * HttpSession::HttpResponseInvoker(const string &codeOut, const StrCaseMap &headerOut, const HttpBody::Ptr &body);
     *
     * @param response_code   譬如200
     * @param response_header 返回的http头，譬如 {"Content-Type","text/html",NULL} 必须以NULL结尾
     * @param response_body   body对象
     */
    void mk_http_response_invoker_do(MK_HTTP_RESPONSE_INVOKER ctx, int response_code, PointerByReference response_header, MK_HTTP_BODY response_body);

    /**
     * HttpSession::HttpResponseInvoker(const string &codeOut, const StrCaseMap &headerOut, const string &body);
     *
     * @param response_code    譬如200
     * @param response_header  返回的http头，譬如 {"Content-Type","text/html",NULL} 必须以NULL结尾
     * @param response_content 返回的content部分，譬如一个网页内容
     */
    void mk_http_response_invoker_do_string(MK_HTTP_RESPONSE_INVOKER ctx, int response_code, PointerByReference response_header, String response_content);

    /**
     * HttpSession::HttpResponseInvoker(const StrCaseMap &requestHeader,const StrCaseMap &responseHeader,const string &filePath);
     *
     * @param request_parser     请求事件中的mk_parser对象，用于提取其中http头中的Range字段，通过该字段先fseek然后再发送文件部分片段
     * @param response_header    返回的http头，譬如 {"Content-Type","text/html",NULL} 必须以NULL结尾
     * @param response_file_path 返回的content部分，譬如/path/to/html/file
     */
    void mk_http_response_invoker_do_file(MK_HTTP_RESPONSE_INVOKER ctx, MK_PARSER request_parser, String response_header[], String response_file_path);

    /**
     * 克隆mk_http_response_invoker对象，通过克隆对象为堆对象，可以实现跨线程异步执行mk_http_response_invoker_do
     * 如果是同步执行mk_http_response_invoker_do，那么没必要克隆对象
     */
    MK_HTTP_RESPONSE_INVOKER mk_http_response_invoker_clone(MK_HTTP_RESPONSE_INVOKER ctx);

    /**
     * 销毁堆上的克隆对象
     */
    void mk_http_response_invoker_clone_release(MK_HTTP_RESPONSE_INVOKER ctx);

    ///////////////////////////////////////////HttpAccessPathInvoker/////////////////////////////////////////////
//HttpSession::HttpAccessPathInvoker对象的C映射

    /**
     * HttpSession::HttpAccessPathInvoker(const string &errMsg,const string &accessPath, int cookieLifeSecond);
     *
     * @param err_msg            如果为空，则代表鉴权通过，否则为错误提示,可以为null
     * @param access_path        运行或禁止访问的根目录,可以为null
     * @param cookie_life_second 鉴权cookie有效期
     **/
    void mk_http_access_path_invoker_do(MK_HTTP_ACCESS_PATH_INVOKER ctx, String err_msg, String access_path, int cookie_life_second);

    /**
     * 克隆mk_http_access_path_invoker对象，通过克隆对象为堆对象，可以实现跨线程异步执行mk_http_access_path_invoker_do
     * 如果是同步执行mk_http_access_path_invoker_do，那么没必要克隆对象
     */
    MK_HTTP_ACCESS_PATH_INVOKER mk_http_access_path_invoker_clone(MK_HTTP_ACCESS_PATH_INVOKER ctx);

    /**
     * 销毁堆上的克隆对象
     */
    void mk_http_access_path_invoker_clone_release(MK_HTTP_ACCESS_PATH_INVOKER ctx);

    ///////////////////////////////////////////RtspSession::onGetRealm/////////////////////////////////////////////
//RtspSession::onGetRealm对象的C映射

    /**
     * 执行RtspSession::onGetRealm
     *
     * @param realm 该rtsp流是否需要开启rtsp专属鉴权，至null或空字符串则不鉴权
     */
    void mk_rtsp_get_realm_invoker_do(MK_RTSP_GET_REALM_INVOKER ctx, String realm);

    /**
     * 克隆mk_rtsp_get_realm_invoker对象，通过克隆对象为堆对象，可以实现跨线程异步执行mk_rtsp_get_realm_invoker_do
     * 如果是同步执行mk_rtsp_get_realm_invoker_do，那么没必要克隆对象
     */
    MK_RTSP_GET_REALM_INVOKER mk_rtsp_get_realm_invoker_clone(MK_RTSP_GET_REALM_INVOKER ctx);

    /**
     * 销毁堆上的克隆对象
     */
    void mk_rtsp_get_realm_invoker_clone_release(MK_RTSP_GET_REALM_INVOKER ctx);

    ///////////////////////////////////////////RtspSession::onAuth/////////////////////////////////////////////

    /**
     * 执行RtspSession::onAuth
     *
     * @param encrypted  为true是则表明是md5加密的密码，否则是明文密码, 在请求明文密码时如果提供md5密码者则会导致认证失败
     * @param pwd_or_md5 明文密码或者md5加密的密码
     */
    void mk_rtsp_auth_invoker_do(MK_RTSP_AUTH_INVOKER ctx, int encrypted, String pwd_or_md5);

    /**
     * 克隆mk_rtsp_auth_invoker对象，通过克隆对象为堆对象，可以实现跨线程异步执行mk_rtsp_auth_invoker_do
     * 如果是同步执行mk_rtsp_auth_invoker_do，那么没必要克隆对象
     */
    MK_RTSP_AUTH_INVOKER mk_rtsp_auth_invoker_clone(MK_RTSP_AUTH_INVOKER ctx);

    /**
     * 销毁堆上的克隆对象
     */
    void mk_rtsp_auth_invoker_clone_release(MK_RTSP_AUTH_INVOKER ctx);

    ///////////////////////////////////////////Broadcast::PublishAuthInvoker/////////////////////////////////////////////
//Broadcast::PublishAuthInvoker对象的C映射

    /**
     * 执行Broadcast::PublishAuthInvoker
     *
     * @param err_msg    为空或null则代表鉴权成功
     * @param enable_hls 是否允许转换hls
     * @param enable_mp4 是否运行MP4录制
     */
    void mk_publish_auth_invoker_do(MK_PUBLISH_AUTH_INVOKER ctx, String err_msg, int enable_hls, int enable_mp4);

    /**
     * 克隆mk_publish_auth_invoker对象，通过克隆对象为堆对象，可以实现跨线程异步执行mk_publish_auth_invoker_do
     * 如果是同步执行mk_publish_auth_invoker_do，那么没必要克隆对象
     */
    void mk_publish_auth_invoker_do2(MK_PUBLISH_AUTH_INVOKER ctx, String err_msg, MK_INI option);

    /**
     * 销毁堆上的克隆对象
     */
    void mk_publish_auth_invoker_clone_release(MK_PUBLISH_AUTH_INVOKER ctx);

    ///////////////////////////////////////////Broadcast::AuthInvoker/////////////////////////////////////////////
//Broadcast::AuthInvoker对象的C映射

    /**
     * 执行Broadcast::AuthInvoker
     *
     * @param err_msg 为空或null则代表鉴权成功
     */
    void mk_auth_invoker_do(MK_AUTH_INVOKER ctx, String err_msg);

    /**
     * 克隆mk_auth_invoker对象，通过克隆对象为堆对象，可以实现跨线程异步执行mk_auth_invoker_do
     * 如果是同步执行mk_auth_invoker_do，那么没必要克隆对象
     */
    MK_AUTH_INVOKER mk_auth_invoker_clone(MK_AUTH_INVOKER ctx);

    /**
     * 销毁堆上的克隆对象
     */
    void mk_auth_invoker_clone_release(MK_AUTH_INVOKER ctx);


    /*******************************帧流相关**********************************/

    /**
     * 创建frame对象，并返回其引用
     *
     * @param codec_id  编解码类型，请参考MKCodecXXX定义
     * @param dts       解码时间戳，单位毫秒
     * @param pts       显示时间戳，单位毫秒
     * @param data      单帧数据
     * @param size      单帧数据长度
     * @param cb        data指针free释放回调, 如果为空，内部会拷贝数据
     * @param user_data data指针free释放回调用户指针
     * @return frame对象引用
     */
    MK_FRAME mk_frame_create(int codec_id, long dts, long pts, Pointer data, long size,
                             IMKFrameDataRelease cb, Pointer user_data);

    MK_FRAME mk_frame_create2(int codec_id, long dts, long pts, Pointer data, long size,
                              IMKFrameDataRelease cb, Pointer user_data, IMKFreeUserDataCallBack user_data_free);

    /**
     * 减引用frame对象
     *
     * @param frame 帧对象引用
     */
    void mk_frame_unref(MK_FRAME frame);

    /**
     * 引用frame对象
     *
     * @param frame 被引用的frame对象
     * @return 新的对象引用
     */
    MK_FRAME mk_frame_ref(MK_FRAME frame);

    /**
     * 获取frame 编码codec类型，请参考MKCodecXXX定义
     */
    int mk_frame_codec_id(MK_FRAME frame);

    /**
     * 获取帧编码codec名称
     */
    String mk_frame_codec_name(MK_FRAME frame);

    /**
     * 帧是否为视频
     */
    int mk_frame_is_video(MK_FRAME frame);

    /**
     * 获取帧数据指针
     */
    Pointer mk_frame_get_data(MK_FRAME frame);

    /**
     * 获取帧数据指针长度
     */
    long mk_frame_get_data_size(MK_FRAME frame);

    /**
     * 返回帧数据前缀长度，譬如H264/H265前缀一般是0x00 00 00 01,那么本函数返回4
     */
    long mk_frame_get_data_prefix_size(MK_FRAME frame);

    /**
     * 获取解码时间戳，单位毫秒
     */
    long mk_frame_get_dts(MK_FRAME frame);

    /**
     * 获取显示时间戳，单位毫秒
     */
    long mk_frame_get_pts(MK_FRAME frame);

    /**
     * 获取帧flag，请参考 MK_FRAME_FLAG
     */
    int mk_frame_get_flags(MK_FRAME frame);


    /**
     * mpeg-ps/ts 打包器
     *
     * @param cb        打包回调函数
     * @param user_data 回调用户数据指针
     * @param is_ps     是否是ps
     * @return 打包器对象
     */
    MK_MPEG_MUXER mk_mpeg_muxer_create(IMKMpegMuxerFrameCallBack cb, Pointer user_data, int is_ps);

    /**
     * 删除mpeg-ps/ts 打包器
     *
     * @param ctx 打包器
     */
    void mk_mpeg_muxer_release(MK_MPEG_MUXER ctx);

    /**
     * 添加音视频track
     *
     * @param ctx   mk_mpeg_muxer对象
     * @param track mk_track对象，音视频轨道
     */
    void mk_mpeg_muxer_init_track(MK_MPEG_MUXER ctx, MK_TRACK track);

    /**
     * 初始化track完毕后调用此函数，
     * 在单track(只有音频或视频)时，因为ZLMediaKit不知道后续是否还要添加track，所以会多等待3秒钟
     * 如果产生的流是单Track类型，请调用此函数以便加快流生成速度，当然不调用该函数，影响也不大(会多等待3秒)
     *
     * @param ctx 对象指针
     */
    void mk_mpeg_muxer_init_complete(MK_MPEG_MUXER ctx);

    /**
     * 输入frame对象
     *
     * @param ctx   mk_mpeg_muxer对象
     * @param frame 帧对象
     * @return 1代表成功，0失败
     */
    int mk_mpeg_muxer_input_frame(MK_MPEG_MUXER ctx, MK_FRAME frame);


    /**
     * 发送rtc数据通道
     *
     * @param ctx      数据通道对象
     * @param streamId 流id
     * @param ppid     协议id
     * @param msg      数据
     * @param len      数据长度
     */
    void mk_rtc_send_datachannel(MK_RTC_TRANSPORT ctx, float streamId, int ppid, byte msg, long len);
}
