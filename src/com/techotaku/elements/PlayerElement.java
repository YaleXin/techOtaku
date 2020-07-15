/**
 * 
 */
package com.techotaku.elements;

import com.techotaku.elements.BaseElement;
import com.techotaku.enums.Direction;

/**   
*Author: techOtaku    
*/
public class PlayerElement extends BaseElement {
	// 当前角色的方向
    public Direction nowDirection;
    // 炸弹数量
	public int bombNum;
	// 血量
	public int hp;
	// 速度
	public int speed;
	// 无敌状态
	public boolean isInvincible;
	// 无敌时间
	public int invincibleTime;
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
