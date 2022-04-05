package com.jwss.music.entity;

import com.jwss.music.util.TimeUtils;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author jwss
 * @date 2022-1-24 21:02:20
 */
public class Music {
    private final SimpleStringProperty id = new SimpleStringProperty();
    /**
     * 音乐名称
     */
    private final SimpleStringProperty name = new SimpleStringProperty();
    /**
     * 音乐作者
     */
    private final SimpleStringProperty author = new SimpleStringProperty();
    /**
     * 专辑
     */
    private final SimpleStringProperty album = new SimpleStringProperty();
    /**
     * 时长
     */
    private final SimpleStringProperty duration = new SimpleStringProperty();
    /**
     * 文件大小
     */
    private final SimpleStringProperty size = new SimpleStringProperty();
    /**
     * 存放位置
     */
    private final SimpleStringProperty url = new SimpleStringProperty();

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAuthor() {
        return author.get();
    }

    public SimpleStringProperty authorProperty() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public String getAlbum() {
        return album.get();
    }

    public SimpleStringProperty albumProperty() {
        return album;
    }

    public void setAlbum(String album) {
        this.album.set(album);
    }

    public String getDuration() {
        return duration.get();
    }

    public SimpleStringProperty durationProperty() {
        return new SimpleStringProperty(TimeUtils.secondsToMin(Integer.parseInt(getDuration())));
    }

    public void setDuration(String duration) {
        this.duration.set(duration);
    }

    public String getSize() {
        return size.get();
    }

    public SimpleStringProperty sizeProperty() {
        return size;
    }

    public void setSize(String size) {
        this.size.set(size);
    }

    public String getUrl() {
        return url.get();
    }

    public SimpleStringProperty urlProperty() {
        return url;
    }

    public void setUrl(String url) {
        this.url.set(url);
    }
}
