package com.techotaku.threads;

import com.techotaku.GamePanel;

/**
 * Author：Yalexin
 * Email： 181303209@yzu.edu.cn
 */
public class PaintRunnable implements Runnable{
    GamePanel gamePanelContext = null;

    public PaintRunnable(GamePanel gamePanelContext) {
        this.gamePanelContext = gamePanelContext;
    }
    @Override
    public void run() {
            while (true){
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
