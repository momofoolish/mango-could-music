package com.jwss.music;

import com.jwss.music.entity.AppContext;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * @author jwss
 */
public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1022, 650);
        scene.getStylesheets().add(Objects.requireNonNull(MainApplication.class.getResource("main-view.css")).toExternalForm());
        stage.setTitle("MusicEverywhere");
        stage.setScene(scene);
        stage.show();
        // 将场景放入上下文
        AppContext.setFxmlLoader(fxmlLoader);
        AppContext.setStage(stage);
        // 初始化配置
        InitApp.config();
    }

    public static void main(String[] args) {
        launch();
    }
}