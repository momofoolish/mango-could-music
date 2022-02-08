package com.jwss.music.factory;

import com.jwss.music.logger.Logger;

/**
 * 日志工厂
 *
 * @author jwss
 * @date 2022-2-8 22:43:21
 */
public class LoggerFactory {
    private static Logger logger = null;

    /**
     * 获取日志实例
     * @return 日志实例
     */
    public static Logger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }
}
