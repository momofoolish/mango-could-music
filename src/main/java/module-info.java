module com.jwss.music {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires jaudiotagger;
    requires hutool.all;
    requires okhttps;
    requires okhttps.gson;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    opens com.jwss.music to javafx.fxml;
    exports com.jwss.music;
}