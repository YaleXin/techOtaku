package com.techotaku.timertasks;

import com.techotaku.GamePanel;

import com.techotaku.elements.DestructibleObstacleElement;
import com.techotaku.elements.FireElement;
import com.techotaku.elements.PropsElement;
import com.techotaku.enums.Props;

import java.util.Random;
import java.util.TimerTask;

/**
 * Author：Yalexin
 * Email： 181303209@yzu.edu.cn
 */
public class MyFireDisappearTimerTask extends TimerTask {
    FireElement FireElement = null;
    GamePanel gamePanelContext = null;

    public MyFireDisappearTimerTask(GamePanel gamePanelContext, FireElement fireElement) {
        FireElement = fireElement;
        this.gamePanelContext = gamePanelContext;
    }

    @Override
    public void run() {
        Random random = new Random();
        System.out.println("火焰消失 --> x:" + this.FireElement.x +",y:" + this.FireElement.y);
        this.gamePanelContext.fireElements.remove(this.FireElement);
        for (int i = 0;i < this.gamePanelContext.destructibleObstacleElements.size();) {
            DestructibleObstacleElement destr = this.gamePanelContext.destructibleObstacleElements.get(i);
            if (destr.intersects(this.FireElement)){
                this.gamePanelContext.destructibleObstacleElements.remove(i);
                // 生成道具
                PropsElement propsElement = new PropsElement(destr.x, destr.y, Props.BLOOD_BOTTLE);
                int type = random.nextInt(2);
                if (type == 0){
                    propsElement.type = Props.BLOOD_BOTTLE;
                }else if (type == 1){
                    propsElement.type = Props.SHIELDING;
                }
                this.gamePanelContext.propsElements.add(propsElement);
            }else {
                i++;
            }
        }

    }
}
