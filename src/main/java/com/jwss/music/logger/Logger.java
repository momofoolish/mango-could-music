package com.jwss.music.logger;

/**
 * 日志实现类
 * @date 2022-2-8 22:46:07
 * @author jwss
 */
public class Logger implements ILogger{
    @Override
    public void info(String s) {
        System.out.printf("信息: %s%n", s);
    }

    @Override
    public void warn(String s) {
        System.out.format("警告: %s%n", s);
    }

    @Override
    public void error(String s) {
        System.err.printf("错误: %s%n", s);
    }
}
