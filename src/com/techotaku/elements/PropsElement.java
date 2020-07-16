package com.techotaku.elements;

import com.techotaku.enums.Props;

/**
 *Author: techOtaku
 */
public class PropsElement extends BaseElement{
    public Props type;
    /**
     * 默认一块元素的大小是 50*50 px
     * @param x
     * @param y
     */
    public PropsElement(int x, int y,Props type) {
        super(x, y);
        this.type = type;
    }
}
