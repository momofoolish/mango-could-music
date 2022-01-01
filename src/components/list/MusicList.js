import React from 'react';
import './css/MusicList.css';
import { Input, Table, Space } from 'antd';

const { Search } = Input;

/**
 * 音乐列表
 */
function MusicList(props) {
    /**
     * 搜索回调函数
     */
    const onSearch = () => {

    }

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
                <Table columns={columns} dataSource={props.musicSource} pagination={false} />
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
        ellipsis: {
            showTitle: false,
        }
    },
    {
        title: '歌手',
        dataIndex: 'singer',
        key: 'singer',
        ellipsis: {
            showTitle: false,
        }
    },
    {
        title: '专辑',
        dataIndex: 'album',
        key: 'album',
        ellipsis: {
            showTitle: false,
        }
    },
    {
        title: '大小',
        key: 'size',
        dataIndex: 'size',
    },
    {
        title: '操作',
        key: 'action',
        render: (text, record) => (
            <Space size="middle">
                <a>收藏 {record.id}</a>
                <a>移除 {record.id}</a>
            </Space>
        ),
    },
]

export default MusicList;