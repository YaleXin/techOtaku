/**
 * 
 */
package com.techotaku;


import com.techotaku.enums.KeySet;
import com.techotaku.enums.Direction;
import com.techotaku.enums.Props;
import com.techotaku.threads.KeyListenerRunnable;
import com.techotaku.threads.PaintRunnable;
import com.techotaku.utils.InitTool;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JPanel;



/**   
*Author: techOtaku    
*/
public class GamePanel extends JPanel {
	
	public PlayerElement bluePlayer;
	public PlayerElement redPlayer;
	// 墙体列表
	public ArrayList<WallElement> wallElements;
	// 火焰列表
	public ArrayList<FireElement> fireElements;
	// 可破坏障碍物
	public ArrayList<DestructibleObstacle> destructibleObstacles;
	// 按键集合
	public HashSet<KeySet> keySets;
	// 道具集合
	public HashSet<Props> propsSet;
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
			for (int j = 0; j < 14; j++) {
				Data.floor02.paintIcon(this, g, i * 50, j * 50);
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

	}

}
