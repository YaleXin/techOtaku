package com.techotaku.timertasks;

import com.techotaku.GamePanel;

import java.util.TimerTask;

/**
 *Author: techOtaku
 */
public class MyPaintTimerTask extends TimerTask {
    GamePanel gamePanelContext = null;

    public MyPaintTimerTask(GamePanel gamePanelContext) {
        this.gamePanelContext = gamePanelContext;
    }

    @Override
    public void run() {
        this.gamePanelContext.repaint();
    }
}
