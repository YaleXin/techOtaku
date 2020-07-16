package com.techotaku.threads;

import com.techotaku.GamePanel;

/**
 *Author: techOtaku
 */

/**
 * 暂时弃用
 */
@Deprecated
public class PaintRunnable implements Runnable{
    GamePanel gamePanelContext = null;

    public PaintRunnable(GamePanel gamePanelContext) {
        this.gamePanelContext = gamePanelContext;
    }
    @Override
    public void run() {
        // 当游戏不结束就不断刷新页面
            while (!this.gamePanelContext.isEnd){
                try {
                    Thread.sleep(40);
                    this.gamePanelContext.repaint();
//                    System.out.println("重新绘制啦~~~");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
    }
}
