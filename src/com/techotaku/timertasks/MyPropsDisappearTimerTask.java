package com.techotaku.timertasks;

import com.techotaku.GamePanel;
import com.techotaku.elements.PropsElement;

import java.util.TimerTask;

/**
 * Author：Yalexin
 * Email： 181303209@yzu.edu.cn
 */
public class MyPropsDisappearTimerTask extends TimerTask {
    GamePanel gamePanelContext = null;
    PropsElement propsElement;

    public MyPropsDisappearTimerTask(GamePanel gamePanelContext, PropsElement propsElement) {
        this.gamePanelContext = gamePanelContext;
        this.propsElement = propsElement;
    }

    @Override
    public void run() {
        this.gamePanelContext.propsElements.remove(this.propsElement);
    }
}
