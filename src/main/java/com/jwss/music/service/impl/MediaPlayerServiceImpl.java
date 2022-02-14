package com.jwss.music.service.impl;

import com.jwss.music.entity.AppContext;
import com.jwss.music.factory.LoggerFactory;
import com.jwss.music.logger.Logger;
import com.jwss.music.service.IMediaPlayerService;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * @author jwss
 */
public class MediaPlayerServiceImpl implements IMediaPlayerService {
    private final Logger logger = LoggerFactory.getLogger();

    private Media media = null;

    private MediaPlayer mediaPlayer = null;

    @Override
    public void play(String url) {
        if (media == null) {
            media = new Media(url);
        }
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setVolume(0.1);
            ReadOnlyObjectProperty<Duration> currentTimeProperty = mediaPlayer.currentTimeProperty();
            currentTimeProperty.addListener((observable, oldValue, newValue) -> {
                logger.info("oldValue=" + oldValue);
                logger.info("newValue=" + newValue);
            });
        }
        mediaPlayer.play();
        AppContext.setIsPlay(true);
    }

    @Override
    public void pause() {
        mediaPlayer.pause();
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
