package com.yalexin.bomb;

import com.yalexin.bomb.enums.Direction;
import com.yalexin.bomb.threads.MyRepaintThread;
import com.yalexin.bomb.threads.MyRunnable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Author：Yalexin
 * Email： 181303209@yzu.edu.cn
 */
public class GamePanel extends JPanel {
    // 面板最大坐标
    int MAXX = 770, MAXY = 750;
     PlayerElement redPlayer;

    public void setEnd(boolean end) {
        isEnd = end;
    }

    // 使用稀疏矩阵记录墙体的坐标
    int[] walls = {
            16, 17, 18, 20, 21, 23, 24, 26, 27, 28,
            32, 42,
            45, 49, 50, 51, 53, 54, 55, 59,
            60, 61, 62, 64, 70, 72, 73, 74,
            79, 85,
            91, 92, 102, 103,
            109, 115,
            120, 121, 122, 124, 130, 132, 133, 134,
            135, 139, 140, 141, 143, 144, 145, 149,
            152, 162,
            166, 167, 168, 170, 171, 173, 174, 176, 177, 178
    };
    ArrayList<BaseElement> wallList;
    ArrayList<Point> wallsList;
    //    boolean[][] isWall = {
//            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
//            {false, true, true, true, false, true, true, false, true, true, false, true, true, true, false},
//            {false, false, true, false, false, false, false, false, false, false, false, false, true, false, false},
//            {true, false, false, false, true, true, true, false, true, true, true, false, false, false, true},
//            {true, true, true, false, true, false, false, false, false, false, true, false, true, true, true},
//            {false, false, false, false, true, false, false, false, false, false, true, false, false, false, false},
//            {false, true, true, false, false, false, false, false, false, false, false, false, true, true, false},
//            {false, false, false, false, true, false, false, false, false, false, true, false, false, false, false},
//            {true, true, true, false, true, false, false, false, false, false, true, false, true, true, true},
//            {true, false, false, false, true, true, true, false, true, true, true, false, false, false, true},
//            {false, false, true, false, false, false, false, false, false, false, false, false, true, false, false},
//            {false, true, true, true, false, true, true, false, true, true, false, true, true, true, false},
//            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
//
//
//    };
    // 可破坏障碍物
    ArrayList<BaseElement> destructibleObstacle01;

    // 角色坐标
//    int userX = 0, userY = 0;
    // 玩家一
    PlayerElement bluePlayer;
    // 蓝方角色目前方向
    Direction blueUserDirection;
    // 红方角色目前方向
    Direction redUserDirection;
    // 角色速度
    int userSpeed;
    // 炸弹集合
//    ArrayList<Point> bombList;
    ArrayList<BaseElement> bombList;
    // 火焰集合
//    ArrayList<Point> fireList;
    ArrayList<BaseElement> fireList;

    public boolean isEnd() {
        return isEnd;
    }

    // 游戏是否结束
    private boolean isEnd;

    public GamePanel() {
        // 获得焦点事件
        this.setFocusable(true);
        this.isEnd = false;
        mapInit();
        userInit();
        eventInit();
        Timer timer = new Timer();
        // 通过定时器 定时刷新面板
//        timer.schedule(new RepaintTimerTask(this),0,10);
        // 通过线程刷新面板
        Thread myRepaintThread = new Thread(new MyRunnable(this));
        myRepaintThread.start();
        //        timer.schedule();
//        Thread paintThread = new Thread(new MyRunnable(this));

//        while (true){
//            try {
//                Thread.sleep(100);
//                this.repaint();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    private void eventInit() {
        addKeyListener(new MyKeyListener(this));
    }

    private void userInit() {
        this.bluePlayer = new PlayerElement(0, 0);
        this.redPlayer = new PlayerElement(500, 500);
//        this.userX = 0;
//        this.userY = 0;
        this.blueUserDirection = Direction.RIGHT;
        this.userSpeed = 5;
    }

    private void mapInit() {
        // 初始化各种元素集合
        this.bombList = new ArrayList<BaseElement>();
        this.wallsList = new ArrayList<Point>();
//        this.fireList = new ArrayList<Point>();
        this.fireList = new ArrayList<BaseElement>();
        this.wallList = new ArrayList<BaseElement>();
        this.destructibleObstacle01 = new ArrayList<BaseElement>();
        // 墙体生成
        this.wallList.add(new BaseElement(50, 50));
        this.wallList.add(new BaseElement(100, 50));
        this.wallList.add(new BaseElement(150, 50));
        this.wallList.add(new BaseElement(250, 50));
        this.wallList.add(new BaseElement(300, 50));
        this.wallList.add(new BaseElement(400, 50));
        this.wallList.add(new BaseElement(450, 50));
        this.wallList.add(new BaseElement(550, 50));
        this.wallList.add(new BaseElement(600, 50));
        this.wallList.add(new BaseElement(650, 50));
        this.wallList.add(new BaseElement(100, 100));
        this.wallList.add(new BaseElement(600, 100));
        this.wallList.add(new BaseElement(0, 150));
        this.wallList.add(new BaseElement(200, 150));
        this.wallList.add(new BaseElement(250, 150));
        this.wallList.add(new BaseElement(300, 150));
        this.wallList.add(new BaseElement(400, 150));
        this.wallList.add(new BaseElement(450, 150));
        this.wallList.add(new BaseElement(500, 150));
        this.wallList.add(new BaseElement(700, 150));
        this.wallList.add(new BaseElement(0, 200));
        this.wallList.add(new BaseElement(50, 200));
        this.wallList.add(new BaseElement(100, 200));
        this.wallList.add(new BaseElement(200, 200));
        this.wallList.add(new BaseElement(500, 200));
        this.wallList.add(new BaseElement(600, 200));
        this.wallList.add(new BaseElement(650, 200));
        this.wallList.add(new BaseElement(700, 200));
        this.wallList.add(new BaseElement(200, 250));
        this.wallList.add(new BaseElement(500, 250));
        this.wallList.add(new BaseElement(50, 300));
        this.wallList.add(new BaseElement(100, 300));
        this.wallList.add(new BaseElement(600, 300));
        this.wallList.add(new BaseElement(650, 300));

        this.wallList.add(new BaseElement(200, 350));
        this.wallList.add(new BaseElement(500, 350));
        this.wallList.add(new BaseElement(0, 400));
        this.wallList.add(new BaseElement(50, 400));
        this.wallList.add(new BaseElement(100, 400));
        this.wallList.add(new BaseElement(200, 400));
        this.wallList.add(new BaseElement(500, 400));
        this.wallList.add(new BaseElement(600, 400));
        this.wallList.add(new BaseElement(650, 400));
        this.wallList.add(new BaseElement(700, 400));
        this.wallList.add(new BaseElement(0, 450));
        this.wallList.add(new BaseElement(200, 450));
        this.wallList.add(new BaseElement(250, 450));
        this.wallList.add(new BaseElement(300, 450));
        this.wallList.add(new BaseElement(400, 450));
        this.wallList.add(new BaseElement(450, 450));
        this.wallList.add(new BaseElement(500, 450));
        this.wallList.add(new BaseElement(700, 450));
        this.wallList.add(new BaseElement(100, 500));
        this.wallList.add(new BaseElement(600, 500));
        this.wallList.add(new BaseElement(50, 550));
        this.wallList.add(new BaseElement(100, 550));
        this.wallList.add(new BaseElement(150, 550));
        this.wallList.add(new BaseElement(250, 550));
        this.wallList.add(new BaseElement(300, 550));
        this.wallList.add(new BaseElement(400, 550));
        this.wallList.add(new BaseElement(450, 550));
        this.wallList.add(new BaseElement(550, 550));
        this.wallList.add(new BaseElement(600, 550));
        this.wallList.add(new BaseElement(650, 550));
//        wallsList.add(new Point())


        // 可破坏障碍物
        this.destructibleObstacle01.add(new BaseElement(150, 150));
        this.destructibleObstacle01.add(new BaseElement(150, 200));
        this.destructibleObstacle01.add(new BaseElement(150, 250));


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 画地板
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 14; j++) {
                Data.floor02.paintIcon(this, g, i * 50, j * 50);
            }
        // 画墙
        for (int i = 0; i < 13; i++)
            for (int j = 0; j < 15; j++) {
                for (BaseElement element :
                        wallList) {
                    Data.floor03.paintIcon(this, g, element.x, element.y);
                }
//                if (isWall[i][j]) {
//                    Data.floor03.paintIcon(this, g, j * 50, i * 50);
//                }
            }
//        int x = 0, y = 0;
//        for (int item :
//                walls) {
//            x = item % 15;
//            y = item / 15;
//            Data.floor03.paintIcon(this, g, x * 50, y * 50);
//        }


        // 画炸弹
        for (BaseElement p :
                this.bombList) {
            Data.bomb.paintIcon(this, g, p.x, p.y);
        }


        // 画可破坏障碍物一
        for (BaseElement p :
                this.destructibleObstacle01) {
            Data.destr01.paintIcon(this, g, p.x, p.y);
        }


        // 画火焰
        for (BaseElement p :
                this.fireList) {
            Data.fire.paintIcon(this, g, p.x, p.y);
        }

        if (this.isEnd()) {
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑", Font.BOLD, 20));
            g.drawString("游戏结束！", 300, 300);
            g.setColor(Color.BLACK);
        }
        //根据坐标，画红方角色
        if (this.redUserDirection == Direction.UP) {
            Data.up.paintIcon(this, g, this.redPlayer.x, this.redPlayer.y);
//            Data.up.paintIcon(this, g, this.userX, this.userY);
        } else if (this.redUserDirection == Direction.DOWN) {
            Data.down.paintIcon(this, g, this.redPlayer.x, this.redPlayer.y);
//            Data.down.paintIcon(this, g, this.userX, this.userY);
        } else if (this.redUserDirection == Direction.LEFT) {
            Data.left.paintIcon(this, g, this.redPlayer.x, this.redPlayer.y);
//            Data.left.paintIcon(this, g, this.userX, this.userY);
        } else if (this.redUserDirection == Direction.RIGHT) {
            Data.right.paintIcon(this, g, this.redPlayer.x, this.redPlayer.y);
//            Data.right.paintIcon(this, g, this.userX, this.userY);
        }

        //根据坐标，画蓝方角色
        if (this.blueUserDirection == Direction.UP) {
            Data.up.paintIcon(this, g, this.bluePlayer.x, this.bluePlayer.y);
//            Data.up.paintIcon(this, g, this.userX, this.userY);
        } else if (this.blueUserDirection == Direction.DOWN) {
            Data.down.paintIcon(this, g, this.bluePlayer.x, this.bluePlayer.y);
//            Data.down.paintIcon(this, g, this.userX, this.userY);
        } else if (this.blueUserDirection == Direction.LEFT) {
            Data.left.paintIcon(this, g, this.bluePlayer.x, this.bluePlayer.y);
//            Data.left.paintIcon(this, g, this.userX, this.userY);
        } else if (this.blueUserDirection == Direction.RIGHT) {
            Data.right.paintIcon(this, g, this.bluePlayer.x, this.bluePlayer.y);
//            Data.right.paintIcon(this, g, this.userX, this.userY);
        }
    }
}

/**
 * 键盘监听
 */
class MyKeyListener extends KeyAdapter {
    GamePanel gamePanelContext = null;

    public MyKeyListener(GamePanel gamePanelContext) {
        this.gamePanelContext = gamePanelContext;
    }

    /**
     * 松开时候触发
     */
    @Override
    public void keyReleased(KeyEvent e) {
//        super.keyReleased(e);
        // 生成一个炸弹

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//            int userX = gamePanelContext.userX;
//            int userY = gamePanelContext.userY;
            int userX = gamePanelContext.bluePlayer.x;
            int userY = gamePanelContext.bluePlayer.y;
//            Point bombPoint = new Point(userX, userY);
            BaseElement bombElement = new BaseElement(userX, userY);
            gamePanelContext.bombList.add(bombElement);
//            gamePanelContext.repaint();
            Timer timer = new Timer();
            // 3秒钟之后炸弹消失
            timer.schedule(new MyBombTimerStak(this.gamePanelContext, bombElement), 3000);
        }
        System.out.println("keyReleased");
    }

    /**
     * 只要不松开 就一直触发
     */
    @Override
    public void keyPressed(KeyEvent e) {

//        System.out.println("keyPressed");
//        super.keyPressed(e);
        int keyCode = e.getKeyCode();
        int newX = this.gamePanelContext.bluePlayer.x;
        int newY = this.gamePanelContext.bluePlayer.y;
        if (keyCode == KeyEvent.VK_UP) {
            gamePanelContext.blueUserDirection = Direction.UP;
            newY -= this.gamePanelContext.userSpeed;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            gamePanelContext.blueUserDirection = Direction.DOWN;
            newY += this.gamePanelContext.userSpeed;
        } else if (keyCode == KeyEvent.VK_LEFT) {
            gamePanelContext.blueUserDirection = Direction.LEFT;
            newX -= this.gamePanelContext.userSpeed;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            gamePanelContext.blueUserDirection = Direction.RIGHT;
            newX += this.gamePanelContext.userSpeed;
        }
        if (keyCode == KeyEvent.VK_W) {
            gamePanelContext.redUserDirection = Direction.UP;
            gamePanelContext.redPlayer.y -= gamePanelContext.userSpeed;
        } else if (keyCode == KeyEvent.VK_S) {
            gamePanelContext.redUserDirection = Direction.DOWN;
            gamePanelContext.redPlayer.y += gamePanelContext.userSpeed;
        } else if (keyCode == KeyEvent.VK_A) {
            gamePanelContext.redUserDirection = Direction.LEFT;
            gamePanelContext.redPlayer.x -= gamePanelContext.userSpeed;
        } else if (keyCode == KeyEvent.VK_D) {
            gamePanelContext.redUserDirection = Direction.RIGHT;
            gamePanelContext.redPlayer.x += gamePanelContext.userSpeed;
        }
        // 碰墙判定
        for (BaseElement element : this.gamePanelContext.wallList) {
            if (element.intersects(newX, newY, 50, 50)) {
                System.out.println("墙！");
                return;
            }
        }
        // 碰可破坏障碍物判定
        for (BaseElement element : this.gamePanelContext.destructibleObstacle01) {
            if (element.intersects(newX, newY, 50, 50)) {
                System.out.println("可破坏障碍物！");
                return;
            }
        }
        if (newX < 0) {
            this.gamePanelContext.bluePlayer.x = 0;
        } else if (newX > 750) {
            this.gamePanelContext.bluePlayer.x = 750;
        } else {
            this.gamePanelContext.bluePlayer.x = newX;
        }
        if (newY < 0) {
            this.gamePanelContext.bluePlayer.y = 0;
        } else if (newY > 750) {
            this.gamePanelContext.bluePlayer.y = 750;
        } else {
            this.gamePanelContext.bluePlayer.y = newY;
        }

        // 更新面板
//        gamePanelContext.repaint();
    }

}

/**
 * 炸弹计时器
 */
class MyBombTimerStak extends TimerTask {
    GamePanel gamePanelContext = null;
    BaseElement bombElement = null;

    public MyBombTimerStak(GamePanel gamePanelContext, BaseElement bombElement) {
        this.gamePanelContext = gamePanelContext;
        this.bombElement = bombElement;
    }

    @Override
    public void run() {
        int x = (int) this.bombElement.getX();
        int y = (int) this.bombElement.getY();
        this.gamePanelContext.bombList.remove(this.bombElement);
//        爆炸后产生火焰
        // 炸弹地点肯定会产生火焰
        this.gamePanelContext.fireList.add(new BaseElement(x, y));
        int count = 1, startIndex = this.gamePanelContext.fireList.size() - 1;
        BaseElement element1 = new BaseElement(x + 50, y);
        BaseElement element2 = new BaseElement(x - 50, y);
        BaseElement element3 = new BaseElement(x, y + 50);
        BaseElement element4 = new BaseElement(x, y - 50);
        int i = 0;
        // 如果element1所处地方是合理位置
        if (x + 50 <= this.gamePanelContext.MAXX) {
            for (i = 0; i < this.gamePanelContext.wallList.size(); i++) {
                if (this.gamePanelContext.wallList.get(i).intersects(element1)) {
                    break;
                }
            }
            // 如果element1与所有墙体都不相交
            if (i == this.gamePanelContext.wallList.size()) {
                count++;
                this.gamePanelContext.fireList.add(element1);
                for (int j = 0; j < this.gamePanelContext.destructibleObstacle01.size(); ) {
                    // 与可破坏障碍物相交
                    if (this.gamePanelContext.destructibleObstacle01.get(j).intersects(element1)) {
                        this.gamePanelContext.destructibleObstacle01.remove(j);
                    } else {
                        j++;
                    }
                }
                // 与人物相交
                if (element1.intersects(this.gamePanelContext.bluePlayer)) {
                    this.gamePanelContext.setEnd(true);
                }
                // 手动刷新
                this.gamePanelContext.repaint();
            }
        }
        if (x - 50 >= 0) {
            for (i = 0; i < this.gamePanelContext.wallList.size(); i++) {
                if (this.gamePanelContext.wallList.get(i).intersects(element2)) {
                    break;
                }
            }
            if (i == this.gamePanelContext.wallList.size()) {
                count++;
                this.gamePanelContext.fireList.add(element2);
                for (int j = 0; j < this.gamePanelContext.destructibleObstacle01.size(); ) {
                    if (this.gamePanelContext.destructibleObstacle01.get(j).intersects(element2)) {
                        this.gamePanelContext.destructibleObstacle01.remove(j);
                    } else {
                        j++;
                    }
                }
                if (element2.intersects(this.gamePanelContext.bluePlayer)) {
                    this.gamePanelContext.setEnd(true);
                }
                // 手动刷新
                this.gamePanelContext.repaint();
            }
        }

        if (y + 50 <= this.gamePanelContext.MAXY) {
            for (i = 0; i < this.gamePanelContext.wallList.size(); i++) {
                if (this.gamePanelContext.wallList.get(i).intersects(element3)) {
                    break;
                }
            }
            if (i == this.gamePanelContext.wallList.size()) {
                count++;
                this.gamePanelContext.fireList.add(element3);
                for (int j = 0; j < this.gamePanelContext.destructibleObstacle01.size(); ) {
                    if (this.gamePanelContext.destructibleObstacle01.get(j).intersects(element3)) {
                        this.gamePanelContext.destructibleObstacle01.remove(j);

                    } else {
                        j++;
                    }

                }
                if (element3.intersects(this.gamePanelContext.bluePlayer)) {
                    this.gamePanelContext.setEnd(true);
                }
                // 手动刷新
                this.gamePanelContext.repaint();
            }
        }
        if (y - 50 >= 0) {
            for (i = 0; i < this.gamePanelContext.wallList.size(); i++) {
                if (this.gamePanelContext.wallList.get(i).intersects(element4)) {
                    break;
                }
            }
            if (i == this.gamePanelContext.wallList.size()) {
                count++;
                this.gamePanelContext.fireList.add(element4);
                for (int j = 0; j < this.gamePanelContext.destructibleObstacle01.size(); ) {
                    if (this.gamePanelContext.destructibleObstacle01.get(j).intersects(element4)) {
                        this.gamePanelContext.destructibleObstacle01.remove(j);
                    } else {
                        j++;
                    }

                }
                if (element4.intersects(this.gamePanelContext.bluePlayer)) {
                    this.gamePanelContext.setEnd(true);
                }
                // 手动刷新
                this.gamePanelContext.repaint();
            }
        }

//        this.gamePanelContext.repaint();
        Timer timer = new Timer();
//        火焰两秒后消失
        timer.schedule(new MyFireTimerTask(this.gamePanelContext, startIndex, count), 2000);
    }
}

/**
 * 火焰定时器
 */
class MyFireTimerTask extends TimerTask {
    int fireLength;
    GamePanel gamePanelContext = null;
    int startIndex = -1;

    public MyFireTimerTask(GamePanel gamePanelContext, int startIndex, int fireLength) {
        this.gamePanelContext = gamePanelContext;
        this.startIndex = startIndex;
        this.fireLength = fireLength;
    }

    @Override
    public void run() {
        for (int i = 1; i <= fireLength; i++) {
            this.gamePanelContext.fireList.remove(startIndex);
            BaseElement fireElement = this.gamePanelContext.fireList.get(startIndex);
            for (int j = 0; j < this.gamePanelContext.destructibleObstacle01.size(); ) {
                BaseElement desr01Element = this.gamePanelContext.destructibleObstacle01.get(j);
                if (fireElement.intersects(desr01Element)) {
                    this.gamePanelContext.destructibleObstacle01.remove(j);
                } else {
                    j++;
                }
            }
        }
//        this.gamePanelContext.repaint();
    }
}

class RepaintTimerTask extends TimerTask {
    public RepaintTimerTask(GamePanel gamePanelContext) {
        this.gamePanelContext = gamePanelContext;
    }

    GamePanel gamePanelContext;

    @Override
    public void run() {
        this.gamePanelContext.repaint();
    }
}