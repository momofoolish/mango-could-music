package com.jwss.music.service.impl;

import com.jwss.music.entity.AppContext;
import com.jwss.music.factory.LoggerFactory;
import com.jwss.music.logger.Logger;
import com.jwss.music.service.IMusicImportService;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

/**
 * @author jwss
 */
public class MusicImportServiceImpl implements IMusicImportService {
    private final Logger logger = LoggerFactory.getLogger();

    @Override
    public void importMusic() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("导入音乐");
        List<File> fileList = fileChooser.showOpenMultipleDialog(AppContext.getStage());
        fileList.forEach(item -> {
            logger.info(item.getPath());
        });
    }

    @Override
    public void importMusicByFolder() {
        DirectoryChooser directoryChooser=new DirectoryChooser();
        File file = directoryChooser.showDialog(AppContext.getStage());
        logger.info(file.getPath());
    }

    @Override
    public void importMusicByShare() {

    }
}
