package com.jwss.music.service.impl;

import com.jwss.music.entity.AppContext;
import com.jwss.music.entity.Music;
import com.jwss.music.factory.LoggerFactory;
import com.jwss.music.logger.Logger;
import com.jwss.music.observer.ViewObserver;
import com.jwss.music.service.IMediaPlayerService;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.ListChangeListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

/**
 * @author jwss
 */
public class MediaPlayerServiceImpl implements IMediaPlayerService {
    private final Logger logger = LoggerFactory.getLogger();

    private MediaPlayer mediaPlayer = null;

    @Override
    public ListChangeListener<Music> clickToPlay() {
        ListChangeListener<Music> listener = new ListChangeListener<Music>() {
            @Override
            public void onChanged(Change<? extends Music> c) {
                play(c.getList().get(0).getUrl());
            }
        };
        return listener;
    }

    @Override
    public void play(String url) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        mediaPlayer = new MediaPlayer(new Media(new File(url).toURI().toString()));
        mediaPlayer.setVolume(0.2);
        ReadOnlyObjectProperty<Duration> currentTimeProperty = mediaPlayer.currentTimeProperty();
        currentTimeProperty.addListener((observable, oldValue, newValue) -> {
            logger.info("oldValue=" + oldValue);
            logger.info("newValue=" + newValue);
        });
        play();
    }

    @Override
    public void play() {
        mediaPlayer.play();
        AppContext.setIsPlay(true);
    }

    @Override
    public void pause() {
        mediaPlayer.pause();
        AppContext.setIsPlay(false);
    }

    @Override
    public void next() {

    }

    @Override
    public void preview() {

    }

    @Override
    public void random() {

    }

    @Override
    public void order() {

    }
}
