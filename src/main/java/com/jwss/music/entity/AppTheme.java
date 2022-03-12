package com.jwss.music.entity;

/**
 * 主题实体类
 * @date 2022-2-14 20:36:11
 * @author jwss
 */
public class AppTheme {
    private String primaryColor;

    private String fontColor;

    private String font;

    private String background;

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
