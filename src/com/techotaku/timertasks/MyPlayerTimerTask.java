package com.techotaku.timertasks;

import com.techotaku.elements.PlayerElement;

import java.util.TimerTask;

/**
 * Author：Yalexin
 * Email： 181303209@yzu.edu.cn
 */
public class MyPlayerTimerTask extends TimerTask {
    PlayerElement playerElement = null;

    public MyPlayerTimerTask(PlayerElement playerElement) {
        this.playerElement = playerElement;
    }

    @Override
    public void run() {
        this.playerElement.isInvincible = false;
    }
}
