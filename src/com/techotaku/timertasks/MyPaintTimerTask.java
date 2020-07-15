package com.techotaku.timertasks;

import com.techotaku.GamePanel;

import java.util.TimerTask;

/**
 * Author：Yalexin
 * Email： 181303209@yzu.edu.cn
 */
public class MyPaintTimerTask extends TimerTask {
    GamePanel gamePanelContext = null;

    public MyPaintTimerTask(GamePanel gamePanelContext) {
        this.gamePanelContext = gamePanelContext;
    }

    @Override
    public void run() {
        if (!this.gamePanelContext.isEnd)
        this.gamePanelContext.repaint();
    }
}
