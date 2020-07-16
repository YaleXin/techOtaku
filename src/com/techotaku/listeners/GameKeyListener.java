package com.techotaku.listeners;

import com.techotaku.GamePanel;
import com.techotaku.elements.BombElement;
import com.techotaku.enums.KeySet;
import com.techotaku.enums.Music;
import com.techotaku.threads.GameShortMusicRunnable;
import com.techotaku.timertasks.MyBombDecTimerTask;
import com.techotaku.timertasks.MyBombDisappearTimerTask;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

/**
 *Author: techOtaku
 */
public class GameKeyListener implements KeyListener {
    GamePanel gamePanelContext = null;

    public GameKeyListener(GamePanel gamePanelContext) {
        this.gamePanelContext = gamePanelContext;
    }

    @Override
    public void keyPressed(KeyEvent e) {//按着键将对应键的参数加入keysets中
        // TODO Auto-generated method stub
        int code = e.getKeyCode();
        switch (code) {
            case 87://W
                gamePanelContext.keySets.add(KeySet.W);
                break;

            case 83://S
                gamePanelContext.keySets.add(KeySet.S);
                break;

            case 65://A
                gamePanelContext.keySets.add(KeySet.A);
                break;

            case 68://D
                gamePanelContext.keySets.add(KeySet.D);
                break;
//            case 70://F
//                gamePanelContext.keySets.add(KeySet.F);
//                break;

            case 38://↑
                gamePanelContext.keySets.add(KeySet.UP);
                break;

            case 40://↓
                gamePanelContext.keySets.add(KeySet.DOWN);
                break;

            case 37://←
                gamePanelContext.keySets.add(KeySet.LEFT);
                break;

            case 39://→
                gamePanelContext.keySets.add(KeySet.RIGHT);
                break;

//            case 16: //SHIFT
//                gamePanelContext.keySets.add(KeySet.SHIFT);
//                break;

            default://其它按键无视
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {//松开键将对应键的参数从keysets中移除
        // TODO Auto-generated method stub
        int code = e.getKeyCode();
        if (!this.gamePanelContext.isEnd) {
            switch (code) {
                case 87://W
                    gamePanelContext.keySets.remove(KeySet.W);
                    break;

                case 83://S
                    gamePanelContext.keySets.remove(KeySet.S);
                    break;

                case 65://A
                    gamePanelContext.keySets.remove(KeySet.A);
                    break;

                case 68://D
                    gamePanelContext.keySets.remove(KeySet.D);
                    break;

//            case 70://F
//                gamePanelContext.keySets.remove(KeySet.F);
//                break;

                case 38://↑
                    gamePanelContext.keySets.remove(KeySet.UP);
                    break;

                case 40://↓
                    gamePanelContext.keySets.remove(KeySet.DOWN);
                    break;

                case 37://←
                    gamePanelContext.keySets.remove(KeySet.LEFT);
                    break;

                case 39://→
                    gamePanelContext.keySets.remove(KeySet.RIGHT);
                    break;

//            case 16: //SHIFT
//                gamePanelContext.keySets.add(KeySet.SHIFT);
//                break;
                default://其它按键无视
                    break;
            }
            // 蓝方角色放炸弹
            if (code == KeyEvent.VK_F) {
                System.out.println("FFFF");
                if (this.gamePanelContext.bluePlayer.bombNum > 0) {
                    int x = this.gamePanelContext.bluePlayer.x;
                    int y = this.gamePanelContext.bluePlayer.y;
                    this.gamePanelContext.bluePlayer.bombNum--;
                    BombElement bombElement = new BombElement(x, y);
                    this.gamePanelContext.bombElements.add(bombElement);
                    System.out.println("添加了");
                    MyBombDisappearTimerTask myBombDisappearTimerTask = new MyBombDisappearTimerTask(this.gamePanelContext, bombElement);
                    Timer timer = new Timer();
                    // 音效线程
                    GameShortMusicRunnable gameShortMusicRunnable = new GameShortMusicRunnable(Music.RELEASE);
                    Thread thread = new Thread(gameShortMusicRunnable);
                    thread.start();
                    // 3秒钟后爆炸
                    timer.schedule(myBombDisappearTimerTask, 3000);
                    // 5秒钟后炸弹数加一
                    timer.schedule(new MyBombDecTimerTask(this.gamePanelContext.bluePlayer), 5000);
                }
            }
            // 红方角色放炸弹
            if (code == KeyEvent.VK_M) {
                System.out.println("MMMM");
                if (this.gamePanelContext.redPlayer.bombNum > 0) {
                    int x = this.gamePanelContext.redPlayer.x;
                    int y = this.gamePanelContext.redPlayer.y;
                    this.gamePanelContext.redPlayer.bombNum--;
                    BombElement bombElement = new BombElement(x, y);
                    this.gamePanelContext.bombElements.add(bombElement);
                    System.out.println("添加了");
                    MyBombDisappearTimerTask myBombDisappearTimerTask = new MyBombDisappearTimerTask(this.gamePanelContext, bombElement);
                    Timer timer = new Timer();
                    // 音效线程
                    GameShortMusicRunnable gameShortMusicRunnable = new GameShortMusicRunnable(Music.RELEASE);
                    Thread thread = new Thread(gameShortMusicRunnable);
                    thread.start();
                    // 3秒钟后爆炸
                    timer.schedule(myBombDisappearTimerTask, 3000);
                    // 5秒钟后炸弹数加一
                    timer.schedule(new MyBombDecTimerTask(this.gamePanelContext.redPlayer), 5000);
                }
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }
}
