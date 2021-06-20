package pong;

import java.awt.*;
import java.awt.event.*;

public class AIpaddle extends Rectangle{
	
	int id;
	int yVelocity;
	int speed = 5; //set speed
	Ball ball;
	
	AIpaddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, Ball b){
		//create rectangle object
		super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
		ball = b;

	}
	
	//updates position of rectangle
	public void move() {		
		yVelocity = (int)((ball.yVelocity)/1.15);
		y= y + yVelocity;
	}
	
	public void draw(Graphics g) {
		//set colour of rectangles
		g.setColor(Color.orange);
		g.fillRect(x, y, width, height);
	}
}
