import React from 'react';
import './css/MenuLayout.css';
import {
    CloudOutlined, SkinOutlined, SettingOutlined, QuestionCircleOutlined, InfoCircleOutlined,
    PoweroffOutlined, HeartOutlined, ShareAltOutlined, BlockOutlined, HistoryOutlined,
    HomeOutlined, CodeOutlined
} from '@ant-design/icons';

/**
 * 菜单布局
 */
function MenuLayout() {
    return (
        <div id='menuOutBox'>
            <div className='menu-list'>
                <div className='menu-item'>
                    <CloudOutlined />
                    <span>我的音乐云库</span>
                </div>
                <div className='menu-item'>
                    <HistoryOutlined />
                    <span>历史播放</span>
                </div>
                <div className='menu-item'>
                    <HomeOutlined />
                    <span>本地音乐库</span>
                </div>
                <div className='menu-item'>
                    <HeartOutlined />
                    <span>收藏歌单</span>
                </div>
                <div className='menu-item'>
                    <BlockOutlined />
                    <span>其他人的音乐库</span>
                </div>
                <div className='menu-item'>
                    <SkinOutlined />
                    <span>更换皮肤</span>
                </div>
                <div className='menu-item'>
                    <SettingOutlined />
                    <span>设置</span>
                </div>
                <div className='menu-item'>
                    <QuestionCircleOutlined />
                    <span>帮助</span>
                </div>
                <div className='menu-item'>
                    <InfoCircleOutlined />
                    <span>关于</span>
                </div>
                <div className='menu-item'>
                    <CodeOutlined />
                    <span>实验室</span>
                </div>
                <div className='menu-item'>
                    <ShareAltOutlined />
                    <span>分享</span>
                </div>
                <div className='menu-item'>
                    <PoweroffOutlined />
                    <span>退出</span>
                </div>
            </div>
        </div>
    )
}

export default MenuLayout;