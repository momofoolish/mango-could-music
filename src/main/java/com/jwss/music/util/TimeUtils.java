package com.jwss.music.util;

/**
 * 时间转换工具
 *
 * @author jwss
 * @date 2022-2-26 20:44:06
 */
public class TimeUtils {
    private static final String SEPARATOR = ":";

    private static final String ZERO = "0";

    /**
     * 将秒转换成分钟显示，例如五秒==00:05
     *
     * @param seconds 秒
     * @return 分钟显示
     */
    public static String secondsToMin(Integer seconds) {
        int s = seconds % 60;
        int m = seconds / 60;
        return (m < 10 ? ZERO + m : m) + SEPARATOR + (s < 10 ? ZERO + s : s);
    }

}
