package com.techotaku.elements;


import java.util.Timer;
import java.util.TimerTask;

/**
 *Author: techOtaku
 */
public class BombElement extends BaseElement {
    /**
     * 默认一块元素的大小是 50*50 px
     * @param x
     * @param y
     */
    public BombElement(int x, int y) {
        super(x, y);
//        Timer timer = new Timer();
//        timer.schedule(new MyTimeTask(),);
    }
    class MyTimeTask extends TimerTask{

        @Override
        public void run() {

        }
    }
}
