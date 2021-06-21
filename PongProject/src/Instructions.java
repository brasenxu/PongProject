
import java.awt.*;

public class Instructions {

	public Rectangle BackButton = new Rectangle(300, 10, 50, 50);
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		//create 2 fonts
		Font font1 = new Font("arial", Font.BOLD, 50);
		Font font2 = new Font("arial", Font.PLAIN, 24);
		Font font3 = new Font("arial", Font.PLAIN, 15);
		g.setFont(font1);
		
		g.setColor(Color.white); //set font colour to white
		g.drawString("Instructions", 358, 100); //title string
		
		g.setFont(font2);
		
		//label of buttons
		g.drawString("Move Cyan player paddle with 'w' and 's' keys",250 , 200 );
		g.drawString("If playing 1v1, move Yellow player with 'up' and 'down' arrows",170 ,250 );
		g.drawString("Hit the ball with the paddles to score in opponents ends", 210, 300);
		g.drawString("First player to score 10 goals WINS!",295 ,350 );
		g.drawString("Made by: Brasen & Nathan", 350, 475);
		g2d.draw(BackButton);
		
		g.setFont(font3);
		
		g.drawString("back",310 ,39 );
	}
	
	
}
