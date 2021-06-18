package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball extends Rectangle{
	
	int xVelocity;
	int yVelocity;
	int initialSpeed = 5;
	
	//create ball object constructor
	Ball(int x, int y, int width, int height){
		super(x,y,width,height);

		//pick a random direction to go to
		int randomXDirection = (int)(Math.random()*2);
		if(randomXDirection == 0) {
			randomXDirection--;
		}
		setXDirection(randomXDirection*initialSpeed);
		
		int randomYDirection = (int)(Math.random()*2);
		if(randomYDirection == 0) {
			randomYDirection--;
		}
		setYDirection(randomYDirection*initialSpeed);
	}
	
	//move the ball
	public void setXDirection(int randomXDirection) {
		xVelocity = randomXDirection;
	}
	public void setYDirection(int randomYDirection) {
		yVelocity = randomYDirection;
	}
	public void move() {
		x += xVelocity;
		y += yVelocity;
	}
	//create the ball
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, height, width);
	}
}
