package com.jwss.component.button;

import com.jwss.component.JuThemeConfig;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * JustUI按钮组件
 *
 * @author jwss
 * @date 2022-5-2 17:30:30
 */
public class JuButton extends Button {
    public JuButton() {
        this.setBorder(new Border(new BorderStroke(Color.valueOf(JuThemeConfig.BORDER_BASE), BorderStrokeStyle.NONE, new CornerRadii(3), BorderWidths.DEFAULT)));
        this.setBackground(new Background(new BackgroundFill(Color.valueOf(JuThemeConfig.PRIMARY), new CornerRadii(3), Insets.EMPTY)));
        this.setTextFill(Color.valueOf(JuThemeConfig.SECOND_TEXT));
    }
}
