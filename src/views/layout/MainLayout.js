import React from 'react';
import { Route, Routes, useLocation } from 'react-router-dom';
import MusicLike from '../routes/MusicLike';
import HomeRoute from '../routes/HomeRoute';
import './css/MainLayout.css';
import LocalMusic from '../routes/LocalMusic';
import MusicPlayHistory from '../routes/MusicPlayHistory';
import OtherPeopleMusic from '../routes/OtherPeopleMusic';
import ChangeTheme from '../routes/ChangeTheme';
import Setting from '../routes/Setting';
import Helper from '../routes/Helper';
import About from '../routes/About';
import Laboratory from '../routes/Laboratory';
import Share from '../routes/Share';
import { CSSTransition, TransitionGroup } from 'react-transition-group';

/**
 * 主内容：路由布局
 */
function MainLayout(props) {
    const location = useLocation();
    return (
        <div id='mainOutBox'>
            <TransitionGroup>
                <CSSTransition key={location.pathname} classNames="fade" timeout={800}>
                    <Routes>

                        <Route exact path="/" element={<HomeRoute />} />
                        <Route exact path="/music-like" element={<MusicLike />} />
                        <Route exact path="/music-local" element={<LocalMusic />} />
                        <Route exact path="/music-play-history" element={<MusicPlayHistory />} />
                        <Route exact path="/other-people-music" element={<OtherPeopleMusic />} />
                        <Route exact path="/change-theme" element={<ChangeTheme />} />
                        <Route exact path="/setting" element={<Setting />} />
                        <Route exact path="/helper" element={<Helper />} />
                        <Route exact path="/about" element={<About />} />
                        <Route exact path="/laboratory" element={<Laboratory />} />
                        <Route exact path="/share" element={<Share />} />

                    </Routes>
                </CSSTransition>
            </TransitionGroup>
        </div>
    )
}

export default MainLayout;