package com.yalexin.bomb.threads;

import com.yalexin.bomb.Data;
import com.yalexin.bomb.GamePanel;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Author：Yalexin
 * Email： 181303209@yzu.edu.cn
 */
public class MyRunnable implements Runnable {
    GamePanel gamePanelContext = null;

    public MyRunnable(GamePanel gamePanelContext) {
        this.gamePanelContext = gamePanelContext;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(40);
                this.gamePanelContext.repaint();
//                if (!this.gamePanelContext.isEnd()) {
//                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
