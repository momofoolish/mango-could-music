package com.jwss.music.entity;

import javafx.fxml.FXMLLoader;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.util.List;

/**
 * @date 2022-2-6 22:13:49
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

    /**
     * 场景
     */
    private static Stage stage;

    /**
     * FXML资源加载器
     */
    private static FXMLLoader fxmlLoader;

    public static FXMLLoader getFxmlLoader() {
        return fxmlLoader;
    }

    public static void setFxmlLoader(FXMLLoader fxmlLoader) {
        AppContext.fxmlLoader = fxmlLoader;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        AppContext.stage = stage;
    }

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
