package com.techotaku.utils;

import com.techotaku.GamePanel;
import com.techotaku.elements.DestructibleObstacleElement;
import com.techotaku.elements.FireElement;
import com.techotaku.elements.PlayerElement;
import com.techotaku.enums.Direction;
import com.techotaku.listeners.GameKeyListener;

import com.techotaku.listeners.MyActionListener;
import com.techotaku.threads.GameMusicPlayer;
import com.techotaku.threads.KeyListenerRunnable;

import com.techotaku.elements.WallElement;
import com.techotaku.threads.PlayerInvincibleRunnable;
import com.techotaku.timertasks.MyPaintTimerTask;


import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 *Author: techOtaku
 */

/**
 * 将游戏初始化类
 */
public class InitTool {
    GamePanel gamePanelContext = null;
    public InitTool(GamePanel gamePanelContext) {
        this.gamePanelContext = gamePanelContext;
    }
    public void gameInit(){
        this.gamePanelContext.isEnd = false;
        this.gamePanelContext.keySets = new HashSet<>();
        this.gamePanelContext.propsElements = new CopyOnWriteArrayList<>();
//        this.gamePanelContext.propsElements = new ArrayList<>();
        this.gamePanelContext.wallElements = new ArrayList<>();
        this.gamePanelContext.bombElements = new CopyOnWriteArrayList<>();
//        this.gamePanelContext.bombElements = new ArrayList<>();
//        this.gamePanelContext.fireElements = new ArrayList<>();
//        this.gamePanelContext.fireElements = new Vector<>();
        this.gamePanelContext.fireElements = new CopyOnWriteArrayList<>();
//        this.gamePanelContext.destructibleObstacleElements = new ArrayList<>();
        this.gamePanelContext.destructibleObstacleElements = new CopyOnWriteArrayList<>();
        userInit();
        mapInit();
        threadInit();
        eventInit();
    }

    private void eventInit() {
        // 定时器 以 ms 为单位 delay：执行间隔
        Timer timer = new Timer(25, new MyActionListener(this.gamePanelContext));
        timer.start();
        // 改用定时器方式，避免加锁
        java.util.Timer timer1 = new java.util.Timer();
        timer1.schedule(new MyPaintTimerTask(this.gamePanelContext),0,40);

        // 获得焦点事件
        this.gamePanelContext.setFocusable(true);
        GameKeyListener myKeyListener = new GameKeyListener(this.gamePanelContext);
        this.gamePanelContext.addKeyListener(myKeyListener);
    }


    private void threadInit() {
        // 背景音乐线程
        GameMusicPlayer musicPlayer = new GameMusicPlayer();
        musicPlayer.start();


        // 初始化按键监听线程
        KeyListenerRunnable keyListenerRunnable = new KeyListenerRunnable(this.gamePanelContext);
        Thread keyListenerThread = new Thread(keyListenerRunnable);
        keyListenerThread.start();


        // 玩家无敌状态修改线程
        PlayerInvincibleRunnable playerInvincibleRunnable = new PlayerInvincibleRunnable(this.gamePanelContext);
        Thread playerInvincibleThread = new Thread(playerInvincibleRunnable);
        playerInvincibleThread.start();

        // 绘图线程
//        PaintRunnable paintRunnable = new PaintRunnable(this.gamePanelContext);
//        Thread paintThread = new Thread(paintRunnable);
//        paintThread.start();

    }


    private void mapInit() {
        // 初始化墙体
        this.gamePanelContext.wallElements.add(new WallElement(50, 50));
        this.gamePanelContext.wallElements.add(new WallElement(100, 50));
        this.gamePanelContext.wallElements.add(new WallElement(150, 50));
        this.gamePanelContext.wallElements.add(new WallElement(250, 50));
        this.gamePanelContext.wallElements.add(new WallElement(300, 50));
        this.gamePanelContext.wallElements.add(new WallElement(400, 50));
        this.gamePanelContext.wallElements.add(new WallElement(450, 50));
        this.gamePanelContext.wallElements.add(new WallElement(550, 50));
        this.gamePanelContext.wallElements.add(new WallElement(600, 50));
        this.gamePanelContext.wallElements.add(new WallElement(650, 50));
        this.gamePanelContext.wallElements.add(new WallElement(100, 100));
        this.gamePanelContext.wallElements.add(new WallElement(600, 100));
        this.gamePanelContext.wallElements.add(new WallElement(0, 150));
        this.gamePanelContext.wallElements.add(new WallElement(200, 150));
        this.gamePanelContext.wallElements.add(new WallElement(250, 150));
        this.gamePanelContext.wallElements.add(new WallElement(300, 150));
        this.gamePanelContext.wallElements.add(new WallElement(400, 150));
        this.gamePanelContext.wallElements.add(new WallElement(450, 150));
        this.gamePanelContext.wallElements.add(new WallElement(500, 150));
        this.gamePanelContext.wallElements.add(new WallElement(700, 150));
        this.gamePanelContext.wallElements.add(new WallElement(0, 200));
        this.gamePanelContext.wallElements.add(new WallElement(50, 200));
        this.gamePanelContext.wallElements.add(new WallElement(100, 200));
        this.gamePanelContext.wallElements.add(new WallElement(200, 200));
        this.gamePanelContext.wallElements.add(new WallElement(500, 200));
        this.gamePanelContext.wallElements.add(new WallElement(600, 200));
        this.gamePanelContext.wallElements.add(new WallElement(650, 200));
        this.gamePanelContext.wallElements.add(new WallElement(700, 200));
        this.gamePanelContext.wallElements.add(new WallElement(200, 250));
        this.gamePanelContext.wallElements.add(new WallElement(500, 250));
        this.gamePanelContext.wallElements.add(new WallElement(50, 300));
        this.gamePanelContext.wallElements.add(new WallElement(100, 300));
        this.gamePanelContext.wallElements.add(new WallElement(600, 300));
        this.gamePanelContext.wallElements.add(new WallElement(650, 300));

        this.gamePanelContext.wallElements.add(new WallElement(200, 350));
        this.gamePanelContext.wallElements.add(new WallElement(500, 350));
        this.gamePanelContext.wallElements.add(new WallElement(0, 400));
        this.gamePanelContext.wallElements.add(new WallElement(50, 400));
        this.gamePanelContext.wallElements.add(new WallElement(100, 400));
        this.gamePanelContext.wallElements.add(new WallElement(200, 400));
        this.gamePanelContext.wallElements.add(new WallElement(500, 400));
        this.gamePanelContext.wallElements.add(new WallElement(600, 400));
        this.gamePanelContext.wallElements.add(new WallElement(650, 400));
        this.gamePanelContext.wallElements.add(new WallElement(700, 400));
        this.gamePanelContext.wallElements.add(new WallElement(0, 450));
        this.gamePanelContext.wallElements.add(new WallElement(200, 450));
        this.gamePanelContext.wallElements.add(new WallElement(250, 450));
        this.gamePanelContext.wallElements.add(new WallElement(300, 450));
        this.gamePanelContext.wallElements.add(new WallElement(400, 450));
        this.gamePanelContext.wallElements.add(new WallElement(450, 450));
        this.gamePanelContext.wallElements.add(new WallElement(500, 450));
        this.gamePanelContext.wallElements.add(new WallElement(700, 450));
        this.gamePanelContext.wallElements.add(new WallElement(100, 500));
        this.gamePanelContext.wallElements.add(new WallElement(600, 500));
        this.gamePanelContext.wallElements.add(new WallElement(50, 550));
        this.gamePanelContext.wallElements.add(new WallElement(100, 550));
        this.gamePanelContext.wallElements.add(new WallElement(150, 550));
        this.gamePanelContext.wallElements.add(new WallElement(250, 550));
        this.gamePanelContext.wallElements.add(new WallElement(300, 550));
        this.gamePanelContext.wallElements.add(new WallElement(400, 550));
        this.gamePanelContext.wallElements.add(new WallElement(450, 550));
        this.gamePanelContext.wallElements.add(new WallElement(550, 550));
        this.gamePanelContext.wallElements.add(new WallElement(600, 550));
        this.gamePanelContext.wallElements.add(new WallElement(650, 550));

        // 初始化可破坏障碍物
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(200, 0));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(250, 0));

        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(0, 100));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(250, 100));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(550, 100));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(650, 100));

        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(50, 150));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(100, 150));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(150, 150));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(650, 150));

        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(150, 200));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(250, 200));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(300, 200));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(400, 200));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(450, 200));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(550, 200));

        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(0, 250));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(450, 250));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(550, 250));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(650, 250));

        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(450,350));

        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(150, 400));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(250, 400));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(450, 400));


        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(50, 450));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(100, 450));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(150, 450));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(350, 450));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(550, 450));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(600, 450));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(650, 450));

        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(0, 500));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(50, 500));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(200, 500));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(300, 500));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(350, 500));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(450, 500));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(500, 500));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(550, 500));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(650, 500));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(700, 500));

        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(200, 550));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(350, 550));

        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(200, 600));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(450, 600));
        //绿
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(100, 0));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(150, 0));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(350, 0));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(400, 0));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(450, 0));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(550, 0));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(600, 0));

        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(350, 50));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(500, 50));

        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(50, 100));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(200, 100));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(300, 100));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(350, 100));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(450, 100));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(500, 100));

        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(650, 150));

        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(50, 250));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(100, 250));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(600, 250));

        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(0, 300));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(150, 300));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(250, 300));

        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(0, 350));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(50, 350));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(100, 350));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(550, 350));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(600, 350));

        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(300, 400));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(350, 400));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(450, 400));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(550, 400));

        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(150, 500));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(250, 500));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(400, 500));


        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(150, 600));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(200, 600));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(250, 600));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(300, 600));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(400, 600));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(500, 600));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(550, 600));
        this.gamePanelContext.destructibleObstacleElements.add(new  DestructibleObstacleElement(600, 600));
    }

    private void userInit() {
        this.gamePanelContext.bluePlayer = new PlayerElement(0,0);
        this.gamePanelContext.bluePlayer.setNowDirection(Direction.RIGHT);
        this.gamePanelContext.bluePlayer.speed = 5;
        this.gamePanelContext.bluePlayer.hp = 100;
        this.gamePanelContext.bluePlayer.bombNum = 10;
        this.gamePanelContext.bluePlayer.isInvincible = false;
        this.gamePanelContext.bluePlayer.invincibleTime = 0;

        this.gamePanelContext.redPlayer = new PlayerElement(700,600);
        this.gamePanelContext.redPlayer.setNowDirection(Direction.LEFT);
        this.gamePanelContext.redPlayer.speed = 5;
        this.gamePanelContext.redPlayer.hp = 100;
        this.gamePanelContext.redPlayer.bombNum = 10;
        this.gamePanelContext.redPlayer.isInvincible = false;
        this.gamePanelContext.redPlayer.invincibleTime = 0;
    }
}
