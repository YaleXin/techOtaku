package com.techotaku.listeners;

import com.techotaku.GamePanel;
import com.techotaku.elements.FireElement;
import com.techotaku.elements.PropsElement;
import com.techotaku.timertasks.MyPlayerTimerTask;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.Timer;

/**
 * Author：Yalexin
 * Email： 181303209@yzu.edu.cn
 */
public class MyActionListener implements ActionListener {
    GamePanel gamePanelContext = null;

    public MyActionListener(GamePanel gamePanelContext) {
        this.gamePanelContext = gamePanelContext;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (FireElement fire :
                this.gamePanelContext.fireElements) {
            if (fire.intersects(this.gamePanelContext.redPlayer)) {
                if (!this.gamePanelContext.redPlayer.isInvincible) {
                    this.gamePanelContext.redPlayer.hp -= 50;
                    // 受伤后，3秒钟内无敌
                    this.gamePanelContext.redPlayer.isInvincible = true;
                    Timer timer = new Timer();
                    timer.schedule(new MyPlayerTimerTask(this.gamePanelContext.redPlayer), 3000);
                }
            }
        }
        for (FireElement fire :
                this.gamePanelContext.fireElements) {
            if (fire.intersects(this.gamePanelContext.bluePlayer)) {
                if (!this.gamePanelContext.bluePlayer.isInvincible) {
                    this.gamePanelContext.bluePlayer.hp -= 50;
                    // 受伤后，3秒钟内无敌
                    this.gamePanelContext.bluePlayer.isInvincible = true;
                    Timer timer = new Timer();
                    timer.schedule(new MyPlayerTimerTask(this.gamePanelContext.bluePlayer), 3000);
                }
            }
        }

        if (this.gamePanelContext.bluePlayer.hp <= 0 || this.gamePanelContext.redPlayer.hp <= 0) {
            this.gamePanelContext.isEnd = true;
        }


        for (int i = 0 ;i < this.gamePanelContext.propsElements.size();) {
            PropsElement props = this.gamePanelContext.propsElements.get(i);
            if (props.intersects(this.gamePanelContext.bluePlayer)){
                this.gamePanelContext.bluePlayer.hp += 100;
                this.gamePanelContext.propsElements.remove(props);
            }else if (props.intersects(this.gamePanelContext.redPlayer)){
                this.gamePanelContext.redPlayer.hp += 100;
                this.gamePanelContext.propsElements.remove(props);
            }else {
                i++;
            }
        }
    }
}
