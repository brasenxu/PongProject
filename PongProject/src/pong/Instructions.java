package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Instructions {

	
	public void draw(Graphics g) {
		//create 2 fonts
		Font font1 = new Font("arial", Font.BOLD, 50);
		Font font2 = new Font("arial", Font.PLAIN, 30);
		g.setFont(font1);
		g.setColor(Color.white); //set font colour to white

		g.drawString("Instructions", 358, 100); //title string
		
		g.setFont(font2);
		
		//label of buttons
		g.drawString("Move Blue player with 'w' and 's' keys",250 , 200 );
		g.drawString("Move Red player with 'up' and 'down' arrows",200 ,275 );
		g.drawString("First player to score 10 goals WINS!",273 ,350 );
		
		g.drawString("Made by: Brasen & Nathan", 325, 475);
	}
	
	
}
