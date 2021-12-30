import React from "react";
import { Card } from 'antd';

const { Meta } = Card;

/**
 * 歌单列表
 */
function SongSheetList() {
    return (
        <Card
            style={{ width: 200 }}
            cover={
                <img
                    alt="cover"
                    src="https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png"
                />
            }
        >
            <Meta
                title="Card title"
                description="This is the description"
            />
        </Card>
    )
}

export default SongSheetList;