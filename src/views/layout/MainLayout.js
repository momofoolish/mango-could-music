import React from 'react';
import { Route, Routes } from 'react-router-dom';
import MusicLike from '../routes/MusicLike';
import HomeRoute from '../routes/HomeRoute';
import './css/MainLayout.css';
import LocalMusic from '../routes/LocalMusic';

function MainLayout() {
    return (
        <div id='mainOutBox'>
            <Routes>
                <Route exact path="/" element={<HomeRoute />} />
                <Route exact path="/music-like" element={<MusicLike />} />
                <Route exact path="/music-local" element={<LocalMusic />} />
            </Routes>
        </div>
    )
}

export default MainLayout;