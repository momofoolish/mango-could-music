import React from "react";
import './css/PlayerLayout.css';
import { Button } from 'antd';
import { CaretRightOutlined, StepBackwardOutlined, StepForwardOutlined } from '@ant-design/icons';

/**
 * 播放器控制面板
 */
function PlayerLayout() {
    return (
        <div id='playerOutBox'>
            <div>左边要有信心</div>
            <Center />
            <div>左边要有信心</div>
        </div>
    )
}

const Center = () => {
    return (
        <div className="palyer-center">
            <div>
                <Button shape="circle" size="large" icon={<StepBackwardOutlined />}></Button>
                <Button type="primary" shape="circle" size="large" icon={<CaretRightOutlined />}>
                </Button>
                <Button shape="circle" size="large" icon={<StepForwardOutlined />}></Button>
            </div>
            <div></div>
        </div>
    )
}

export default PlayerLayout;