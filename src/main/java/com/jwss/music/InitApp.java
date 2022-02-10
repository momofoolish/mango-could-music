package com.jwss.music;

import com.jwss.music.entity.Music;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * @date 2022-2-5 19:07:59
 * @author jwss
 */
public class InitApp {

    /**
     * 初始化配置
     */
    public static void config() {
        // 1.初始化 UI界面配置
        // 2.初始化 播放列表
        // 3.初始化 初始化播放器配置
    }

    /**
     * 初始化表格
     */
    private static void initTableView(TableView<Music> musicTableView) {
        TableColumn column=new TableColumn("aaa");
        TableColumn column2=new TableColumn("bbb");
        TableColumn column3=new TableColumn("ccc");
        musicTableView.getColumns().setAll(column,column2,column3);
    }
}
