package com.techotaku.utils;

import com.techotaku.GamePanel;
import com.techotaku.elements.DestructibleObstacleElement;
import com.techotaku.elements.PlayerElement;
import com.techotaku.enums.Direction;
import com.techotaku.listeners.GameKeyListener;

import com.techotaku.listeners.MyActionListener;
import com.techotaku.threads.KeyListenerRunnable;

import com.techotaku.elements.WallElement;
import com.techotaku.timertasks.MyPaintTimerTask;


import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;


/**
 * Author：Yalexin
 * Email： 181303209@yzu.edu.cn
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
        this.gamePanelContext.propsElements = new ArrayList<>();
        this.gamePanelContext.wallElements = new ArrayList<>();
        this.gamePanelContext.bombElements = new ArrayList<>();
        this.gamePanelContext.fireElements = new ArrayList<>();
        this.gamePanelContext.destructibleObstacleElements = new ArrayList<>();

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
        // 初始化按键监听线程
        KeyListenerRunnable keyListenerRunnable = new KeyListenerRunnable(this.gamePanelContext);
        Thread keyListenerThread = new Thread(keyListenerRunnable);
        keyListenerThread.start();

        // 绘图线程
//        PaintRunnable paintRunnable = new PaintRunnable(this.gamePanelContext);
//        Thread paintThread = new Thread(paintRunnable);
//        paintThread.start();

    }


    private void mapInit() {
        // 初始化墙体
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
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(100,0));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(150,0));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(200,0));
        this.gamePanelContext.destructibleObstacleElements.add(new DestructibleObstacleElement(250,0));
    }

    private void userInit() {
        this.gamePanelContext.bluePlayer = new PlayerElement(0,0);
        this.gamePanelContext.bluePlayer.setNowDirection(Direction.RIGHT);
        this.gamePanelContext.bluePlayer.speed = 5;
        this.gamePanelContext.bluePlayer.hp = 100;
        this.gamePanelContext.bluePlayer.bombNum = 10;
        this.gamePanelContext.bluePlayer.isInvincible = false;

        this.gamePanelContext.redPlayer = new PlayerElement(700,600);
        this.gamePanelContext.redPlayer.setNowDirection(Direction.LEFT);
        this.gamePanelContext.redPlayer.speed = 5;
        this.gamePanelContext.redPlayer.hp = 100;
        this.gamePanelContext.redPlayer.bombNum = 10;
        this.gamePanelContext.redPlayer.isInvincible = false;
    }
}
