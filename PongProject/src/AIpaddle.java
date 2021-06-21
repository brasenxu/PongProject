//import needed package
import java.awt.*;

//AI paddle class 
public class AIpaddle extends Rectangle{
	
	//define variables needed in class
	int yVelocity; //direction of the paddle (y direction)
	Ball ball; //set ball class variable
	
	/* constructor
	 * pre: none
	 * post: An AIpaddle object has been created with values x, y, PADDLE_WIDTH, PADDLE_HEIGHT, and a Ball variable ball
	 */
	AIpaddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, Ball b){
		//create rectangle object
		super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
		ball = b; //set ball to b
	}
	
	/* updates the position of rectangle
	 * pre: none
	 * post: the location of the rectangle has been changed
	 */
	public void move() {		
		yVelocity = (int)((ball.yVelocity)/1.25);
		y= y + yVelocity;
	}
	
	/* draws the rectangle paddle on the screen
	 * pre: none
	 * post: the filled rectangle has been drawn, and has a colour of orange (looks yellow in the game screen)
	 */
	public void draw(Graphics g) {
		//set colour of rectangle
		g.setColor(Color.orange);
		//draw rectangle
		g.fillRect(x, y, width, height);
	}
}
