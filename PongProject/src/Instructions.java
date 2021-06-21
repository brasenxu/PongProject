//import needed package
import java.awt.*;

//Instructions class
public class Instructions {
	
	//create rectangle for the back button
	public Rectangle BackButton = new Rectangle(300, 10, 50, 50);
	
	/* writes the instructions on the screen
	 * pre: none
	 * post: instructions have been printed onto the screen
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g; //create a 2d graphics class
		
		//create 3 fonts for the instructions
		Font font1 = new Font("arial", Font.BOLD, 50);
		Font font2 = new Font("arial", Font.PLAIN, 24);
		Font font3 = new Font("arial", Font.PLAIN, 15);
				
		g.setFont(font1); //set the first font		
		g.setColor(Color.white); //set font colour to white
		
		g.drawString("Instructions", 358, 100); //title string
		
		g.setFont(font2); //set the second font	
		
		//instructions 
		g.drawString("Move Cyan player paddle with 'w' and 's' keys",250 , 200 );
		g.drawString("If playing 1v1, move Yellow player with 'up' and 'down' arrows",170 ,250 );
		g.drawString("Hit the ball with the paddles to score in opponents ends", 210, 300);
		g.drawString("First player to score 10 goals WINS!",295 ,350 );
		g.drawString("Made by: Brasen & Nathan", 350, 475);
		
		//draw back button
		g2d.draw(BackButton);
		
		g.setFont(font3); //set the third font	
		
		g.drawString("back",310 ,39 ); //draw the back button label
	}	
}
