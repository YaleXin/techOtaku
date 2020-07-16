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
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

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
//	public ArrayList<FireElement> fireElements;
//	public Vector<FireElement> fireElements;
	// 线程安全
	public CopyOnWriteArrayList<FireElement> fireElements;
	// 可破坏障碍物
//	public ArrayList<DestructibleObstacleElement> destructibleObstacleElements;
	public CopyOnWriteArrayList<DestructibleObstacleElement> destructibleObstacleElements;
	// 炸弹
//	public ArrayList<BombElement> bombElements;
	public CopyOnWriteArrayList<BombElement> bombElements;
	// 道具
//	public ArrayList<PropsElement> propsElements;
	public CopyOnWriteArrayList<PropsElement> propsElements;
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
				Data.floor.paintIcon(this, g, i * 50, j * 50);
			}



		// 绘制墙体
		for (WallElement element:
			 this.wallElements) {
			Data.floor01.paintIcon(this,g,element.x,element.y);
		}

		// 绘制炸弹
		Iterator<BombElement> bombsIt = this.bombElements.iterator();
		while (bombsIt.hasNext()){
			BombElement next = bombsIt.next();
			Data.bomb.paintIcon(this, g, next.x, next.y);
		}
//		for (BombElement bomb :
//				this.bombElements) {
//			Data.bomb.paintIcon(this, g, bomb.x, bomb.y);
//		}

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
//		for (DestructibleObstacleElement dstr :
//				this.destructibleObstacleElements) {
//			Data.destr01.paintIcon(this, g, dstr.x, dstr.y);
//		}
		Iterator<DestructibleObstacleElement> destrIt = this.destructibleObstacleElements.iterator();
		while (destrIt.hasNext()){
			DestructibleObstacleElement next = destrIt.next();
			Data.destr01.paintIcon(this, g, next.x, next.y);
		}

		// 绘制火焰
		ListIterator<FireElement> firesIt = this.fireElements.listIterator();
		while (firesIt.hasNext()) {
			FireElement next = firesIt.next();
			Data.fire.paintIcon(this, g, next.x, next.y);
		}
//		for (int i = 0; i< this.fireElements.size();i++) {
//			Data.fire.paintIcon(this, g, this.fireElements.get(i).x, this.fireElements.get(i).y);
//		}
		// 角色属性
		g.setFont(new Font("微软雅黑",Font.BOLD,16));
		g.drawString("蓝玩家：",750,130);
		g.drawString("  血量：" + this.bluePlayer.hp,750,150);
		g.drawString("  炸弹数：" + this.bluePlayer.bombNum,750,170);
		g.drawString("  无敌时间：" + this.bluePlayer.invincibleTime,750,190);

		g.drawString("红玩家：",750,210);
		g.drawString("  血量：" + this.redPlayer.hp,750,230);
		g.drawString("  炸弹数：" + this.redPlayer.bombNum,750,250);
		g.drawString("  无敌时间：" + this.redPlayer.invincibleTime,750,270);
		// 绘制道具
		Iterator<PropsElement> propsIt = this.propsElements.iterator();
		while (propsIt.hasNext()){
			PropsElement next = propsIt.next();
			if (next.type == Props.BLOOD_BOTTLE){
				Data.bloodBottle.paintIcon(this,g,next.x,next.y);
			}else if(next.type == Props.SHIELDING){
				Data.shielding.paintIcon(this,g,next.x,next.y);
			}
		}
//		for (PropsElement props :
//				this.propsElements) {
//			if (props.type == Props.BLOOD_BOTTLE){
//				Data.bloodBottle.paintIcon(this,g,props.x,props.y);
//			}else if(props.type == Props.SHIELDING){
//				Data.shielding.paintIcon(this,g,props.x,props.y);
//			}
//		}
		
		
		// 游戏结束
		if (this.isEnd){
			g.setColor(Color.RED);
			g.setFont(new Font("微软雅黑",Font.BOLD,50));
			g.drawString("游戏结束",350,350);
			g.setColor(Color.BLACK);
		}

		// 帮助信息
		g.drawString("蓝玩家：WSAD控制上下左右，",750,30);
		g.drawString("        F释放炸弹。",750,50);
		g.drawString("红玩家：↑↓←→控制上下左右，",750,70);
		g.drawString("        M释放炸弹。",750,90);
	}

}
