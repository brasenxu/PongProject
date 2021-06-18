package pong;

import java.awt.*;
import java.awt.event.*;

public class AIpaddle extends Rectangle{
	
	int id;
	int yVelocity;
	Ball ball;
	
	AIpaddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, Ball b){
		//create rectangle object
		super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
		ball = b;
	}
	
	public void setYDirection() {
		
	}
	//updates position of rectangle
	public void move() {
		yVelocity = ball.yVelocity;
		y= y + yVelocity;
		System.out.println(y);
	}
	public void draw(Graphics g) {
		//set colour of rectangles
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}
}
