package com.techotaku.threads;

import com.techotaku.GamePanel;

/**
 *Author: techOtaku
 */
public class PlayerInvincibleRunnable implements Runnable {
    GamePanel gamePanelContext = null;

    public PlayerInvincibleRunnable(GamePanel gamePanelContext) {
        this.gamePanelContext = gamePanelContext;
    }

    @Override
    public void run() {
        // 有没有玩家需要更新无敌时间？
        boolean have = false;
        while (true) {
            try {
                have = false;
                if (this.gamePanelContext.bluePlayer.invincibleTime > 0) {
                    this.gamePanelContext.bluePlayer.invincibleTime--;
                    have = true;
                }
                if (this.gamePanelContext.redPlayer.invincibleTime > 0) {
                    this.gamePanelContext.redPlayer.invincibleTime--;
                    have = true;
                }
                if (have){
                Thread.sleep(1000);
                }else {
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
