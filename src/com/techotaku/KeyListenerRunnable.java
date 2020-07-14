package com.techotaku;

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
        // 蓝方角色控制
        if (this.gamePanelContext.keySets.contains(KeySet.W)){
            this.gamePanelContext.bluePlayer.nowDirection = Direction.UP;
        }
        if (this.gamePanelContext.keySets.contains(KeySet.S)){
            this.gamePanelContext.bluePlayer.nowDirection = Direction.DOWN;
        }
        if (this.gamePanelContext.keySets.contains(KeySet.A)){
            this.gamePanelContext.bluePlayer.nowDirection = Direction.LEFT;
        }
        if (this.gamePanelContext.keySets.contains(KeySet.D)){
            this.gamePanelContext.bluePlayer.nowDirection = Direction.RIGHT;
        }

    }
}