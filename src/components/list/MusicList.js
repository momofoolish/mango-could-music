import React from 'react';
import './css/MusicList.css';
import { Input, Table, Space, Button } from 'antd';
import { observer } from "mobx-react";

const { Search } = Input;


MusicList.defaultProps = {
    isShowLikeBtn: true,
    handleLike: (item) => { },
    handleDelete: (key) => { }
}

/**
 * 音乐列表
 */
const MusicList = observer(({ todo, props }) => {
    const onSearch = () => { }

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
            render: (_, record) => (
                <div style={{ display: 'flex' }}>
                    <Button
                        style={{ display: props.isShowLikeBtn ? '' : 'none' }}
                        type='link'
                        onClick={props.handleLike.bind(this, record.key)}
                    >
                        <span>{record.isLike ? '已藏' : '收藏'}</span>
                    </Button>
                    <Button type='link' onClick={props.handleDelete.bind(this, record.key)}>
                        <span>移除</span>
                    </Button>
                </div>
            ),
        },
    ]

    return (
        <div id='musicList' >
            {/* 这里是操作栏 */}
            < div className='music-list-control' >
                <Space>
                    <div className='font-bold font-size-large padding-large'>音乐列表</div>
                    <span>共{props.musicSource.length}首</span>
                </Space>
                <Search
                    placeholder="搜索歌曲"
                    onSearch={onSearch}
                    style={{ width: 200 }}
                />
            </div>
            {/* 这里是列表 */}
            < div className='music-list-data' >
                <Table
                    size='small'
                    columns={columns}
                    dataSource={props.musicSource}
                    total={props.musicSource.total}
                />
            </div >
        </div >
    )
});

export default MusicList;