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
}
