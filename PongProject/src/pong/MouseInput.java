package pong;

import java.awt.*;
import java.awt.event.*;

public class MouseInput implements MouseListener {
	public void mousePressed(MouseEvent e) {
		//get mouse click location
		int mouseX = e.getX();
		int mouseY = e.getY();

		/**
		 * public Rectangle aiButton = new Rectangle(GamePanel.GAME_WIDTH/2-50, 150,
		 * 100, 50); public Rectangle playButton = new
		 * Rectangle(GamePanel.GAME_WIDTH/2-50, 250, 100, 50); public Rectangle
		 * helpButton = new Rectangle(GamePanel.GAME_WIDTH/2-50, 350, 100, 50);
		 */

		// ai Button
		if (GamePanel.state == GamePanel.STATE.MENU) {
			
		
		if (mouseX >= GamePanel.GAME_WIDTH / 2 - 50 && mouseX <= GamePanel.GAME_WIDTH / 2 + 50) {
			if (mouseY >= 150 && mouseY <= 200) {
				GamePanel.state = GamePanel.STATE.AI;
			}
		}

		// 1v1 Button
		if (mouseX >= GamePanel.GAME_WIDTH / 2 - 50 && mouseX <= GamePanel.GAME_WIDTH / 2 + 50) {
			if (mouseY >= 250 && mouseY <= 300) {
				GamePanel.state = GamePanel.STATE.GAME;
			}
		}
		
		if (mouseX >= GamePanel.GAME_WIDTH / 2 - 96 && mouseX <= GamePanel.GAME_WIDTH / 2 + 96) {
			if (mouseY >= 350 && mouseY <= 400) {
				GamePanel.state = GamePanel.STATE.INSTRUCTIONS;
			}
		}
		}
		if (GamePanel.state == GamePanel.STATE.INSTRUCTIONS || GamePanel.state == GamePanel.STATE.GAME ) {
			
		if (mouseX >= 300 && mouseX <= 350) {
			if (mouseY >= 10 && mouseY <= 50) {
				GamePanel.state = GamePanel.STATE.MENU;
			}	
		}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
