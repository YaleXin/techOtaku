package com.techotaku;


import com.techotaku.threads.GameMusicPlayer;
import com.techotaku.timertasks.MyPlayerTimerTask;

import javax.swing.*;

/**
 *Author: techOtaku
 */
/**
 * 泡泡堂主启动类
 */
public class StartGame {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setBounds(10,10,1000,700);
        jFrame.setResizable(false);
        GamePanel gamePanel = new GamePanel();
        // 第一关
        jFrame.add(gamePanel);
        jFrame.setVisible(true);
    }
}
