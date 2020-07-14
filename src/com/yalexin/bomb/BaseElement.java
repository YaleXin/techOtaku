package com.yalexin.bomb;

/**
 * Author：Yalexin
 * Email： 181303209@yzu.edu.cn
 */

import java.awt.*;

/**
 * 基本元素类,继承于Rectangle类，方便使用判断是否相交
 */
public class BaseElement extends Rectangle {
    /**
     * 默认一块元素的大小是 50*50 px
     */
    public BaseElement(int x, int y) {
        super(x, y, 50, 50);
    }

    private BaseElement() {

    }

}
