package com.techotaku.utils;

import com.techotaku.GamePanel;
import com.techotaku.PlayerElement;
import com.techotaku.enums.Direction;
import com.techotaku.listeners.MyKeyListener;
import com.techotaku.threads.KeyListenerRunnable;
import com.techotaku.threads.PaintRunnable;

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
        this.gamePanelContext.keySets = new HashSet<>();
        this.gamePanelContext.propsSet = new HashSet<>();
        userInit();
        mapInit();
        threadInit();
        eventInit();
    }

    private void eventInit() {
        // 获得焦点事件
        this.gamePanelContext.setFocusable(true);
        MyKeyListener myKeyListener = new MyKeyListener(this.gamePanelContext);
        this.gamePanelContext.addKeyListener(myKeyListener);
    }


    private void threadInit() {
        // 初始化按键监听线程
        KeyListenerRunnable keyListenerRunnable = new KeyListenerRunnable(this.gamePanelContext);
        Thread keyListenerThread = new Thread(keyListenerRunnable);
        keyListenerThread.start();

        // 绘图线程
        PaintRunnable paintRunnable = new PaintRunnable(this.gamePanelContext);
        Thread paintThread = new Thread(paintRunnable);
        paintThread.start();
    }


    private void mapInit() {

    }

    private void userInit() {
        this.gamePanelContext.bluePlayer = new PlayerElement(0,0);
        this.gamePanelContext.bluePlayer.setNowDirection(Direction.RIGHT);
        this.gamePanelContext.bluePlayer.speed = 5;
        this.gamePanelContext.bluePlayer.hp = 100;


        this.gamePanelContext.redPlayer = new PlayerElement(500,500);
        this.gamePanelContext.redPlayer.setNowDirection(Direction.LEFT);
        this.gamePanelContext.redPlayer.speed = 5;
        this.gamePanelContext.redPlayer.hp = 100;
    }
}
