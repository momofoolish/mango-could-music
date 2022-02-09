package com.jwss.music.service;

/**
 * 音乐导入服务接口
 * @date 2022-1-27 19:15:45
 * @author jwss
 */
public interface IMusicImportService {
    /**
     * 导入音乐（选择多个文件）
     */
    void importMusic();

    /**
     * 导入音乐（遍历文件夹）
     */
    void importMusicByFolder();

    /**
     * 导入音乐（解析JSON）
     */
    void importMusicByShare();
}
