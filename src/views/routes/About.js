import { Button } from "antd";
import React from "react";

/**
 * 设置中心
 */
function About() {
    return(
        <div id="aboutOutBox">
            <p>作者：jwss</p>
            <p>版本：v0.1.0</p>
            <Button>检查更新</Button>
        </div>
    )
}

export default About;