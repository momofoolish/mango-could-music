import React, { useState } from 'react';
import './css/MenuLayout.css';
import {
    CloudOutlined, SkinOutlined, SettingOutlined, QuestionCircleOutlined, InfoCircleOutlined,
    PoweroffOutlined, HeartOutlined, ShareAltOutlined, BlockOutlined, HistoryOutlined,
    HomeOutlined, CodeOutlined
} from '@ant-design/icons';
import { Link } from 'react-router-dom';

const aMenuList = [
    {
        icon: <CloudOutlined />,
        title: '我的音乐云库',
        path: '',
        isActive: true
    },
    {
        icon: <HistoryOutlined />,
        title: '历史播放',
        path: '',
        isActive: false
    },
    {
        icon: <HomeOutlined />,
        title: '本地音乐库',
        path: '/music-local',
        isActive: false
    },
    {
        icon: <HeartOutlined />,
        title: '收藏歌单',
        path: '/music-like',
        isActive: false
    },
    {
        icon: <BlockOutlined />,
        title: '其他人的音乐库',
        path: '',
        isActive: false
    },
    {
        icon: <SkinOutlined />,
        title: '更换皮肤',
        path: '',
        isActive: false
    },
    {
        icon: <SettingOutlined />,
        title: '设置',
        path: '',
        isActive: false
    },
    {
        icon: <QuestionCircleOutlined />,
        title: '帮助',
        path: '',
        isActive: false
    },
    {
        icon: <InfoCircleOutlined />,
        title: '关于',
        path: '',
        isActive: false
    },
    {
        icon: <CodeOutlined />,
        title: '实验室',
        path: '',
        isActive: false
    },
    {
        icon: <ShareAltOutlined />,
        title: '分享',
        path: '',
        isActive: false
    },
    {
        icon: <PoweroffOutlined />,
        title: '退出',
        path: '',
        isActive: false
    },
];

/**
 * 菜单布局
 */
function MenuLayout() {
    const [menuList, setMenuList] = useState(aMenuList);

    /**
     * 选择当前项
     * @param {Number} index 数组下标
     */
    const onSelect = (index) => {
        // 1.设置当前isActive为FALSE
        // 2.设置目标isActive为TRUE
        const newArr = menuList.map((item, i) => {
            if (i === index) {
                item.isActive = true;
            }
            if (item.isActive === true && i !== index) {
                item.isActive = false;
            }
            return item;
        });
        setMenuList(newArr);
    }

    return (
        <div id='menuOutBox'>
            <div className='menu-list'>
                {
                    menuList.map((item, index) => (
                        <Link key={index} to={item.path} onClick={onSelect.bind(this, index)}>
                            <div
                                className={
                                    item.isActive ? 'menu-item-active' : 'menu-item'
                                }>
                                {item.icon}
                                <span>{item.title}</span>
                            </div>
                        </Link>
                    ))
                }
            </div>
        </div >
    )
}

export default MenuLayout;