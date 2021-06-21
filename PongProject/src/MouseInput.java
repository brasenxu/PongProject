//import needed package
import java.awt.event.*;

//MouseInput class
public class MouseInput implements MouseListener {
	
	/* checks the location of mouse click, and implement codes
	 * pre: none
	 * post: the mouse click will run code depending on its location clicked
	 */
	public void mousePressed(MouseEvent e) {
		// get mouse click location
		int mouseX = e.getX();
		int mouseY = e.getY();
		//define Sound variable
		Sound click = new Sound(".//res//buttonClick.wav");
		
		//if the game state is in the menu
		if (PongPanel.state == PongPanel.STATE.MENU) {
			// ai Button
			if (mouseX >= PongPanel.WIDTH / 2 - 50 && mouseX <= PongPanel.WIDTH / 2 + 50) { //location of ai button
				if (mouseY >= 150 && mouseY <= 200) {
					//play mouse click sound
					click.soundFile();
					click.playSound();
					PongPanel.isBeginning = true; //set menu isBeginning back to true
					PongPanel.state = PongPanel.STATE.AI; //set game state to AI
				}
			}

			// 1v1 Button
			if (mouseX >= PongPanel.WIDTH / 2 - 50 && mouseX <= PongPanel.WIDTH / 2 + 50) { //location of 1v1 button
				if (mouseY >= 250 && mouseY <= 300) {
					//play mouse click sound
					click.soundFile();
					click.playSound();
					PongPanel.isBeginning = true; //set menu isBeginning back to true
					PongPanel.state = PongPanel.STATE.GAME; //set game state to 1v1 gamemode
				}
			}

			// help button
			if (mouseX >= PongPanel.WIDTH / 2 - 96 && mouseX <= PongPanel.WIDTH / 2 + 146) { //location of help button
				if (mouseY >= 350 && mouseY <= 400) {
					//play mouse click sound
					click.soundFile();
					click.playSound();
					PongPanel.isInstructions = true; //set menu isBeginning back to true
					PongPanel.state = PongPanel.STATE.INSTRUCTIONS; //set game state to instructions gamemode
				}
			}
			
			//exit button
			if(mouseX >= PongPanel.WIDTH-100 && mouseX <= PongPanel.WIDTH-25) { //location of exit button
				if(mouseY >= PongPanel.HEIGHT-75 && mouseY <= PongPanel.HEIGHT-25) {
					//play mouse click sound
					click.soundFile();
					click.playSound();
					System.exit(1); //exit program
				}
			}
		}
		//if game state is not the menu
		if (PongPanel.state != PongPanel.STATE.MENU) {
			//main menu button(s)
			if (mouseX >= 300 && mouseX <= 350) { //location of menu button
				if (mouseY >= 10 && mouseY <= 60) {
					//play mouse click sound
					click.soundFile();
					click.playSound();
					PongPanel.isBeginning = true; //set menu isBeginning back to true
					PongPanel.state = PongPanel.STATE.MENU; //set game state to menu gamemode
				}
			}
			if(mouseX >= 425 && mouseX <= 575) { //location of menu button
				if(mouseY >= 450 && mouseY <= 500) {
					//play mouse click sound
					click.soundFile();
					click.playSound();
					PongPanel.isBeginning = true; //set menu isBeginning back to true
					PongPanel.state = PongPanel.STATE.MENU; //set game state to menu gamemode
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
