
import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle{
	
	int id;
	int yVelocity;
	int speed = 10; //set speed
	
	Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
		//create rectangle object
		super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
		this.id = id;
	}
	
	//controls of paddle
	public void keyPressed(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode()==KeyEvent.VK_W) {
				setYDirection(-speed);
				move();
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYDirection(speed);
				move();
			}
			break;
		case 2:
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYDirection(-speed);
				move();
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYDirection(speed);
				move();
			}
			break;
		}
	}
	public void keyReleased(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode()==KeyEvent.VK_W) {
				setYDirection(0);
				move();
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYDirection(0);
				move();
			}
			break;
		case 2:
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYDirection(0);
				move();
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYDirection(0);
				move();
			}
			break;
		}
	}
	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}
	//updates position of rectangle
	public void move() {
		y= y + yVelocity;
	}
	public void draw(Graphics g) {
		//set colour of rectangles
		if(id==1)
			g.setColor(Color.cyan);
		else
			g.setColor(Color.orange); // I know it says orange, but it really looks like yellow. Too bad!
		g.fillRect(x, y, width, height);
	}
}
