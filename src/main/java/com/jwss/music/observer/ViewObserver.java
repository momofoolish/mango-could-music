package com.jwss.music.observer;

import javafx.scene.control.Button;

/**
 * 视图对象观测器
 *
 * @author jwss
 * @date 2022-2-22 20:04:34
 */
public class ViewObserver {
    private static Button playOrPauseMusicBtn;

    public static void updatePlayOrPauseMusicBtn(boolean flag) {
        playOrPauseMusicBtn.setText(!flag ? "▶" : "⏸");
    }

    public static void load(Button popMb) {
        playOrPauseMusicBtn = popMb;
    }
}
