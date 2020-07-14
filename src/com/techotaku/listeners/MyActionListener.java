package com.techotaku.listeners;

import com.techotaku.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

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
    }
}
