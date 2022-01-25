module com.jwss.music {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires jaudiotagger;

    opens com.jwss.music to javafx.fxml;
    exports com.jwss.music;
}