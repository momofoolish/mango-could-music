import React from 'react';
import './css/MusicList.css';
import { Input, Table } from 'antd';
import data from '../../test-data/music-list-data';

const { Search } = Input;

/**
 * 音乐播放历史列表
 */
function MusicHistoryList() {
    /**
     * 搜索回调函数
     */
    const onSearch = () => {}

    return (
        <div id='musicList'>
            {/* 这里是操作栏 */}
            <div className='music-list-control'>
                <div className='font-bold font-size-large padding-large'>音乐列表</div>
                <Search
                    placeholder="搜索歌曲"
                    onSearch={onSearch}
                    style={{ width: 200 }}
                />
            </div>
            {/* 这里是列表 */}
            <div className='music-list-data'>
                <Table columns={columns} dataSource={data} pagination={false} />
            </div>
        </div>
    )
}

/**
 * 表格行配置
 */
const columns = [
    {
        title: '标题',
        dataIndex: 'title',
        key: 'title',
    },
    {
        title: '歌手',
        dataIndex: 'singer',
        key: 'singer',
    },
    {
        title: '播放时间',
        key: 'time',
        dataIndex: 'time',
    }
]

export default MusicHistoryList;