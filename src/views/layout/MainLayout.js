import React from 'react';
import { Route, Routes } from 'react-router-dom';
import MusicLike from '../routes/MusicLike';
import HomeRoute from '../routes/HomeRoute';
import './css/MainLayout.css';

function MainLayout() {
    return (
        <div id='mainOutBox'>
            <Routes>
                <Route exact path="/" element={<HomeRoute />} />
                <Route exact path="/music-like" element={<MusicLike />} />
            </Routes>
        </div>
    )
}

export default MainLayout;