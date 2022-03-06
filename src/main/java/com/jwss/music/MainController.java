package com.jwss.music;

import com.jwss.music.entity.AppContext;
import com.jwss.music.entity.Music;
import com.jwss.music.factory.LoggerFactory;
import com.jwss.music.factory.ServiceFactory;
import com.jwss.music.logger.Logger;
import com.jwss.music.observer.ViewObserver;
import com.jwss.music.service.ICacheService;
import com.jwss.music.service.IMediaPlayerService;
import com.jwss.music.service.IMusicImportService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

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

    @FXML
    private ProgressBar musicPlayProgress;
    @FXML
    private Label currentPlayLabel;
    @FXML
    private Label endPlayLabel;

    @FXML
    private Button playOrPauseMusicBtn;

    private final IMediaPlayerService mediaPlayerService = ServiceFactory.getMediaPlayer();

    private final IMusicImportService musicImportService = ServiceFactory.getMusicImport();

    private final ICacheService cacheService = ServiceFactory.getCacheService();

    @FXML
    protected void onImportMusicClick() {
        List<Music> musicList = musicImportService.importMusic();
        if (musicList.size() > 0) {
            renderTableView(musicList);
            cacheService.saveMusicList(musicList);
        }
    }

    @FXML
    protected void onImportMusicClickByFolder() {
        // 导入文件夹
        List<Music> musicList = musicImportService.importMusicByFolder();
        if (musicList.size() > 0) {
            renderTableView(musicList);
            cacheService.saveMusicList(musicList);
        }
    }

    @FXML
    protected void onImportMusicClickByShare() {
        // todo 导入外部分享乐库
        // Alert alert =new Alert(Alert.AlertType.INFORMATION);
        // Pane pane =new Pane();
        // pane.getChildren().add(new TextField("输入路径"));
        // alert.getDialogPane().setExpandableContent(pane);
        // alert.show();
        musicImportService.importMusicByShare();
    }

    @FXML
    protected void onPreview() {
        // 上一曲
        mediaPlayerService.preview();
    }

    @FXML
    protected void onPlayOrPause() {
        // 暂停或者播放音乐
        if (!AppContext.getIsPlay()) {
            mediaPlayerService.play();
        } else {
            mediaPlayerService.pause();
        }
    }

    @FXML
    protected void onNext() {
        // 下一曲
        mediaPlayerService.next();
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
        // 加载本地音乐
        renderTableView(cacheService.getMusicList());
        // 加载需要观察的对象
        ViewObserver.load(playOrPauseMusicBtn, currentPlayLabel, endPlayLabel, musicPlayProgress);
        // 将音乐加入到播放列表
        AppContext.setPlayList(cacheService.getMusicList());
    }

    /**
     * 渲染表格数据
     *
     * @param musicList 音乐列表
     */
    private void renderTableView(List<Music> musicList) {
        ObservableList<Music> musicObservableList = FXCollections.observableArrayList();
        musicObservableList.addAll(musicList);
        musicTableView.setItems(musicObservableList);
    }
}