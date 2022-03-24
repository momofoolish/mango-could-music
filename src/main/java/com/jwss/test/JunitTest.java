package com.jwss.test;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.jwss.music.enums.DeleteMusicType;

/**
 * @author jwss
 */
public class JunitTest {
    private static final Log logger = LogFactory.get();

    public static void main(String[] args) {
        // HTTP http = HTTP.builder()
        //         .baseUrl("https://www.baidu.com")
        //         .build();
        // logger.info(http.sync("/").get().getBody().toString());
        logger.info("flag=" + (DeleteMusicType.REMOVE_LIST_LOCAL == DeleteMusicType.REMOVE_LIST_LOCAL));
    }
}
