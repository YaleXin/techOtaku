package com.techotaku.threads;

import com.techotaku.enums.Music;
import com.techotaku.utils.PlayMusic;

/**
 * Author：Yalexin
 * Email： 181303209@yzu.edu.cn
 */
public class GameShortMusicRunnable implements Runnable{
    Music musicType = null;

    public GameShortMusicRunnable(Music musicType) {
        this.musicType = musicType;
    }

    @Override
    public void run() {
        PlayMusic instance = PlayMusic.getInstance();
        instance.play(this.musicType);
    }
}
