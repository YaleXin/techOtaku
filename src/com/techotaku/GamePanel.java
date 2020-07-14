/**
 * 
 */
package com.techotaku;

import java.awt.Graphics;

import javax.swing.JPanel;


/**   
*Author: techOtaku    
*/
public class GamePanel extends JPanel {

	PlayerElement bluePlayer;
	PlayerElement redPlayer;
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
