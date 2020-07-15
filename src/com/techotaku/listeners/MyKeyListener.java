package com.techotaku.listeners;

import com.techotaku.GamePanel;
import com.techotaku.elements.BombElement;
import com.techotaku.enums.KeySet;
import com.techotaku.timertasks.MyBombDecTimerTask;
import com.techotaku.timertasks.MyBombDisappearTimerTask;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

/**
 * Author：Yalexin
 * Email： 181303209@yzu.edu.cn
 */
public class MyKeyListener extends KeyAdapter {
    GamePanel gamePanelContext = null;

    public MyKeyListener(GamePanel gamePanelContext) {
        this.gamePanelContext = gamePanelContext;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下了");
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W) {
            this.gamePanelContext.keySets.add(KeySet.W);
        } else if (keyCode == KeyEvent.VK_S) {
            this.gamePanelContext.keySets.add(KeySet.S);
        } else if (keyCode == KeyEvent.VK_A) {
            this.gamePanelContext.keySets.add(KeySet.A);
        } else if (keyCode == KeyEvent.VK_D) {
            this.gamePanelContext.keySets.add(KeySet.D);
        } else if (keyCode == KeyEvent.VK_UP) {
            this.gamePanelContext.keySets.add(KeySet.UP);
        } else if (keyCode == KeyEvent.VK_DOWN) {
            this.gamePanelContext.keySets.add(KeySet.DOWN);
        } else if (keyCode == KeyEvent.VK_LEFT) {
            this.gamePanelContext.keySets.add(KeySet.LEFT);
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            this.gamePanelContext.keySets.add(KeySet.RIGHT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开了");
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W) {
            this.gamePanelContext.keySets.remove(KeySet.W);
        } else if (keyCode == KeyEvent.VK_S) {
            this.gamePanelContext.keySets.remove(KeySet.S);
        } else if (keyCode == KeyEvent.VK_A) {
            this.gamePanelContext.keySets.remove(KeySet.A);
        } else if (keyCode == KeyEvent.VK_D) {
            this.gamePanelContext.keySets.remove(KeySet.D);
        } else if (keyCode == KeyEvent.VK_UP) {
            this.gamePanelContext.keySets.remove(KeySet.UP);
        } else if (keyCode == KeyEvent.VK_DOWN) {
            this.gamePanelContext.keySets.remove(KeySet.DOWN);
        } else if (keyCode == KeyEvent.VK_LEFT) {
            this.gamePanelContext.keySets.remove(KeySet.LEFT);
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            this.gamePanelContext.keySets.remove(KeySet.RIGHT);
        } else if (keyCode == KeyEvent.VK_F) {
            // 蓝角色释放炸弹
            if (this.gamePanelContext.bluePlayer.bombNum > 0) {
                this.gamePanelContext.bluePlayer.bombNum--;
                int x = this.gamePanelContext.bluePlayer.x;
                int y = this.gamePanelContext.bluePlayer.y;
                BombElement bombElement = new BombElement(x,y);
                Timer timer = new Timer();
                Timer timer1 = new Timer();
                System.out.println("开启定时器");
                // 3秒钟后爆炸
                timer.schedule(new MyBombDisappearTimerTask(this.gamePanelContext,bombElement),3000);
                // 5秒钟后炸弹数加一
                timer1.schedule(new MyBombDecTimerTask(this.gamePanelContext.bluePlayer),1000);
            }
        }


    }
}
