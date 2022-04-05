package com.jwss.music.service;

import com.jwss.music.entity.Music;

import java.util.List;

/**
 * 缓存服务
 *
 * @author jwss
 * @date 2022-2-18 22:06:12
 */
public interface ICacheService {
    /**
     * 缓存已导入的音乐列表
     *
     * @param musicList 音乐列表
     */
    void saveMusicList(List<Music> musicList);

    /**
     * 获取已缓存导入的音乐列表
     *
     * @return 音乐列表
     */
    List<Music> getMusicList();

    /**
     * 批量移除
     * @param idList 列表id
     * @return
     */
    boolean removeBatch(List<String> idList);
}
