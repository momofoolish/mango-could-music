import React from 'react';
import MenuLayout from './layout/MenuLayout';
import MusicLayout from './layout/MusicLayout';
import './Home.css';
import 'antd/dist/antd.css';
import PlayerLayout from './layout/PlayerLayout';

/**
 * 主页
 */
function Home() {
    return (
        <div id='home'>
            <div className='home-center'>
                <MenuLayout />
                <MusicLayout />
            </div>

            <div className='home-bottom'>
                <PlayerLayout />
            </div>
        </div>
    )
}

export default Home;