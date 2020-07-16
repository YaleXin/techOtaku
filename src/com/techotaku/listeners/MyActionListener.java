package com.techotaku.listeners;

import com.techotaku.GamePanel;
import com.techotaku.elements.FireElement;
import com.techotaku.elements.PropsElement;
import com.techotaku.enums.Props;


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
                    // 受伤后，3秒钟内无敌
                    this.gamePanelContext.redPlayer.invincibleTime = 3;
                }
            }
            if (next.intersects(this.gamePanelContext.bluePlayer)) {
                if (this.gamePanelContext.bluePlayer.invincibleTime <= 0) {
                    this.gamePanelContext.bluePlayer.hp -= 50;
                    // 受伤后，3秒钟内无敌
                    this.gamePanelContext.bluePlayer.invincibleTime = 3;
                }
            }
        }


//        for (FireElement fire :
//                this.gamePanelContext.fireElements) {
//            if (fire.intersects(this.gamePanelContext.redPlayer)) {
//                if (this.gamePanelContext.redPlayer.invincibleTime <= 0) {
//                    this.gamePanelContext.redPlayer.hp -= 50;
//                    // 受伤后，3秒钟内无敌
//                    this.gamePanelContext.redPlayer.invincibleTime = 3;
////                    Timer timer = new Timer();
////                    timer.schedule(new MyPlayerTimerTask(this.gamePanelContext.redPlayer), 3000);
//                }
//            }
//        }


//        for (FireElement fire :
//                this.gamePanelContext.fireElements) {
//            if (fire.intersects(this.gamePanelContext.bluePlayer)) {
//                if (this.gamePanelContext.bluePlayer.invincibleTime <= 0) {
//                    this.gamePanelContext.bluePlayer.hp -= 50;
//                    // 受伤后，无敌时间增加3秒钟
//                    this.gamePanelContext.bluePlayer.invincibleTime = 3;
////                    Timer timer = new Timer();
////                    timer.schedule(new MyPlayerTimerTask(this.gamePanelContext.bluePlayer), 3000);
//                }
//            }
//        }

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
                this.gamePanelContext.propsElements.remove(next);
            }

        }


//        for (int i = 0; i < this.gamePanelContext.propsElements.size(); ) {
//            PropsElement props = this.gamePanelContext.propsElements.get(i);
//            // 蓝玩家吃到道具
//            if (props.intersects(this.gamePanelContext.bluePlayer)) {
//                if (props.type == Props.BLOOD_BOTTLE) {
//                    // 血瓶加 100 的血量
//                    this.gamePanelContext.bluePlayer.hp += 100;
//                } else if (props.type == Props.SHIELDING) {
//                    // 防护罩 加 5秒无敌时间
//                    this.gamePanelContext.bluePlayer.invincibleTime += 5;
//                }
//                this.gamePanelContext.propsElements.remove(props);
//                // 红玩家吃到道具
//            } else if (props.intersects(this.gamePanelContext.redPlayer)) {
//                if (props.type == Props.BLOOD_BOTTLE) {
//                    // 血瓶加 100 的血量
//                    this.gamePanelContext.redPlayer.hp += 100;
//                } else if (props.type == Props.SHIELDING) {
//                    // 防护罩 加 5秒无敌时间
//                    this.gamePanelContext.redPlayer.invincibleTime += 5;
//                }
//                this.gamePanelContext.propsElements.remove(props);
//            } else {
//                i++;
//            }
//        }
    }
}
