package com.jwss.music.logger;

/**
 * @date 2022-2-8 22:46:07
 * @author jwss
 */
public class Logger implements ILogger{
    @Override
    public void info(String s) {
        System.out.printf("logger.info: %s%n", s);
    }

    @Override
    public void warn(String s) {
        System.out.printf("logger.warn: %s%n", s);
    }

    @Override
    public void error(String s) {
        System.out.printf("logger.error: %s%n", s);
    }
}
