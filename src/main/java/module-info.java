module com.jwss.music {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires jaudiotagger;
    requires hutool.all;

    opens com.jwss.music to javafx.fxml;
    exports com.jwss.music;
}