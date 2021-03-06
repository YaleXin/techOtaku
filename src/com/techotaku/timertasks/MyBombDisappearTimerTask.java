package com.techotaku.timertasks;

import com.techotaku.GamePanel;
import com.techotaku.elements.BombElement;
import com.techotaku.elements.DestructibleObstacleElement;
import com.techotaku.elements.FireElement;
import com.techotaku.elements.WallElement;
import com.techotaku.enums.Music;
import com.techotaku.threads.GameShortMusicRunnable;
import com.techotaku.utils.PlayMusic;

import java.util.Timer;
import java.util.TimerTask;

/**
 *Author: techOtaku
 */
public class MyBombDisappearTimerTask extends TimerTask {
    BombElement bombElement = null;
    GamePanel gamePanelContext = null;

    public MyBombDisappearTimerTask(GamePanel gamePanelContext, BombElement bombElement) {
        this.gamePanelContext = gamePanelContext;
        this.bombElement = bombElement;
    }

    @Override
    public void run() {
        this.gamePanelContext.bombElements.remove(this.bombElement);
        // 音效线程
        GameShortMusicRunnable gameShortMusicRunnable = new GameShortMusicRunnable(Music.BOMB);
        Thread thread = new Thread(gameShortMusicRunnable);
        thread.start();
        // 炸点地点肯定产生火焰，火焰0.7秒钟后消失
        FireElement element0 = new FireElement(this.bombElement.x, this.bombElement.y);
        this.gamePanelContext.fireElements.add(element0);
        MyFireDisappearTimerTask myFireDisappearTimerTask = new MyFireDisappearTimerTask(this.gamePanelContext, element0);
        System.out.println("炸弹中心");
        Timer timer = new Timer();
        timer.schedule(myFireDisappearTimerTask, 700);

        // 观察炸弹点的上下左右，看是否有墙体，假如没有，则该点也会产生火焰
        if (this.bombElement.y - 50 >= 0) {
            boolean isOk = true;
            for (WallElement wall : this.gamePanelContext.wallElements) {
                if (wall.intersects(this.bombElement.x, this.bombElement.y - 50, 50, 50)) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                FireElement element1 = new FireElement(this.bombElement.x, this.bombElement.y - 50);
                this.gamePanelContext.fireElements.add(element1);
                MyFireDisappearTimerTask myFireDisappearTimerTask1 = new MyFireDisappearTimerTask(this.gamePanelContext, element1);
                Timer timer1 = new Timer();
                timer1.schedule(myFireDisappearTimerTask1, 700);
                System.out.println("上面");
            }
        }
        if (this.bombElement.y + 50 <= 600) {
            boolean isOk = true;
            for (WallElement wall : this.gamePanelContext.wallElements) {
                if (wall.intersects(this.bombElement.x, this.bombElement.y + 50, 50, 50)) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                FireElement element2 = new FireElement(this.bombElement.x, this.bombElement.y + 50);
                this.gamePanelContext.fireElements.add(element2);
                MyFireDisappearTimerTask myFireDisappearTimerTask2 = new MyFireDisappearTimerTask(this.gamePanelContext, element2);
                Timer timer2 = new Timer();
                timer2.schedule(myFireDisappearTimerTask2, 700);
                System.out.println("下面");
            }
        }
        if (this.bombElement.x - 50 >= 0) {
            boolean isOk = true;
            for (WallElement wall : this.gamePanelContext.wallElements) {
                if (wall.intersects(this.bombElement.x - 50, this.bombElement.y, 50, 50)) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                FireElement element3 = new FireElement(this.bombElement.x - 50, this.bombElement.y);
                this.gamePanelContext.fireElements.add(element3);
                MyFireDisappearTimerTask myFireDisappearTimerTask3 = new MyFireDisappearTimerTask(this.gamePanelContext, element3);
                Timer timer3 = new Timer();
                timer3.schedule(myFireDisappearTimerTask3, 700);
                System.out.println("左面");
            }
        }
        if (this.bombElement.x + 50 <= 700) {
            boolean isOk = true;
            for (WallElement wall : this.gamePanelContext.wallElements) {
                if (wall.intersects(this.bombElement.x + 50, this.bombElement.y, 50, 50)) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                FireElement element4 = new FireElement(this.bombElement.x + 50, this.bombElement.y);
                this.gamePanelContext.fireElements.add(element4);
                MyFireDisappearTimerTask myFireDisappearTimerTask4 = new MyFireDisappearTimerTask(this.gamePanelContext, element4);
                Timer timer4 = new Timer();
                timer4.schedule(myFireDisappearTimerTask4, 700);
                System.out.println("右面");
            }
        }
    }
}
