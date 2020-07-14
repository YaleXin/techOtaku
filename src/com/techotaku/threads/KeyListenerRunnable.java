package com.techotaku.threads;

import com.techotaku.GamePanel;
import com.techotaku.enums.Direction;
import com.techotaku.enums.KeySet;

/**
 * Author：Yalexin
 * Email： 181303209@yzu.edu.cn
 */
public class KeyListenerRunnable implements Runnable {
    GamePanel gamePanelContext = null;

    public KeyListenerRunnable(GamePanel gamePanelContext) {
        this.gamePanelContext = gamePanelContext;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(40);


                // 蓝方角色控制
                if (this.gamePanelContext.keySets.contains(KeySet.W)) {
                    this.gamePanelContext.bluePlayer.nowDirection = Direction.UP;
                    this.gamePanelContext.bluePlayer.y -= this.gamePanelContext.bluePlayer.speed;
                }
                if (this.gamePanelContext.keySets.contains(KeySet.S)) {
                    this.gamePanelContext.bluePlayer.nowDirection = Direction.DOWN;
                    this.gamePanelContext.bluePlayer.y += this.gamePanelContext.bluePlayer.speed;
                }
                if (this.gamePanelContext.keySets.contains(KeySet.A)) {
                    this.gamePanelContext.bluePlayer.nowDirection = Direction.LEFT;
                    this.gamePanelContext.bluePlayer.x -= this.gamePanelContext.bluePlayer.speed;
                }
                if (this.gamePanelContext.keySets.contains(KeySet.D)) {
                    this.gamePanelContext.bluePlayer.nowDirection = Direction.RIGHT;
                    this.gamePanelContext.bluePlayer.x += this.gamePanelContext.bluePlayer.speed;
                }

                // 红方角色控制
                if (this.gamePanelContext.keySets.contains(KeySet.UP)) {
                    this.gamePanelContext.redPlayer.nowDirection = Direction.UP;
                    this.gamePanelContext.redPlayer.y -= this.gamePanelContext.redPlayer.speed;
                }
                if (this.gamePanelContext.keySets.contains(KeySet.DOWN)) {
                    this.gamePanelContext.redPlayer.nowDirection = Direction.DOWN;
                    this.gamePanelContext.redPlayer.y += this.gamePanelContext.redPlayer.speed;
                }
                if (this.gamePanelContext.keySets.contains(KeySet.LEFT)) {
                    this.gamePanelContext.redPlayer.nowDirection = Direction.LEFT;
                    this.gamePanelContext.redPlayer.x -= this.gamePanelContext.redPlayer.speed;
                }
                if (this.gamePanelContext.keySets.contains(KeySet.RIGHT)) {
                    this.gamePanelContext.redPlayer.nowDirection = Direction.RIGHT;
                    this.gamePanelContext.redPlayer.x += this.gamePanelContext.redPlayer.speed;
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}