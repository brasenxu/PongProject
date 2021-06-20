package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Graphics2D;

public class Score extends Rectangle{
	
	public Rectangle BackButton = new Rectangle(300, 10, 50, 50);
	public Rectangle MenuButton = new Rectangle(425, 450, 150, 50);
	static int width;
	static int height;
	int player1;
	int player2;
	
	Score(int GAME_WIDTH, int GAME_HEIGHT){
		Score.width = GAME_WIDTH;
		Score.height = GAME_HEIGHT;
	}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		//set font and colour
		g.setColor(Color.white);
		g.setFont(new Font("Consolas", Font.PLAIN,60));
		Font font3 = new Font("arial", Font.PLAIN, 15);
		Font font4 = new Font("arial", Font.PLAIN, 27);
		g.drawLine(width/2, 0, width/2, height); //draw middle line
		
		//draw player score
		g.drawString(String.valueOf(player1/10) + String.valueOf(player1%10), (width/2)-85, 50);
		g.drawString(String.valueOf(player2/10) + String.valueOf(player2%10), (width/2)+20, 50);
		
		
		
		if(player1 == 10) {
			g.drawString("Player 1 wins!", (width/2)-245, 240);
			g2d.draw(MenuButton);
			g.setColor(Color.white);
			g2d.fill(MenuButton);
			g.setColor(Color.black);
			g.setFont(font4);
			g.drawString("Main Menu",MenuButton.x + 10,MenuButton.y + 30);
		}
		else if(player2 == 10) {
			g.drawString("Player 2 wins!", (width/2)-245, 240);
			g2d.draw(MenuButton);
			g.setColor(Color.white);
			g2d.fill(MenuButton);
			g.setColor(Color.black);
			g.setFont(font4);
			g.drawString("Main Menu",MenuButton.x + 10,MenuButton.y + 30);
			
		}
		else {
			g2d.draw(BackButton);	
			g.setFont(font3);
			g.drawString("back",310 ,39 );
		}
	}
}
