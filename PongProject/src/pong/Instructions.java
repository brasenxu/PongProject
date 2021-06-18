package pong;

import java.awt.*;

public class Instructions {

	public Rectangle BackButton = new Rectangle(300, 10, 50, 50);
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		//create 2 fonts
		Font font1 = new Font("arial", Font.BOLD, 50);
		Font font2 = new Font("arial", Font.PLAIN, 30);
		Font font3 = new Font("arial", Font.PLAIN, 15);
		g.setFont(font1);
		
		g.setColor(Color.white); //set font colour to white
		g.drawString("Instructions", 358, 100); //title string
		
		g.setFont(font2);
		
		//label of buttons
		g.drawString("Move Blue player with 'w' and 's' keys",250 , 200 );
		g.drawString("Move Red player with 'up' and 'down' arrows",200 ,275 );
		g.drawString("First player to score 10 goals WINS!",273 ,350 );
		g.drawString("Made by: Brasen & Nathan", 325, 475);
		g2d.draw(BackButton);
		
		g.setFont(font3);
		
		g.drawString("back",310 ,39 );
	}
	
	
}
