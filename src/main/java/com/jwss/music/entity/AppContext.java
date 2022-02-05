package com.jwss.music.entity;

import javafx.scene.media.MediaPlayer;

import java.util.List;

/**
 * @author jwss
 */
public class AppContext {
    /**
     * 媒体播放器
     */
    private static MediaPlayer mediaPlayer;

    /**
     * 播放列表
     */
    private static List<Music> playList;

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public static void setMediaPlayer(MediaPlayer mediaPlayer) {
        AppContext.mediaPlayer = mediaPlayer;
    }

    public static List<Music> getPlayList() {
        return playList;
    }

    public static void setPlayList(List<Music> playList) {
        AppContext.playList = playList;
    }
}
