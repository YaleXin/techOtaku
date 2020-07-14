/**
 * 
 */
package com.techotaku;

import java.awt.Rectangle;

/**   
*Author: techOtaku    
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