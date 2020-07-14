package com.techotaku.timertasks;

import com.techotaku.PlayerElement;

import java.util.TimerTask;

/**
 * Author：Yalexin
 * Email： 181303209@yzu.edu.cn
 */
public class MyBombDecTimerTask extends TimerTask {
    PlayerElement playerElement = null;

    public MyBombDecTimerTask(PlayerElement playerElement) {
        this.playerElement = playerElement;
    }

    @Override
    public void run() {
        this.playerElement.bombNum++;
    }
}