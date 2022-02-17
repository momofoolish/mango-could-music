package com.jwss.music.service;

import com.jwss.music.entity.Music;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;

import java.io.IOException;
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
     */
    void importMusicByFolder();

    /**
     * 导入音乐（解析JSON）
     */
    void importMusicByShare();
}
