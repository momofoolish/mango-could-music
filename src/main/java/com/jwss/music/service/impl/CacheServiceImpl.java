package com.jwss.music.service.impl;

import cn.hutool.log.Log;
import com.jwss.music.entity.Music;
import com.jwss.music.service.ICacheService;
import com.jwss.music.util.SqliteUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * @author jwss
 */
public class CacheServiceImpl implements ICacheService {
    private final Log logger = Log.get();

    @Override
    public void saveMusicList(List<Music> musicList) {
        Statement statement = SqliteUtils.getStatement();
        musicList.forEach(item -> {
            try {
                if (statement != null) {
                    String sql = String.format(
                            "insert into ml_main(ID,NAME,AUTHOR,ALBUM,DURATION,SIZE,URL)values('%s','%s','%s','%s','%s','%s','%s')"
                            , UUID.randomUUID()
                            , item.getName(), item.getAuthor(), item.getAlbum(), item.getDuration()
                            , item.getSize(), item.getUrl()
                    );
                    logger.info(sql);
                    statement.executeUpdate(sql);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        SqliteUtils.close();
    }

    @Override
    public List<Music> getMusicList() {
        List<Music> musicList = new ArrayList<>();
        Statement statement = SqliteUtils.getStatement();
        try {
            if (statement != null) {
                ResultSet rs = statement.executeQuery("select * from ml_main");
                while (rs.next()) {
                    Music music = new Music();
                    music.setId(rs.getString("ID"));
                    music.setName(rs.getString("NAME"));
                    music.setAuthor(rs.getString("AUTHOR"));
                    music.setAlbum(rs.getString("ALBUM"));
                    music.setDuration(rs.getString("DURATION"));
                    music.setSize(rs.getString("SIZE"));
                    music.setUrl(rs.getString("URL"));
                    musicList.add(music);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicList;
    }

    @Override
    public boolean removeBatch(List<String> idList) {
        Statement statement = SqliteUtils.getStatement();
        if (statement == null || idList.size() <= 0) {
            return false;
        }
        idList.forEach(id->{
            try {
                statement.execute(String.format("delete from ml_main where ID = '%s'", id));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return false;
    }

}
