package com.jwss.music.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.csv.*;
import com.jwss.music.entity.AppContext;
import com.jwss.music.entity.Music;
import com.jwss.music.service.ICacheService;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jwss
 */
public class CacheServiceImpl implements ICacheService {
    @Override
    public void saveMusicList(List<Music> musicList) {
        CsvWriter writer = CsvUtil.getWriter(AppContext.CACHE_FILE, StandardCharsets.UTF_8);
        musicList.forEach(item -> writer.writeLine(
                item.getName(), item.getAuthor(), item.getAlbum(), String.valueOf(item.getDuration()), item.getSize(),
                item.getUrl())
        );
        writer.close();
    }

    @Override
    public List<Music> getMusicList() {
        CsvReader reader = CsvUtil.getReader();
        List<CsvRow> rows = reader.read(FileUtil.file(AppContext.CACHE_FILE)).getRows();
        List<Music> musicList = new ArrayList<>(rows.size());
        rows.forEach(item -> {
            Music music = new Music();
            music.setName(item.get(0));
            music.setAuthor(item.get(1));
            music.setAlbum(item.get(2));
            music.setDuration(item.get(3));
            music.setSize(item.get(4));
            music.setUrl(item.get(5));
            musicList.add(music);
        });
        return musicList;
    }
}
