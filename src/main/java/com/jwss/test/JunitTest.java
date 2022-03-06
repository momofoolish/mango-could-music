package com.jwss.test;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;
import com.jwss.music.factory.LoggerFactory;
import com.jwss.music.logger.Logger;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;

import java.io.IOException;

/**
 * @author jwss
 */
public class JunitTest {
    private static final Logger logger = LoggerFactory.getLogger();

    public static void main(String[] args) throws CannotReadException, TagException, InvalidAudioFrameException, ReadOnlyFileException, IOException {
        logger.info(HttpUtil.get("https://www.baidu.com", CharsetUtil.CHARSET_UTF_8));
    }
}
