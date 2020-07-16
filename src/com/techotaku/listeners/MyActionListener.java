package com.techotaku.listeners;

import com.techotaku.GamePanel;
import com.techotaku.elements.FireElement;
import com.techotaku.elements.PropsElement;
import com.techotaku.enums.Music;
import com.techotaku.enums.Props;
import com.techotaku.threads.GameShortMusicRunnable;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Iterator;


/**
 *Author: techOtaku
 */
public class MyActionListener implements ActionListener {
    GamePanel gamePanelContext = null;

    public MyActionListener(GamePanel gamePanelContext) {
        this.gamePanelContext = gamePanelContext;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Iterator<FireElement> firesIt = this.gamePanelContext.fireElements.iterator();
        while (firesIt.hasNext()) {
            FireElement next = firesIt.next();
            if (next.intersects(this.gamePanelContext.redPlayer)) {
                if (this.gamePanelContext.redPlayer.invincibleTime <= 0) {
                    this.gamePanelContext.redPlayer.hp -= 50;
                    // 音效线程
                    GameShortMusicRunnable gameShortMusicRunnable = new GameShortMusicRunnable(Music.BURNS);
                    Thread thread = new Thread(gameShortMusicRunnable);
                    thread.start();

                    // 受伤后，5秒钟内无敌
                    this.gamePanelContext.redPlayer.invincibleTime = 5;
                }
            }
            if (next.intersects(this.gamePanelContext.bluePlayer)) {
                if (this.gamePanelContext.bluePlayer.invincibleTime <= 0) {
                    this.gamePanelContext.bluePlayer.hp -= 50;

                    // 音效线程
                    GameShortMusicRunnable gameShortMusicRunnable = new GameShortMusicRunnable(Music.BURNS);
                    Thread thread = new Thread(gameShortMusicRunnable);
                    thread.start();

                    // 受伤后，5秒钟内无敌
                    this.gamePanelContext.bluePlayer.invincibleTime = 5;
                }
            }
        }


        if (this.gamePanelContext.bluePlayer.hp <= 0 || this.gamePanelContext.redPlayer.hp <= 0) {
            this.gamePanelContext.isEnd = true;
        }


        Iterator<PropsElement> propsesIt = this.gamePanelContext.propsElements.iterator();
        while (propsesIt.hasNext()) {
            PropsElement next = propsesIt.next();

            // 蓝玩家吃到道具
            if (next.intersects(this.gamePanelContext.bluePlayer)) {
                if (next.type == Props.BLOOD_BOTTLE) {
                    // 血瓶加 100 的血量
                    this.gamePanelContext.bluePlayer.hp += 100;
                } else if (next.type == Props.SHIELDING) {
                    // 防护罩 加 5秒无敌时间
                    this.gamePanelContext.bluePlayer.invincibleTime += 5;
                }
                // 音效线程
                GameShortMusicRunnable gameShortMusicRunnable = new GameShortMusicRunnable(Music.GET_PROPS);
                Thread thread = new Thread(gameShortMusicRunnable);
                thread.start();
                // 道具消失
                this.gamePanelContext.propsElements.remove(next);
                // 红玩家吃到道具
            } else if (next.intersects(this.gamePanelContext.redPlayer)) {
                if (next.type == Props.BLOOD_BOTTLE) {
                    // 血瓶加 100 的血量
                    this.gamePanelContext.redPlayer.hp += 100;
                } else if (next.type == Props.SHIELDING) {
                    // 防护罩 加 5秒无敌时间
                    this.gamePanelContext.redPlayer.invincibleTime += 5;
                }
                // 音效线程
                GameShortMusicRunnable gameShortMusicRunnable = new GameShortMusicRunnable(Music.GET_PROPS);
                Thread thread = new Thread(gameShortMusicRunnable);
                thread.start();
                // 道具消失
                this.gamePanelContext.propsElements.remove(next);
            }

        }
    }
}
