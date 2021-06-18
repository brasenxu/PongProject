package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Graphics2D;

public class Score extends Rectangle{
	
	public Rectangle BackButton = new Rectangle(300, 10, 50, 50);
	static int GAME_WIDTH;
	static int GAME_HEIGHT;
	int player1;
	int player2;
	
	Score(int GAME_WIDTH, int GAME_HEIGHT){
		Score.GAME_WIDTH = GAME_WIDTH;
		Score.GAME_HEIGHT = GAME_HEIGHT;
	}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		//set font and colour
		g.setColor(Color.white);
		g.setFont(new Font("Consolas", Font.PLAIN,60));
		Font font3 = new Font("arial", Font.PLAIN, 15);
		g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT); //draw middle line
		
		//draw player score
		g.drawString(String.valueOf(player1/10) + String.valueOf(player1%10), (GAME_WIDTH/2)-85, 50);
		g.drawString(String.valueOf(player2/10) + String.valueOf(player2%10), (GAME_WIDTH/2)+20, 50);
		
		g2d.draw(BackButton);
		
		g.setFont(font3);
		
		g.drawString("back",310 ,39 );
		
	}
}
