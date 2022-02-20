package com.jwss.music;

import com.jwss.music.entity.AppContext;
import com.jwss.music.entity.Music;
import com.jwss.music.factory.LoggerFactory;
import com.jwss.music.factory.ServiceFactory;
import com.jwss.music.logger.Logger;
import com.jwss.music.service.IMediaPlayerService;
import com.jwss.music.service.IMusicImportService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

/**
 * @author jwss
 * @date 2022-2-6 22:13:40
 */
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger();

    @FXML
    private TableView<Music> musicTableView;
    @FXML
    private TableColumn<Music, String> nameTableColumn;
    @FXML
    private TableColumn<Music, String> authorTableColumn;
    @FXML
    private TableColumn<Music, String> albumTableColumn;
    @FXML
    private TableColumn<Music, String> durationTableColumn;
    @FXML
    private TableColumn<Music, String> sizeTableColumn;

    private final IMediaPlayerService mediaPlayerService = ServiceFactory.getMediaPlayer();

    private final IMusicImportService musicImportService = ServiceFactory.getMusicImport();

    @FXML
    protected void onImportMusicClick() {
        List<Music> musicList = musicImportService.importMusic();

        ObservableList<Music> musicObservableList = FXCollections.observableArrayList();
        musicObservableList.addAll(musicList);
        musicTableView.setItems(musicObservableList);
    }

    @FXML
    protected void onImportMusicClickByFolder() {
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
        if (!AppContext.getIsPlay()) {
            mediaPlayerService.play("");
        } else {
            mediaPlayerService.pause();
        }
    }

    @FXML
    protected void onNext() {
        // TODO 下一曲
    }

    /**
     * 在fxml文件完成载入时自动被调用
     */
    @FXML
    protected void initialize() {
        musicTableView.getSelectionModel().getSelectedItems().addListener(mediaPlayerService.clickToPlay());
        nameTableColumn.setCellValueFactory(cell -> cell.getValue().nameProperty());
        authorTableColumn.setCellValueFactory(cell -> cell.getValue().authorProperty());
        albumTableColumn.setCellValueFactory(cell -> cell.getValue().albumProperty());
        durationTableColumn.setCellValueFactory(cell -> cell.getValue().durationProperty());
        sizeTableColumn.setCellValueFactory(cell -> cell.getValue().sizeProperty());
    }
}