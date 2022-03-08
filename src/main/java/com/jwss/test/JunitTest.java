package com.jwss.test;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;
import com.ejlchina.okhttps.HTTP;
import com.ejlchina.okhttps.MsgConvertor;
import com.jwss.music.factory.LoggerFactory;
import com.jwss.music.logger.Logger;

/**
 * @author jwss
 */
public class JunitTest {
    private static final Logger logger = LoggerFactory.getLogger();

    public static void main(String[] args) {
        // logger.info(HttpUtil.get("https://www.baidu.com", CharsetUtil.CHARSET_UTF_8));
        HTTP http = HTTP.builder()
                .baseUrl("https://www.baidu.com")
                .build();
        logger.info(http.sync("/").get().getBody().toString());
    }
}
