package com.jwss.music.observer;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

/**
 * 视图对象观测器
 *
 * @author jwss
 * @date 2022-2-22 20:04:34
 */
public class ViewObserver {
    private static Button playOrPauseMusicBtn;
    private static Label currentPlayLabel;
    private static Label endPlayLabel;
    private static ProgressBar musicPlayProgress;

    public static void load(Button popMb, Label cpl, Label epl, ProgressBar mpp) {
        playOrPauseMusicBtn = popMb;
        currentPlayLabel = cpl;
        endPlayLabel = epl;
        musicPlayProgress = mpp;
    }

    public static void updatePlayOrPauseMusicBtn(boolean flag) {
        playOrPauseMusicBtn.setText(!flag ? "▶" : "⏸");
    }

    public static void updateProgressBar(String currentPlay, String endPlay, double progress) {
        currentPlayLabel.setText(currentPlay);
        endPlayLabel.setText(endPlay);
        musicPlayProgress.setProgress(progress);
    }
}
