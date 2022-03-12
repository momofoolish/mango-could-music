package com.jwss.music.service.impl;

import cn.hutool.core.lang.PatternPool;
import cn.hutool.core.lang.RegexPool;
import cn.hutool.json.JSONUtil;
import com.ejlchina.okhttps.HTTP;
import com.jwss.music.entity.AppContext;
import com.jwss.music.entity.Music;
import com.jwss.music.factory.LoggerFactory;
import com.jwss.music.factory.ServiceFactory;
import com.jwss.music.logger.Logger;
import com.jwss.music.service.ICacheService;
import com.jwss.music.service.IMusicImportService;
import com.jwss.music.util.MusicUtils;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
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
import java.util.regex.Pattern;

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
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setHeight(180);
        alert.setWidth(345);
        alert.setTitle("导入网络音乐");
        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        TextField textField = new TextField();
        textField.setText("http://");
        textField.setMinWidth(254);

        Button button = new Button("导入");
        button.setOnMouseClicked(event -> {
            String url = textField.getText();
            Pattern pattern = PatternPool.get(RegexPool.URL);
            boolean flag = pattern.matcher(url).find();
            if (flag) {
                HTTP http = HTTP.builder().baseUrl(url).build();
                String musicJson = http.sync("/").get().getBody().toString();
                @SuppressWarnings("unchecked")
                List<Music> musicList = JSONUtil.toBean(musicJson, List.class);
                cacheService.saveMusicList(musicList);
            } else {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setContentText("非法路径");
                errorAlert.show();
            }
        });

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setMinWidth(alert.getWidth());
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(textField);
        hBox.getChildren().add(button);

        Pane pane = new Pane();
        pane.setMaxHeight(alert.getWidth());
        pane.getChildren().add(hBox);

        alert.getDialogPane().setExpanded(true);
        alert.getDialogPane().setExpandableContent(pane);
        alert.getDialogPane().setMinWidth(alert.getWidth());
        alert.getDialogPane().setMinHeight(alert.getHeight());
        alert.showAndWait();
    }
}
