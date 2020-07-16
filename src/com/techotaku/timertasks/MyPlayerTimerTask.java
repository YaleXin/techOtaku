package com.techotaku.timertasks;

import com.techotaku.elements.PlayerElement;

import java.util.TimerTask;

/**
 *Author: techOtaku
 */

/**
 * 暂时弃用
 */
@Deprecated
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
