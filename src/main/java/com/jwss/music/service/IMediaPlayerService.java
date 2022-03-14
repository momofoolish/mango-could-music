package com.jwss.music.service;

import com.jwss.music.entity.Music;
import javafx.collections.ListChangeListener;
import javafx.scene.control.TableView;

/**
 * 播放器服务接口
 *
 * @author jwss
 * @date 2022-1-27 19:16:14
 */
public interface IMediaPlayerService {
    /**
     * 播放
     *
     * @param music 音乐对象
     */
    void play(Music music);

    /**
     * 继续播放
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

    /**
     * 设置表格事件
     * @param musicTableView 表格
     */
    void setEvent(TableView<Music> musicTableView);
}
