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
		threadInit();
	}

	private void threadInit() {
		// 初始化按键监听线程
		KeyListenerRunnable keyListenerRunnable = new KeyListenerRunnable(this);
		Thread keyListenerThread = new Thread(keyListenerRunnable);
		keyListenerThread.start();
	}


	private void mapInit() {

	}

	private void userInit() {
		this.bluePlayer = new PlayerElement(0,0);
		this.redPlayer = new PlayerElement(500,500);
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
//		Data.
	}

}
