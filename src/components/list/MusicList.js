import React from 'react';
import './css/MusicList.css';
import { Input, Table, Tag, Space } from 'antd';
import data from '../../test-data/music-list-data';

const { Search } = Input;

/**
 * 音乐列表
 */
function MusicList() {
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
        title: 'Name',
        dataIndex: 'name',
        key: 'name',
        render: text => <a>{text}</a>,
    },
    {
        title: 'Age',
        dataIndex: 'age',
        key: 'age',
    },
    {
        title: 'Address',
        dataIndex: 'address',
        key: 'address',
    },
    {
        title: 'Tags',
        key: 'tags',
        dataIndex: 'tags',
        render: tags => (
            <>
                {tags.map(tag => {
                    let color = tag.length > 5 ? 'geekblue' : 'green';
                    if (tag === 'loser') {
                        color = 'volcano';
                    }
                    return (
                        <Tag color={color} key={tag}>
                            {tag.toUpperCase()}
                        </Tag>
                    );
                })}
            </>
        ),
    },
    {
        title: 'Action',
        key: 'action',
        render: (text, record) => (
            <Space size="middle">
                <a>Invite {record.name}</a>
                <a>Delete</a>
            </Space>
        ),
    },
]

export default MusicList;