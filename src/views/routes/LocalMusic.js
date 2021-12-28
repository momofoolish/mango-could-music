import React from "react";
import MusicList from "../../components/list/MusicList";
import { Button } from 'antd';
import { ImportOutlined, ReloadOutlined } from '@ant-design/icons';
import './css/LocalMusic.css';

/**
 * 本地音乐页
 */
function LocalMusic() {
    return (
        <div id="localMusicOutBox">
            <div className="local-music-control">
                <Button type="primary" shape="round">
                    <span>导入本地</span>
                    <ImportOutlined />
                </Button>
                <Button shape="round">
                    <ReloadOutlined />
                    <span>刷新</span>
                </Button>
            </div>
            <MusicList />
        </div>
    )
}

export default LocalMusic;