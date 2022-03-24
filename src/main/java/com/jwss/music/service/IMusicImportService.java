package com.jwss.music.service;

import com.jwss.music.entity.Music;
import com.jwss.music.enums.DeleteMusicType;

import java.util.List;

/**
 * 音乐导入服务接口
 *
 * @author jwss
 * @date 2022-1-27 19:15:45
 */
public interface IMusicImportService {
    /**
     * 导入音乐（选择多个文件）
     *
     * @return 音乐列表
     */
    List<Music> importMusic();

    /**
     * 导入音乐（遍历文件夹）
     *
     * @return 音乐列表
     */
    List<Music> importMusicByFolder();

    /**
     * 导入音乐（解析JSON）
     */
    void importMusicByShare();

    /**
     * 批量移除音乐
     * @param musicList 对象列表
     * @param type 删除类型
     */
    void batchRemove(List<Music> musicList, DeleteMusicType type);
}
