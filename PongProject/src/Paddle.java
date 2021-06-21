//import needed package
import java.awt.*;
import java.awt.event.*;

//Paddle class 
public class Paddle extends Rectangle{
	
	//define variables needed in class
	int id; //whether or not the paddle is for player 1 or 2
	int yVelocity; //direction of the paddle (y direction)
	int speed = 10; //set speed of paddles
	
	/* constructor
	 * pre: none
	 * post: A Paddle object has been created with values x, y, PADDLE_WIDTH, PADDLE_HEIGHT, and also an id variable
	 */
	Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
		//create rectangle object
		super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
		this.id = id; //set id of paddle
	}
	
	/* invoked when a key has been pressed
	 * pre: none
	 * post: when a key is pressed, the paddle will move either up or down
	 */
	public void keyPressed(KeyEvent e) {
		//switch case for id
		switch(id) {
		case 1: //if id == 1 (player 1)
			if(e.getKeyCode()==KeyEvent.VK_W) { //if the key pressed is w
				setYDirection(-speed); //the y direction goes up 
				move(); //update position
			}
			if(e.getKeyCode()==KeyEvent.VK_S) { //if the key pressed is s
				setYDirection(speed); //the y direction goes down
				move(); //update position
			}
			break;
		case 2: //if id == 2 (player 2)
			if(e.getKeyCode()==KeyEvent.VK_UP) { //if the key pressed is [up arrow]
				setYDirection(-speed); //the y direction goes up 
				move(); //update position
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) { //if the key pressed is [down arrow]
				setYDirection(speed); //the y direction goes down
				move(); //update position
			}
			break;
		}
	}
	
	/* invoked when a key has been released
	 * pre: none
	 * post: after a key is released, the direction returns to 0;
	 */
	public void keyReleased(KeyEvent e) {
		//switch case for id
		switch(id) {
		case 1: //if id == 1 (player 1)
			if(e.getKeyCode()==KeyEvent.VK_W) { //if the key released is w
				setYDirection(0); //direction is 0 
				move(); //update position
			}
			if(e.getKeyCode()==KeyEvent.VK_S) { //if the key released is s
				setYDirection(0); //direction is 0 
				move(); //update position
			}
			break;
		case 2:
			if(e.getKeyCode()==KeyEvent.VK_UP) { //if the key released is [up arrow]
				setYDirection(0); //direction is 0 
				move(); //update position
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) { //if the key released is [down arrow]
				setYDirection(0); //direction is 0 
				move(); //update position
			}
			break;
		}
	}
	
	/* set velocity of the paddle
	 * pre: none
	 * post: the yVelocity is set equal to the yDirection
	 */
	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}
	
	/* updates the position of rectangle
	 * pre: none
	 * post: the location of the rectangle has been changed
	 */
	public void move() {
		y= y + yVelocity;
	}
	
	/* draws the rectangle paddle on the screen
	 * pre: none
	 * post: the filled rectangle has been drawn, and has a different colour depending of paddle 1 or 2 (cyan or orange/yellow)
	 */
	public void draw(Graphics g) {
		//set colour of rectangles
		if(id==1) //if it is paddle 1
			g.setColor(Color.cyan);
		else
			g.setColor(Color.orange); // I know it says orange, but it really looks like yellow. Too bad!
		//draw rectangle
		g.fillRect(x, y, width, height);
	}
}
