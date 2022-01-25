package com.jwss.music.entity;

/**
 * @date 2022-1-24 21:02:20
 * @author jwss
 */
public class Music {
    /**
     * 音乐名称
     */
    private String name;
    /**
     * 音乐作者
     */
    private String author;
    /**
     * 专辑
     */
    private String album;
    /**
     * 时长
     */
    private Long duration;
    /**
     * 文件大小
     */
    private Long size;
    /**
     * 存放位置
     */
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
