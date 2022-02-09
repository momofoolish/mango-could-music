package com.jwss.music;

import javafx.fxml.FXML;

/**
 * @author jwss
 * @date 2022-2-6 22:13:40
 */
public class MainController {
//    private final Media media = new Media(new File("F:\\music\\网易云\\田所あずさ - DEAREST DROP.mp3").toURI().toString());

//    MediaPlayer mediaPlayer = new MediaPlayer(media);

    @FXML
    protected void onImportMusicClick() {
        // todo 导入本地音乐

    }

    @FXML
    protected void onImportMusicClickByFolder(){
        // TODO 导入文件夹

    }

    @FXML
    protected void onImportMusicClickByShare() {
        // todo 导入外部分享乐库
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