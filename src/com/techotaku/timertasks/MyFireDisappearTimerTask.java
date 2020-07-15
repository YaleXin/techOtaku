package com.techotaku.timertasks;

import com.techotaku.GamePanel;

import com.techotaku.elements.FireElement;

import java.util.TimerTask;

/**
 * Author：Yalexin
 * Email： 181303209@yzu.edu.cn
 */
public class MyFireDisappearTimerTask extends TimerTask {
    FireElement FireElement = null;
    GamePanel gamePanelContext = null;

    public MyFireDisappearTimerTask(GamePanel gamePanelContext, FireElement fireElement) {
        FireElement = fireElement;
        this.gamePanelContext = gamePanelContext;
    }

    @Override
    public void run() {
        this.gamePanelContext.fireElements.remove(this.FireElement);
    }
}
