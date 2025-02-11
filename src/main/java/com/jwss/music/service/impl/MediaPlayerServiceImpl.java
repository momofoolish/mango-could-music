package com.jwss.music.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.swing.DesktopUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.jwss.music.entity.AppContext;
import com.jwss.music.entity.Music;
import com.jwss.music.enums.DeleteMusicType;
import com.jwss.music.factory.ServiceFactory;
import com.jwss.music.observer.ViewObserver;
import com.jwss.music.service.IMediaPlayerService;
import com.jwss.music.service.IMusicImportService;
import com.jwss.music.util.TimeUtils;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jwss
 */
public class MediaPlayerServiceImpl implements IMediaPlayerService {
    private final Log logger = LogFactory.get();

    private MediaPlayer mediaPlayer = null;

    private final IMusicImportService musicImportService = ServiceFactory.getMusicImport();

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
        // todo 随机播放
    }

    @Override
    public void order() {
        // todo 顺序播放
    }

    @Override
    public void setEvent(TableView<Music> musicTableView) {
        // 左键
        String leftButton = "PRIMARY";
        // 右键
        String rightButton = "SECONDARY";
        musicTableView.setRowFactory(param -> {
            TableRow<Music> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                int count = 2;
                Music music = row.getItem();
                // 双击播放
                if (event.getClickCount() == count && event.getButton().name().equals(leftButton)) {
                    // 播放
                    play(music);
                    // 设置当前播放的歌曲
                    List<Music> playList = AppContext.getPlayList();
                    int size = playList.size();
                    for (int i = 0; i < size; i++) {
                        if (music.getUrl().equals(playList.get(i).getUrl())) {
                            AppContext.setCurrentPlay(i);
                            break;
                        } else if (i >= size - 1) {
                            AppContext.setCurrentPlay(0);
                        }
                    }
                }
                // 右键弹出操作选项
                if (event.getButton().name().equals(rightButton)) {
                    MenuItem itemPlay = new MenuItem("播放");
                    itemPlay.setOnAction(menuItemEvent -> play(music));

                    MenuItem itemRemove = new MenuItem("从列表移除");
                    ArrayList<Music> ls = new ArrayList<>(1);
                    ls.add(music);
                    itemRemove.setOnAction(itemRemoveEvent -> {
                        // 移除这首歌曲
                        musicImportService.batchRemove(ls, DeleteMusicType.REMOVE_LIST);
                    });

                    MenuItem itemDeleteFile = new MenuItem("删除本地文件");
                    itemDeleteFile.setOnAction(itemDeleteFileEvent -> {
                        // 删除本地文件
                        musicImportService.batchRemove(ls, DeleteMusicType.REMOVE_LOCAL);
                    });

                    MenuItem itemOpenFolder = new MenuItem("打开所在目录");
                    itemDeleteFile.setOnAction(itemDeleteFileEvent -> {
                        // todo 打开所在目录
                    });
                    // 菜单容器
                    ContextMenu contextMenu = new ContextMenu();
                    contextMenu.getItems().addAll(itemPlay, itemOpenFolder, itemRemove, itemDeleteFile);
                    contextMenu.show(AppContext.getStage(), event.getScreenX(), event.getScreenY());
                }
            });
            return row;
        });
    }
}
