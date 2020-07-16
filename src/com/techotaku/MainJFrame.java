package com.techotaku;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.techotaku.threads.GameMusicPlayer;

public class MainJFrame extends JFrame{
    public void MainStart(){
        final ImageIcon bgImageIcon = new ImageIcon(MainJFrame.class.getResource("statics/startbg.png"));
        final Image image = bgImageIcon.getImage();
        final JFrame frame = new JFrame() {
            private static final long serialVersionUID = 1L;
            public void paint(Graphics g) {
                g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
            }
        };

        frame.setTitle("泡泡堂游戏,一切解释权归“techotaku”团队所有");
        frame.setSize(1000,700);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().setBackground(Color.BLUE);;


        JPanel panel = new JPanel();
        panel.setLayout(null);
        final JButton btn = new JButton();
        btn.setBounds(300, 200, 180, 80);
        ImageIcon ii = new ImageIcon(MainJFrame.class.getResource("statics/start.png"));
        ii.getImage();
        Image temp = ii.getImage().getScaledInstance(btn.getWidth(), btn.getHeight(), Image.SCALE_DEFAULT);
        ii = new ImageIcon(temp);
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setMargin(new Insets(0, 0, 0, 0));
        btn.setFocusPainted(false);
        btn.setIcon(ii);
        btn.setBorderPainted(false);
        btn.setBorder(null);
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // 点击按钮，显示游戏窗口
                if(e.getSource() == btn){
                    frame.dispose();
                    showNewWindow();
                }
            }
        });
        panel.add(btn);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    protected static void showNewWindow() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(1000,700);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setTitle("泡泡堂游戏,一切解释权归“techotaku”团队所有");
        GamePanel gamePanel = new GamePanel();
        // 第一关
        jFrame.add(gamePanel);
        jFrame.setVisible(true);
        // 正常的游戏界面都是在面板上面的
    }
}
