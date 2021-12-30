import React, { useState } from 'react';
import './css/MenuLayout.css';
import {
    CloudOutlined, SkinOutlined, SettingOutlined, QuestionCircleOutlined, InfoCircleOutlined,
    PoweroffOutlined, HeartOutlined, ShareAltOutlined, BlockOutlined, HistoryOutlined,
    HomeOutlined, CodeOutlined
} from '@ant-design/icons';
import { Link } from 'react-router-dom';
import { Popover, Button } from 'antd';

const aMenuList = [
    {
        icon: <CloudOutlined />,
        title: '我的音乐云库',
        path: '/',
        isActive: true
    },
    {
        icon: <HistoryOutlined />,
        title: '历史播放',
        path: 'music-play-history',
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
        path: '/other-people-music',
        isActive: false
    },
    {
        icon: <SkinOutlined />,
        title: '更换皮肤',
        path: '/change-theme',
        isActive: false
    },
    {
        icon: <SettingOutlined />,
        title: '设置',
        path: '/setting',
        isActive: false
    },
    {
        icon: <QuestionCircleOutlined />,
        title: '帮助',
        path: '/helper',
        isActive: false
    },
    {
        icon: <InfoCircleOutlined />,
        title: '关于',
        path: '/about',
        isActive: false
    },
    {
        icon: <CodeOutlined />,
        title: '实验室',
        path: '/laboratory',
        isActive: false
    },
    {
        icon: <ShareAltOutlined />,
        title: '分享',
        path: '/share',
        isActive: false
    },
    {
        icon: <PoweroffOutlined />,
        title: '退出',
        path: '#exit',
        isActive: false
    },
];

/**
 * 菜单布局
 */
function MenuLayout() {
    const [menuList, setMenuList] = useState(aMenuList);
    const [exitVisible, setExitVisible] = useState(false);

    /**
     * 确认取消
     */
    const onConfirmCancel = () => {
        setExitVisible(false);
    }

    /**
     * 确认退出
     */
    const onConfirmExit = () => {
        window.close();
    }

    /**
     * 选择当前项
     * @param {Number} index 数组下标
     */
    const onSelect = (index) => {
        // 如果点击的是退出则显示是否退出对话框
        if (menuList.length - 1 === index) {
            setExitVisible(true);
        } else if (exitVisible) {
            setExitVisible(false);
        }
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
            {/* 退出提示框 */}
            <Popover
                placement="rightBottom"
                title={TextPopover}
                content={
                    <ExitPopover onConfirmCancel={onConfirmCancel} onConfirmExit={onConfirmExit} />
                }
                visible={exitVisible}>
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
            </Popover>
        </div >
    )
}

/**
 * 对话框标题
 */
const TextPopover = <span>确定退出?</span>;

/**
 * 退出对话框
 */
const ExitPopover = (prop) => {
    return (
        <div id='exitPopoverOutBox'>
            <Button type='primary' onClick={prop.onConfirmExit.bind(this)}>确定</Button>
            <Button className='exit-popover-cancel' onClick={prop.onConfirmCancel.bind(this)}>
                取消
            </Button>
        </div>
    )
};

export default MenuLayout;