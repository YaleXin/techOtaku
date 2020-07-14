/**
 * 
 */
package com.techotaku;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;


/**   
*Author: techOtaku    
*/
public class GamePanel extends JPanel {
	
	PlayerElement bluePlayer;
	PlayerElement redPlayer;
	// 墙体列表
	ArrayList<WallElement> wallElements;
	// 火焰列表
	ArrayList<FireElement> fireElements;
	// 可破坏障碍物
	ArrayList<DestructibleObstacle> destructibleObstacles;
	public GamePanel() {
		Init();
	}
	private void Init() {
		userInit();
		mapInit();
	}


	private void mapInit() {

	}

	private void userInit() {		
	}
	@Override
	protected void paintComponent(Graphics g) {
	}
}
