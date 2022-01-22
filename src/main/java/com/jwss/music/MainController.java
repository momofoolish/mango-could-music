package com.jwss.music;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;

/**
 * @author jwss
 */
public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    private Slider slider;

    @FXML
    private MediaView mediaView;

    private final Media media = new Media(new File("F:\\music\\网易云\\田所あずさ - DEAREST DROP.mp3").toURI().toString());

    MediaPlayer mediaPlayer = new MediaPlayer(media);

    @FXML
    protected void onHelloButtonClick() {

        System.out.println(slider.getMax());

        mediaPlayer.setVolume(0.1);
        slider.setMax(mediaPlayer.getTotalDuration().toSeconds());

        welcomeText.setText("Welcome to JavaFX Application!");

        ReadOnlyObjectProperty<Duration> currentTimeProperty = mediaPlayer.currentTimeProperty();

        currentTimeProperty.addListener((observable, oldValue, newValue) -> {
            System.out.println("oldValue=" + oldValue);
            System.out.println("newValue=" + newValue);
            slider.setValue(newValue.toSeconds());
        });

        mediaPlayer.play();


    }
}