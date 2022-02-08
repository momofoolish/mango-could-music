package com.jwss.music;

import com.jwss.music.entity.AppContext;
import com.jwss.music.factory.LoggerFactory;
import com.jwss.music.logger.Logger;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;

/**
 * @date 2022-2-6 22:13:40
 * @author jwss
 */
public class MainController {
    private Logger logger = LoggerFactory.getLogger();
//    private final Media media = new Media(new File("F:\\music\\网易云\\田所あずさ - DEAREST DROP.mp3").toURI().toString());

//    MediaPlayer mediaPlayer = new MediaPlayer(media);

    @FXML
    protected void onImportMusicClick() {
        // todo 导入本地音乐
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("导入音乐");
        File file = fileChooser.showOpenDialog(AppContext.getStage());
        logger.info(file.getPath());
    }

    @FXML
    protected void onPreview() {
        // todo 上一曲
    }

    @FXML
    protected void onPlayOrPause() {
        // todo 暂停或者播放音乐

        // mediaPlayer.setVolume(0.1);
        // ReadOnlyObjectProperty<Duration> currentTimeProperty = mediaPlayer.currentTimeProperty();
        // currentTimeProperty.addListener((observable, oldValue, newValue) -> {
        //     System.out.println("oldValue=" + oldValue);
        //     System.out.println("newValue=" + newValue);
        // });
        // mediaPlayer.play();
    }

    @FXML
    protected void onNext() {
        // TODO 下一曲
    }
}