package com.techotaku.timertasks;

import com.techotaku.elements.PlayerElement;

import java.util.TimerTask;

/**
 *Author: techOtaku
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