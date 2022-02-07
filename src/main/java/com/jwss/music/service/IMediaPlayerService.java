package com.jwss.music.service;

/**
 * 播放器服务接口
 * @date 2022-1-27 19:16:14
 * @author jwss
 */
public interface IMediaPlayerService {
    /**
     * 播放
     */
    void play();

    /**
     * 暂停
     */
    void pause();

    /**
     * 下一曲
     */
    void next();

    /**
     * 上一曲
     */
    void preview();

    /**
     * 随机播放
     */
    void random();

    /**
     * 顺序播放
     */
    void order();

}