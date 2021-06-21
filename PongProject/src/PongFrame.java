//import needed packages
import java.awt.*;
import javax.swing.*;

//PongFrame class
public class PongFrame extends JFrame{
	PongPanel panel; //create PongPanel object
	
	/* constructor
	 * pre: none
	 * post: A PongFrame object has been created that creates the frame of the window
	 */
	PongFrame(){
		panel = new PongPanel(); //defines the PongPanel object
		this.add(panel); //add panel to frame
		this.setTitle("Pong Game"); //set title of window screen
		this.setResizable(false); //impossible to change size of frame
		this.setBackground(Color.black); //set background to black
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //frame can be closed
		this.pack(); //fits frame around the game screen
		this.setVisible(true); //make frame visible
		this.setLocationRelativeTo(null); //centers window to screen		
	}
}
