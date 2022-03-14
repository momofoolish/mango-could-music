package com.jwss.music.service.impl;

import com.jwss.music.entity.AppContext;
import com.jwss.music.entity.Music;
import com.jwss.music.factory.LoggerFactory;
import com.jwss.music.logger.Logger;
import com.jwss.music.observer.ViewObserver;
import com.jwss.music.service.IMediaPlayerService;
import com.jwss.music.util.TimeUtils;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Callback;
import javafx.util.Duration;

import java.io.File;
import java.util.List;

/**
 * @author jwss
 */
public class MediaPlayerServiceImpl implements IMediaPlayerService {
    private final Logger logger = LoggerFactory.getLogger();

    private MediaPlayer mediaPlayer = null;

    @Override
    public void play(Music music) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        mediaPlayer = new MediaPlayer(new Media(new File(music.getUrl()).toURI().toString()));
        mediaPlayer.setVolume(0.2);
        ReadOnlyObjectProperty<Duration> currentTimeProperty = mediaPlayer.currentTimeProperty();
        String endPlay = TimeUtils.secondsToMin(Integer.parseInt(music.getDuration()));
        currentTimeProperty.addListener((observable, oldValue, newValue) -> {
            double seconds = newValue.toSeconds();
            double v = seconds / Integer.parseInt(music.getDuration());
            ViewObserver.updateProgressBar(TimeUtils.secondsToMin((int) seconds), endPlay, v);
        });
        play();
    }

    @Override
    public void play() {
        mediaPlayer.play();
        AppContext.setIsPlay(true);
    }

    @Override
    public void pause() {
        mediaPlayer.pause();
        AppContext.setIsPlay(false);
    }

    @Override
    public void next() {
        Integer index = AppContext.getCurrentPlay();
        if (index < AppContext.getPlayList().size()) {
            Music music = AppContext.getPlayList().get(index + 1);
            play(music);
            AppContext.setCurrentPlay(index + 1);
        }
    }

    @Override
    public void preview() {
        // 拿到当前的歌曲索引
        Integer index = AppContext.getCurrentPlay();
        if (index > 0) {
            Music music = AppContext.getPlayList().get(index - 1);
            play(music);
            AppContext.setCurrentPlay(index - 1);
        }
    }

    @Override
    public void random() {

    }

    @Override
    public void order() {

    }

    @Override
    public void setEvent(TableView<Music> musicTableView) {
        musicTableView.setRowFactory(param -> {
            TableView.TableViewSelectionModel<Music> selectionModel = param.getSelectionModel();
            logger.info("index="+selectionModel.getFocusedIndex());
            TableRow<Music> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                // 左键
                String leftButton = "PRIMARY";
                // 右键
                String rightButton = "SECONDARY";
                // 双击播放
                int count = 2;
                if (event.getClickCount() == count && event.getButton().name().equals(leftButton)) {
                    logger.info("双击了" + param.getItems().get(0).getName());

                    // String url = c.getList().get(0).getUrl();
                    // // 播放
                    // play(c.getList().get(0));
                    // // 设置当前播放的歌曲
                    // List<Music> playList = AppContext.getPlayList();
                    // int size = playList.size();
                    // for (int i = 0; i < size; i++) {
                    //     if (url.equals(playList.get(i).getUrl())) {
                    //         AppContext.setCurrentPlay(i);
                    //         break;
                    //     } else if (i >= size - 1) {
                    //         AppContext.setCurrentPlay(0);
                    //     }
                    // }
                }
                // 右键弹出操作选项
                if (event.getButton().name().equals(rightButton)) {
                    logger.info("右键单击了");
                }


            });
            return row;
        });
    }
}
