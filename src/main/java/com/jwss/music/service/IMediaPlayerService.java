package com.jwss.music.service;

import com.jwss.music.entity.Music;
import javafx.collections.ListChangeListener;

/**
 * 播放器服务接口
 *
 * @author jwss
 * @date 2022-1-27 19:16:14
 */
public interface IMediaPlayerService {
    /**
     * 双击表格某项播放
     *
     * @return 监听器
     */
    ListChangeListener<Music> clickToPlay();

    /**
     * 播放
     *
     * @param url 音乐地址
     */
    void play(String url);

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
