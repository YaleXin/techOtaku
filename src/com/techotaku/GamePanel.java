/**
 * 
 */
package com.techotaku;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JPanel;

import com.techotaku.enums.KeySet;


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
