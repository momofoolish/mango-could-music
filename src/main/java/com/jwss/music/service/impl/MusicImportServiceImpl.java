package com.jwss.music.service.impl;

import com.ejlchina.okhttps.HTTP;
import com.jwss.music.entity.AppContext;
import com.jwss.music.entity.Music;
import com.jwss.music.factory.LoggerFactory;
import com.jwss.music.factory.ServiceFactory;
import com.jwss.music.logger.Logger;
import com.jwss.music.service.ICacheService;
import com.jwss.music.service.IMusicImportService;
import com.jwss.music.util.MusicUtils;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jwss
 */
public class MusicImportServiceImpl implements IMusicImportService {
    private final Logger logger = LoggerFactory.getLogger();

    private final ICacheService cacheService = ServiceFactory.getCacheService();

    @Override
    public List<Music> importMusic() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("导入音乐");
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("选择mp3格式文件 (.mp3)", "*.mp3");
        fileChooser.getExtensionFilters().add(filter);
        fileChooser.setSelectedExtensionFilter(filter);
        List<File> fileList = fileChooser.showOpenMultipleDialog(AppContext.getStage());
        List<String> urls = new ArrayList<>();
        fileList.forEach(item -> urls.add(item.getPath()));
        try {
            return MusicUtils.readMusicsInfo(urls);
        } catch (CannotReadException | IOException | ReadOnlyFileException | InvalidAudioFrameException | TagException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Music> importMusicByFolder() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File file = directoryChooser.showDialog(AppContext.getStage());
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            List<String> urls = new ArrayList<>(length);
            if (length > 0) {
                for (File listFile : listFiles) {
                    String path = listFile.getPath();
                    if (MusicUtils.isSupportFile(path)) {
                        urls.add(path);
                    }
                }
            }
            try {
                return MusicUtils.readMusicsInfo(urls);
            } catch (CannotReadException | IOException | ReadOnlyFileException | InvalidAudioFrameException | TagException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void importMusicByShare() {
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        Pane pane =new Pane();
        pane.getChildren().add(new TextField("输入路径"));
        alert.getDialogPane().setExpandableContent(pane);
        alert.show();
        HTTP http = HTTP.builder()
                .baseUrl("https://live1024.cn")
                .build();
        logger.info(http.sync("/").get().getBody().toString());
    }
}
