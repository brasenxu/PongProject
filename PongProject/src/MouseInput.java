
import java.awt.event.*;

public class MouseInput implements MouseListener {
	public void mousePressed(MouseEvent e) {
		// get mouse click location
		int mouseX = e.getX();
		int mouseY = e.getY();
		Sound click = new Sound(".//res//buttonClick.wav");
		
		if (PongPanel.state == PongPanel.STATE.MENU) {
			// ai Button
			if (mouseX >= PongPanel.WIDTH / 2 - 50 && mouseX <= PongPanel.WIDTH / 2 + 50) {
				if (mouseY >= 150 && mouseY <= 200) {
					click.soundFile();
					click.playSound();
					PongPanel.isBeginning = true;
					PongPanel.state = PongPanel.STATE.AI;
				}
			}

			// 1v1 Button
			if (mouseX >= PongPanel.WIDTH / 2 - 50 && mouseX <= PongPanel.WIDTH / 2 + 50) {
				if (mouseY >= 250 && mouseY <= 300) {
					click.soundFile();
					click.playSound();
					PongPanel.isBeginning = true;
					PongPanel.state = PongPanel.STATE.GAME;
				}
			}

			// help button
			if (mouseX >= PongPanel.WIDTH / 2 - 96 && mouseX <= PongPanel.WIDTH / 2 + 146) {
				if (mouseY >= 350 && mouseY <= 400) {
					click.soundFile();
					click.playSound();
					PongPanel.isInstructions = true;
					PongPanel.state = PongPanel.STATE.INSTRUCTIONS;
				}
			}
			
			//exit button
			//public Rectangle exitButton = new Rectangle(PongPanel.WIDTH-100, PongPanel.HEIGHT-75, 75, 50);
			if(mouseX >= PongPanel.WIDTH-100 && mouseX <= PongPanel.WIDTH-25) {
				if(mouseY >= PongPanel.HEIGHT-75 && mouseY <= PongPanel.HEIGHT-25) {
					click.soundFile();
					click.playSound();
					System.exit(1);
				}
			}
		}
		if (PongPanel.state != PongPanel.STATE.MENU) {
			//main menu button(s)
			if (mouseX >= 300 && mouseX <= 350) {
				if (mouseY >= 10 && mouseY <= 60) {
					click.soundFile();
					click.playSound();
					PongPanel.isBeginning = true;
					PongPanel.state = PongPanel.STATE.MENU;
				}
			}
			if(mouseX >= 425 && mouseX <= 575) {
				if(mouseY >= 450 && mouseY <= 500) {
					click.soundFile();
					click.playSound();
					PongPanel.isBeginning = true;
					PongPanel.state = PongPanel.STATE.MENU;
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
