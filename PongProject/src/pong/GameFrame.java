package pong;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GameFrame extends JFrame{
	GamePanel panel; //create panel object
	
	//contructor method
	GameFrame(){
		panel = new GamePanel(); //define GamePanel object
		this.add(panel); //add panel to frame
		this.setTitle("Pong Game"); //set title of window
		this.setResizable(false); //does not allow resizable
		this.setBackground(Color.black); //set background to black
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack(); //fits frame around the game screen
		this.setVisible(true); //visible
		this.setLocationRelativeTo(null); //centers window to screen
		
	}
}
