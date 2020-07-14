package com.yalexin.bomb;


import javax.swing.*;

/**
 * Author：Yalexin
 * Email： 181303209@yzu.edu.cn
 */

/**
 * 泡泡堂主启动类
 */
public class StartGame {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setBounds(10,10,770,750);
        jFrame.setResizable(false);
        GamePanel gamePanel = new GamePanel();
        // 第一关
        jFrame.add(gamePanel);
        jFrame.setVisible(true);
        // 正常的游戏界面都是在面板上面的
    }
}
