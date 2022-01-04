import React from "react";
import './css/TopLayout.css';
import { BorderOutlined, MinusOutlined, CloseOutlined } from '@ant-design/icons';
import { Space } from "antd";

/**
 * 顶部布局组件
 */
function TopLayout() {
    return (
        <div id="topLayoutOutBox">
            <div className="top-layout-logo">橘子云音乐</div>
            <Space className="top-layout-control">
                <MinusOutlined />
                <BorderOutlined />
                <CloseOutlined />
            </Space>
        </div>
    )
}

export default TopLayout;