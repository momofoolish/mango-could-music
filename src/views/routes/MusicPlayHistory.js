import React from 'react';
import { Button } from 'antd';
import { CaretRightOutlined } from '@ant-design/icons';
import MusicHistoryList from '../../components/list/MusicHistoryList';
import './css/MusicPlayHistory.css';

/**
 * 历史播放页
 */
function MusicPlayHistory() {
    return (
        <div id='musicHistoryOutBox'>
            {/* 其它操作 */}
            <div className="music-history-control">
                <div>
                    <Button type='primary' circle shape='round'>
                        <CaretRightOutlined />
                        播放全部
                    </Button>
                    <span>共{312}首</span>
                </div>
                <Button type='link'>清空历史</Button>
            </div>
            {/* 音乐列表 */}
            <div><MusicHistoryList /></div>
        </div>
    );
}

export default MusicPlayHistory;
