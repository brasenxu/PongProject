//import needed packages
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

//Ball class 
public class Ball extends Rectangle{
	
	//define variables needed in class
	int xVelocity; //direction of x value
	int yVelocity; //direction of y value
	int initialSpeed = 7; //speed of the ball
	
	/* constructor
	 * pre: none
	 * post: A Ball object has been created with values of x, y, width, and height
	 */
	Ball(int x, int y, int width, int height){
		//create rectangle object with these values
		super(x,y,width,height); 

		//pick a random x direction to go to
		int randomXDirection = (int)(Math.random()*2);
		if(randomXDirection == 0) {
			randomXDirection--; //direction would be negative
		}
		setXDirection(randomXDirection*initialSpeed); //by multiplying with initialSpeed, the speed of the ball can be set
		
		//pick a random x direction to go to
		int randomYDirection = (int)(Math.random()*2);
		if(randomYDirection == 0) {
			randomYDirection--; //direction would be negative
		}
		setYDirection(randomYDirection*initialSpeed); //by multiplying with initialSpeed, the speed of the ball can be set
	}
	
	/* sets the x direction of the ball
	 * pre: none
	 * post: the x direction of the rectangle (ball) has been changed
	 */
	public void setXDirection(int randomXDirection) {
		xVelocity = randomXDirection; //sets the x direction to go either right or left
	}
	
	/* sets the y direction of the ball
	 * pre: none
	 * post: the y direction of the rectangle (ball) has been changed
	 */
	public void setYDirection(int randomYDirection) {
		yVelocity = randomYDirection; //sets the y direction to go either up or down
	}
	
	/* updates the ball position
	 * pre: none
	 * post: location of the ball is changed
	 */
	public void move() {
		//adds the direction to the x/y values
		x += xVelocity; 
		y += yVelocity;
	}
	
	/* draws the ball on the screen
	 * pre: none
	 * post: the filled ball shape has been drawn, and has a colour of white
	 */
	public void draw(Graphics g) {
		//set colour to white
		g.setColor(Color.white); 
		//draw circle
		g.fillOval(x, y, height, width);
	}
}
