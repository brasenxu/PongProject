package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Intructions {

	
	public void draw(Graphics g) {
		
		//create 2 fonts
		Font font1 = new Font("arial", Font.BOLD, 50);
		Font font2 = new Font("arial", Font.PLAIN, 30);
		g.setFont(font1);
		g.setColor(Color.white); //set font colour to white

		g.drawString("Instructions", 300, 100); //title string
		
		g.setFont(font2);
		
		//label of buttons
		g.drawString("Move Blue player with 'w' and 's' keys",0 , 30 );
		g.drawString("Move Red player with 'up' and 'down' arrows",0 ,50 );
		g.drawString("First player to score 10 goals WINS!",0 ,70 );
		
		g.drawString("Made by: Brasen & Nathan", 325, 475);
	}
	
	
}
