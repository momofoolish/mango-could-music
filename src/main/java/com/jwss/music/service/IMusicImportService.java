package com.jwss.music.service;

/**
 * 音乐导入服务接口
 * @date 2022-1-27 19:15:45
 * @author jwss
 */
public interface IMusicImportService {
    /**
     * 导入音乐
     * @param importType 导入类型
     */
    void importMusic(Integer importType);
}
