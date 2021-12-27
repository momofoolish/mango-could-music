import React from "react";
import './css/PlayerLayout.css';
import { Button, Progress, Image } from 'antd';
import {
    CaretRightOutlined, StepBackwardOutlined, StepForwardOutlined, SwapOutlined, MenuUnfoldOutlined,
    SoundOutlined,
} from '@ant-design/icons';

/**
 * 播放器控制面板
 */
function PlayerLayout() {
    return (
        <div id='playerOutBox'>
            <Left />
            <Center />
            <Right />
        </div>
    )
}

// 中部组件
const Center = () => {
    return (
        <div className="player-center">
            {/* 操作面板 */}
            <div className="player-center-control">
                <div className="player-center-control-play-type color-single-hover">
                    <SwapOutlined className="icon-single-size" />
                </div>
                <div className="player-center-control-preview color-single-hover">
                    <StepBackwardOutlined className="icon-single-size" />
                </div>
                <Button type="primary" shape="circle" size="large" icon={<CaretRightOutlined />}>
                </Button>
                <div className="player-center-control-next color-single-hover">
                    <StepForwardOutlined className="icon-single-size" />
                </div>
            </div>
            {/* 进度条 */}
            <div className="player-center-progress">
                <span className="player-center-progress-start-time">01:00</span>
                <Progress percent={30} showInfo={false} />
                <span className="player-center-progress-total-time">04:00</span>
            </div>
        </div>
    )
}

// 左侧组件
const Left = () => {
    return (
        <div className="player-left color-single-hover">
            <Image
                className="player-left-img"
                width={64}
                src="https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png"
            />
            <div className="player-left-music-info">
                <div className="player-left-music-info-name">音乐的名称</div>
                <div className="player-left-music-info-singer">Lisa</div>
            </div>
        </div>
    )
}

// 右侧组件
const Right = () => {
    return (
        <div className="player-right">
            <SoundOutlined
                className="icon-single-size color-single-hover palyer-right-sound"
            />
            <MenuUnfoldOutlined
                className="icon-single-size color-single-hover"
            />
        </div>
    )
}

export default PlayerLayout;