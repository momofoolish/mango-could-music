package com.jwss.music.entity;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.util.List;

/**
 * @date 2022-2-6 22:13:49
 * @author jwss
 */
public class AppContext {
    /**
     * 播放列表
     */
    private static List<Music> playList;

    /**
     * 播放状态：TRUE表示正在播放
     */
    private static Boolean isPlay;

    /**
     * 场景
     */
    private static Stage stage;

    /**
     * FXML资源加载器
     */
    private static FXMLLoader fxmlLoader;

    public final static String CACHE_FILE = "m_cache.csv";

    public static FXMLLoader getFxmlLoader() {
        return fxmlLoader;
    }

    public static Boolean getIsPlay() {
        return isPlay;
    }

    public static void setIsPlay(Boolean isPlay) {
        AppContext.isPlay = isPlay;
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

    public static List<Music> getPlayList() {
        return playList;
    }

    public static void setPlayList(List<Music> playList) {
        AppContext.playList = playList;
    }
}
