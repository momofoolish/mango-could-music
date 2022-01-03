import React, { useEffect, useState } from 'react';
import './css/MusicLike.css';
import { Image, Avatar, Button } from 'antd';
import { UserOutlined, CaretRightOutlined, ShareAltOutlined } from '@ant-design/icons';
import MusicList from '../../components/list/MusicList';
import { LOCAL_MUSIC_KEY } from '../../js/const-key';


/**
 * 喜欢的音乐
 */
function MusicLike() {
  const [musicList, setMusicList] = useState([]);

  const handleDelete = (key) => {

  }

  /**
   * 组件生命周期
   */
  useEffect(() => {
    let list = localStorage.getItem(LOCAL_MUSIC_KEY);
    list = list ? JSON.parse(list) : [];
    let data = list.filter((item) => item.isLike);
    setMusicList(data);
  }, []);

  return (
    <div id='musicOutBox'>
      {/* 其它操作 */}
      <div className='music-control'>
        <Image
          width={180}
          className='border-single-radius'
          src="https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png"
        />
        <div className='music-control-button'>
          <h2 style={{ fontWeight: 700 }}>我很喜欢的音乐</h2>
          <div className='music-control-user-info'>
            <Avatar size="small" icon={<UserOutlined />} />
            <span className='font-size-small margin-left-single'>某人姓名</span>
            <span className='font-size-small margin-left-single'>2021-10-10</span>
            <span className='font-size-small margin-left-single'>创建</span>
          </div>
          <div>
            <Button
              className='margin-left-single'
              type="primary"
              shape="round"
              icon={<CaretRightOutlined />}
              size="medium"
            >
              全部播放
            </Button>
            <Button
              className='margin-left-single'
              type="primary" shape="round"
              icon={<ShareAltOutlined />}
              size="medium"
            >
              分享
            </Button>
          </div>
          <div>
            <span className='font-size-small'>歌曲：1222</span>
            <span className='margin-left-single font-size-small'>播放列表：801</span>
          </div>
        </div>
      </div>
      {/* 音乐列表 */}
      <div className='margin-top-large'>
        <MusicList
          isShowLikeBtn={false}
          musicSource={musicList}
          handleDelete={handleDelete} />
      </div>
    </div>
  );
}

export default MusicLike;
