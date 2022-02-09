package com.jwss.music.logger;

/**
 * 日志接口
 * @date 2022-2-8 22:45:44
 * @author jwss
 */
public interface ILogger {
    /**
     * 输出信息
     * @param s 字符串
     */
    void info(String s);

    /**
     * 输出警告信息
     * @param s 字符串
     */
    void warn(String s);

    /**
     * 输出错误信息
     * @param s 字符串
     */
    void error(String s);

}
