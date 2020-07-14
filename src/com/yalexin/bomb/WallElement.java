package com.yalexin.bomb;

/**
 * Author：Yalexin
 * Email： 181303209@yzu.edu.cn
 */
public class WallElement extends BaseElement{
    /**
     * 默认一块元素的大小是 50*50 px
     * @param x
     * @param y
     */
    public WallElement(int x, int y) {
        super(x, y);
    }

//    @Override
//    public boolean equals(Object obj) {
//        WallElement o = (WallElement) obj;
////        return super.equals(obj);
//        return o.x == this.x && o.y == this.y;
//    }
}
