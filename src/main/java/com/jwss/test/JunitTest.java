package com.jwss.test;

import com.ejlchina.okhttps.HTTP;
import com.jwss.music.factory.LoggerFactory;
import com.jwss.music.logger.Logger;

/**
 * @author jwss
 */
public class JunitTest {
    private static final Logger logger = LoggerFactory.getLogger();

    public static void main(String[] args) {
        HTTP http = HTTP.builder()
                .baseUrl("https://www.baidu.com")
                .build();
        logger.info(http.sync("/").get().getBody().toString());
    }
}
