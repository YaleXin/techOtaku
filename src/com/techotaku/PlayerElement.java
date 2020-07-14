/**
 * 
 */
package com.techotaku;

import com.techotaku.enums.Direction;

/**   
*Author: techOtaku    
*/
public class PlayerElement extends BaseElement {
	// 当前角色的方向
	Direction nowDirection;
	int hp;
	/**
	 * @param x 横坐标
	 * @param y 纵坐标
	 */
	public PlayerElement(int x, int y) {
		super(x, y);
		this.hp = 100;
		// TODO Auto-generated constructor stub
	}

	public Direction getNowDirection() {
		return nowDirection;
	}

	public void setNowDirection(Direction nowDirection) {
		this.nowDirection = nowDirection;
	}

}
