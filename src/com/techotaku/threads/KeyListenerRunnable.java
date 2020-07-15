package com.techotaku.threads;

import com.techotaku.GamePanel;
import com.techotaku.elements.DestructibleObstacleElement;
import com.techotaku.elements.WallElement;
import com.techotaku.enums.Direction;
import com.techotaku.enums.KeySet;

/**
 * Author：Yalexin
 * Email： 181303209@yzu.edu.cn
 */
public class KeyListenerRunnable implements Runnable {
    GamePanel gamePanelContext = null;

    public KeyListenerRunnable(GamePanel gamePanelContext) {
        this.gamePanelContext = gamePanelContext;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(40);


                // 蓝方角色控制
                if (this.gamePanelContext.keySets.contains(KeySet.W)) {
                    this.gamePanelContext.bluePlayer.nowDirection = Direction.UP;
                    int newY = this.gamePanelContext.bluePlayer.y - this.gamePanelContext.bluePlayer.speed;
                    boolean intersects = false;
                    boolean intersectsPlayer = false;
                    // 碰墙判定
                    for (WallElement w :
                            this.gamePanelContext.wallElements) {
                        if (w.intersects(this.gamePanelContext.bluePlayer.x, newY, 50, 50)) {
                            intersects = true;
                            break;
                        }
                    }
                    // 碰障碍物
                    for (DestructibleObstacleElement d :
                            this.gamePanelContext.destructibleObstacleElements) {
                        if (d.intersects(this.gamePanelContext.bluePlayer.x, newY, 50, 50)) {
                            intersects = true;
                            break;
                        }
                    }
                    // 碰到另外的角色
                    if (this.gamePanelContext.redPlayer.intersects(this.gamePanelContext.bluePlayer.x, newY, 50, 50)) {
                        intersectsPlayer = true;
                    }
                    if (!intersects && !intersectsPlayer && newY >= 0 && newY <= 600) {
                        this.gamePanelContext.bluePlayer.y = newY;
                    }
                }
                if (this.gamePanelContext.keySets.contains(KeySet.S)) {
                    this.gamePanelContext.bluePlayer.nowDirection = Direction.DOWN;
                    int newY = this.gamePanelContext.bluePlayer.y + this.gamePanelContext.bluePlayer.speed;
                    boolean intersects = false;
                    boolean intersectsPlayer = false;
                    // 碰墙判定
                    for (WallElement w :
                            this.gamePanelContext.wallElements) {
                        if (w.intersects(this.gamePanelContext.bluePlayer.x, newY, 50, 50)) {
                            intersects = true;
                            break;
                        }
                    }
                    // 碰障碍物
                    for (DestructibleObstacleElement d :
                            this.gamePanelContext.destructibleObstacleElements) {
                        if (d.intersects(this.gamePanelContext.bluePlayer.x, newY, 50, 50)) {
                            intersects = true;
                            break;
                        }
                    }
                    // 碰到另外的角色
                    if (this.gamePanelContext.redPlayer.intersects(this.gamePanelContext.bluePlayer.x, newY, 50, 50)) {
                        intersectsPlayer = true;
                    }
                    if (!intersects && !intersectsPlayer && newY >= 0 && newY <= 600) {
                        this.gamePanelContext.bluePlayer.y = newY;
                    }
                }
                if (this.gamePanelContext.keySets.contains(KeySet.A)) {
                    this.gamePanelContext.bluePlayer.nowDirection = Direction.LEFT;
                    int newX = this.gamePanelContext.bluePlayer.x - this.gamePanelContext.bluePlayer.speed;
                    boolean intersects = false;
                    boolean intersectsPlayer = false;
                    // 碰墙判定
                    for (WallElement w :
                            this.gamePanelContext.wallElements) {
                        if (w.intersects(newX, this.gamePanelContext.bluePlayer.y, 50, 50)) {
                            intersects = true;
                            break;
                        }
                    }
                    // 碰障碍物
                    for (DestructibleObstacleElement d :
                            this.gamePanelContext.destructibleObstacleElements) {
                        if (d.intersects(newX,this.gamePanelContext.bluePlayer.y, 50, 50)) {
                            intersects = true;
                            break;
                        }
                    }
                    // 碰到另外的角色
                    if (this.gamePanelContext.redPlayer.intersects(newX, this.gamePanelContext.bluePlayer.y, 50, 50)) {
                        intersectsPlayer = true;
                    }
                    if (!intersects && !intersectsPlayer && newX >= 0 && newX <= 700) {
                        this.gamePanelContext.bluePlayer.x = newX;
                    }
                }
                if (this.gamePanelContext.keySets.contains(KeySet.D)) {
                    this.gamePanelContext.bluePlayer.nowDirection = Direction.RIGHT;
                    int newX = this.gamePanelContext.bluePlayer.x + this.gamePanelContext.bluePlayer.speed;
                    boolean intersects = false;
                    boolean intersectsPlayer = false;
                    // 碰墙判定
                    for (WallElement w :
                            this.gamePanelContext.wallElements) {
                        if (w.intersects(newX, this.gamePanelContext.bluePlayer.y, 50, 50)) {
                            intersects = true;
                            break;
                        }
                    }
                    // 碰障碍物
                    for (DestructibleObstacleElement d :
                            this.gamePanelContext.destructibleObstacleElements) {
                        if (d.intersects(newX,this.gamePanelContext.bluePlayer.y, 50, 50)) {
                            intersects = true;
                            break;
                        }
                    }
                    // 碰到另外的角色
                    if (this.gamePanelContext.redPlayer.intersects(newX, this.gamePanelContext.bluePlayer.y, 50, 50)) {
                        intersectsPlayer = true;
                    }
                    if (!intersects && !intersectsPlayer && newX >= 0 && newX <= 700) {
                        this.gamePanelContext.bluePlayer.x = newX;
                    }
                }

                // 红方角色控制
                if (this.gamePanelContext.keySets.contains(KeySet.UP)) {
                    this.gamePanelContext.redPlayer.nowDirection = Direction.UP;
                    int newY = this.gamePanelContext.redPlayer.y - this.gamePanelContext.redPlayer.speed;
                    boolean intersects = false;
                    boolean intersectsPlayer = false;
                    // 碰墙判定
                    for (WallElement w :
                            this.gamePanelContext.wallElements) {
                        if (w.intersects(this.gamePanelContext.redPlayer.x, newY, 50, 50)) {
                            intersects = true;
                            break;
                        }
                    }
                    // 碰障碍物
                    for (DestructibleObstacleElement d :
                            this.gamePanelContext.destructibleObstacleElements) {
                        if (d.intersects(this.gamePanelContext.redPlayer.x, newY, 50, 50)) {
                            intersects = true;
                            break;
                        }
                    }
                    // 碰到另外的角色
                    if (this.gamePanelContext.bluePlayer.intersects(this.gamePanelContext.redPlayer.x, newY, 50, 50)) {
                        intersectsPlayer = true;
                    }
                    if (!intersects && !intersectsPlayer && newY >= 0 && newY <= 600) {
                        this.gamePanelContext.redPlayer.y = newY;
                    }
                }
                if (this.gamePanelContext.keySets.contains(KeySet.DOWN)) {
                    this.gamePanelContext.redPlayer.nowDirection = Direction.DOWN;
                    int newY = this.gamePanelContext.redPlayer.y + this.gamePanelContext.redPlayer.speed;
                    boolean intersects = false;
                    boolean intersectsPlayer = false;
                    // 碰墙判定
                    for (WallElement w :
                            this.gamePanelContext.wallElements) {
                        if (w.intersects(this.gamePanelContext.redPlayer.x, newY, 50, 50)) {
                            intersects = true;
                            break;
                        }
                    }
                    // 碰障碍物
                    for (DestructibleObstacleElement d :
                            this.gamePanelContext.destructibleObstacleElements) {
                        if (d.intersects(this.gamePanelContext.redPlayer.x, newY, 50, 50)) {
                            intersects = true;
                            break;
                        }
                    }
                    // 碰到另外的角色
                    if (this.gamePanelContext.bluePlayer.intersects(this.gamePanelContext.redPlayer.x, newY, 50, 50)) {
                        intersectsPlayer = true;
                    }
                    if (!intersects && !intersectsPlayer && newY >= 0 && newY <= 600) {
                        this.gamePanelContext.redPlayer.y = newY;
                    }
                }
                if (this.gamePanelContext.keySets.contains(KeySet.LEFT)) {
                    this.gamePanelContext.redPlayer.nowDirection = Direction.LEFT;
                    int newX = this.gamePanelContext.redPlayer.x - this.gamePanelContext.redPlayer.speed;
                    boolean intersects = false;
                    boolean intersectsPlayer = false;
                    // 碰墙判定
                    for (WallElement w :
                            this.gamePanelContext.wallElements) {
                        if (w.intersects(newX, this.gamePanelContext.redPlayer.y, 50, 50)) {
                            intersects = true;
                            break;
                        }
                    }
                    // 碰障碍物
                    for (DestructibleObstacleElement d :
                            this.gamePanelContext.destructibleObstacleElements) {
                        if (d.intersects(newX,this.gamePanelContext.redPlayer.y, 50, 50)) {
                            intersects = true;
                            break;
                        }
                    }
                    // 碰到另外的角色
                    if (this.gamePanelContext.bluePlayer.intersects(newX, this.gamePanelContext.redPlayer.y, 50, 50)) {
                        intersectsPlayer = true;
                    }
                    if (!intersects && !intersectsPlayer && newX >= 0 && newX <= 700) {
                        this.gamePanelContext.redPlayer.x = newX;
                    }
                }
                if (this.gamePanelContext.keySets.contains(KeySet.RIGHT)) {
                    this.gamePanelContext.redPlayer.nowDirection = Direction.RIGHT;
                    int newX = this.gamePanelContext.redPlayer.x + this.gamePanelContext.redPlayer.speed;
                    boolean intersects = false;
                    boolean intersectsPlayer = false;
                    // 碰墙判定
                    for (WallElement w :
                            this.gamePanelContext.wallElements) {
                        if (w.intersects(newX, this.gamePanelContext.redPlayer.y, 50, 50)) {
                            intersects = true;
                            break;
                        }
                    }
                    // 碰障碍物
                    for (DestructibleObstacleElement d :
                            this.gamePanelContext.destructibleObstacleElements) {
                        if (d.intersects(newX,this.gamePanelContext.redPlayer.y, 50, 50)) {
                            intersects = true;
                            break;
                        }
                    }
                    // 碰到另外的角色
                    if (this.gamePanelContext.bluePlayer.intersects(newX, this.gamePanelContext.redPlayer.y, 50, 50)) {
                        intersectsPlayer = true;
                    }
                    if (!intersects && !intersectsPlayer && newX >= 0 && newX <= 700) {
                        this.gamePanelContext.redPlayer.x = newX;
                    }
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}