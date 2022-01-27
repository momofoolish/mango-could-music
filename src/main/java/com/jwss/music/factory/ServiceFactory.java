package com.jwss.music.factory;

import com.jwss.music.service.IMediaPlayerService;
import com.jwss.music.service.IMusicImportService;
import com.jwss.music.service.impl.MediaPlayerServiceImpl;
import com.jwss.music.service.impl.MusicImportServiceImpl;

/**
 * 服务工具类：用于获取服务实例
 *
 * @author jwss
 * @date 2022-1-27 19:27:13
 */
public class ServiceFactory {
    private static IMediaPlayerService iMediaPlayerService = null;

    private static IMusicImportService iMusicImportService = null;

    /**
     * 获取媒体播放器服务实例
     * @return 媒体播放器服务实例
     */
    public static IMediaPlayerService getMediaPlayer() {
        if (iMediaPlayerService == null) {
            iMediaPlayerService = new MediaPlayerServiceImpl();
            return iMediaPlayerService;
        }
        return iMediaPlayerService;
    }

    /**
     * 获取导入音乐服务实例
     * @return 导入音乐服务实例
     */
    public static IMusicImportService getMusicImport() {
        if (iMusicImportService == null) {
            iMusicImportService = new MusicImportServiceImpl();
            return iMusicImportService;
        }
        return iMusicImportService;
    }

}
