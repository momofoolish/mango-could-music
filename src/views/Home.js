import React from 'react';
import MenuLayout from './layout/MenuLayout';
import './Home.css';
import 'antd/dist/antd.css';
import PlayerLayout from './layout/PlayerLayout';
import MainLayout from './layout/MainLayout';

/**
 * 主页
 */
function Home() {
    return (
        <div id='home'>
            <div className='home-center'>
                <MenuLayout />
                <MainLayout />
            </div>

            <div className='home-bottom'>
                <PlayerLayout />
            </div>
        </div>
    )
}

export default Home;