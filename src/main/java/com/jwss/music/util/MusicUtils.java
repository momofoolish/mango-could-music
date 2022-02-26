package com.jwss.music.util;

import com.jwss.music.entity.Music;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 音乐读取工具
 *
 * @author jwss
 * @date 2022-1-24 21:09:23
 */
public class MusicUtils {

    /**
     * 读取音频文件信息
     *
     * @param urls 文件路径集合
     * @return 音频列表
     */
    public static List<Music> readMusicsInfo(List<String> urls) throws CannotReadException, TagException, InvalidAudioFrameException, ReadOnlyFileException, IOException {
        List<Music> musicList = new ArrayList<>(urls.size());
        for (String url : urls) {
            File file = new File(url);
            AudioFile audioFile = AudioFileIO.read(file);
            Tag tag = audioFile.getTag();
            Music music = new Music();
            // 作者
            music.setAuthor(tag.getFirst(FieldKey.ARTIST));
            // 专辑
            music.setAlbum(tag.getFirst(FieldKey.ALBUM));
            // 标题
            music.setName(tag.getFirst(FieldKey.TITLE));
            // 时长
            MP3AudioHeader mp3AudioHeader = (MP3AudioHeader) audioFile.getAudioHeader();
            music.setDuration(String.valueOf(mp3AudioHeader.getTrackLength()));
            // 文件大小
            music.setSize(file.length() / 1024 / 1024 + " MB");
            // 文件路径
            music.setUrl(url);
            musicList.add(music);
        }
        return musicList;
    }
}
