/**
 * 
 */
package com.techotaku;


import com.techotaku.elements.*;
import com.techotaku.enums.KeySet;
import com.techotaku.enums.Direction;
import com.techotaku.enums.Props;
import com.techotaku.utils.InitTool;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JPanel;



/**   
*Author: techOtaku    
*/

/**
 * 画布是 (13*50 = 650)   *    (13*50 = 650)
 * 元素有效坐标： x:[0 - 600] y:[0 - 600]
 */
public class GamePanel extends JPanel {
	
	public PlayerElement bluePlayer;
	public PlayerElement redPlayer;
	// 墙体列表
	public ArrayList<WallElement> wallElements;
	// 火焰列表
	public ArrayList<FireElement> fireElements;
	// 可破坏障碍物
	public ArrayList<DestructibleObstacleElement> destructibleObstacleElements;
	// 炸弹
	public ArrayList<BombElement> bombElements;
	// 道具
	public ArrayList<PropsElement> propsElements;
	// 按键集合
	public HashSet<KeySet> keySets;
	public boolean isEnd;
	public GamePanel() {
		Init();
	}
	private void Init() {
		InitTool initTool = new InitTool(this);
		initTool.gameInit();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// 绘制地板
		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 13; j++) {
				Data.floor02.paintIcon(this, g, i * 50, j * 50);
			}



		// 绘制墙体
		for (WallElement element:
			 this.wallElements) {
			Data.floor01.paintIcon(this,g,element.x,element.y);
		}

		// 绘制炸弹
		for (BombElement bomb :
				this.bombElements) {
			Data.bomb.paintIcon(this, g, bomb.x, bomb.y);
		}

		// 绘制蓝角色
		if(this.bluePlayer.nowDirection == Direction.UP){
			Data.blueUp.paintIcon(this,g,this.bluePlayer.x,this.bluePlayer.y);
		}else if(this.bluePlayer.nowDirection == Direction.DOWN){
			Data.blueDown.paintIcon(this,g,this.bluePlayer.x,this.bluePlayer.y);
		}else if(this.bluePlayer.nowDirection == Direction.LEFT){
			Data.blueLeft.paintIcon(this,g,this.bluePlayer.x,this.bluePlayer.y);
		}else if(this.bluePlayer.nowDirection == Direction.RIGHT){
			Data.blueRight.paintIcon(this,g,this.bluePlayer.x,this.bluePlayer.y);
		}

		// 绘制红角色
		if(this.redPlayer.nowDirection == Direction.UP){
			Data.redUp.paintIcon(this,g,this.redPlayer.x,this.redPlayer.y);
		}else if(this.redPlayer.nowDirection == Direction.DOWN){
			Data.redDown.paintIcon(this,g,this.redPlayer.x,this.redPlayer.y);
		}else if(this.redPlayer.nowDirection == Direction.LEFT){
			Data.redLeft.paintIcon(this,g,this.redPlayer.x,this.redPlayer.y);
		}else if(this.redPlayer.nowDirection == Direction.RIGHT){
			Data.redRight.paintIcon(this,g,this.redPlayer.x,this.redPlayer.y);
		}

		// 绘制障碍物
		for (DestructibleObstacleElement dstr :
				this.destructibleObstacleElements) {
			Data.destr01.paintIcon(this, g, dstr.x, dstr.y);
		}

		// 绘制火焰
		for (int i = 0; i< this.fireElements.size();i++) {
			Data.fire.paintIcon(this, g, this.fireElements.get(i).x, this.fireElements.get(i).y);
		}
		// 角色属性
		g.setFont(new Font("微软雅黑",Font.BOLD,20));
		g.drawString("蓝角色血量：" + this.bluePlayer.hp + "炸弹数："+ this.bluePlayer.bombNum,0,670);
		g.drawString("红角色血量：" + this.redPlayer.hp + "炸弹数："+ this.redPlayer.bombNum,450,670);

		// 画道具
		for (PropsElement props :
				this.propsElements) {
			if (props.type == Props.BLOOD_BOTTLE){
				Data.bloodBottle.paintIcon(this,g,props.x,props.y);
			}else if(props.type == Props.SHIELDING){
				Data.shielding.paintIcon(this,g,props.x,props.y);
			}
		}
		
		
		// 游戏结束
		if (this.isEnd){
			g.setColor(Color.RED);
			g.setFont(new Font("微软雅黑",Font.BOLD,50));
			g.drawString("游戏结束",350,350);
			g.setColor(Color.BLACK);
		}
	}

}
