//import needed package
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

//Menu class
public class Menu {
	
	//create rectangles for the menu buttons
	public Rectangle aiButton = new Rectangle(PongPanel.WIDTH/2-50, 150, 100, 50); //singleplayer button
	public Rectangle playButton = new Rectangle(PongPanel.WIDTH/2-50, 250, 100, 50); //multiplayer button
	public Rectangle helpButton = new Rectangle(PongPanel.WIDTH/2-96, 350, 200, 50); //instructions button
	public Rectangle exitButton = new Rectangle(PongPanel.WIDTH-100, PongPanel.HEIGHT-75, 75, 50); //exit button
	
	/* draws the menu on the screen
	 * pre: none
	 * post: the main menu have been printed onto the screen
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g; //create a 2d graphics class
		
		//create 2 fonts for the menu
		Font font1 = new Font("arial", Font.BOLD, 50);
		Font font2 = new Font("arial", Font.PLAIN, 30);
		
		g.setFont(font1); //set the first font
		g.setColor(Color.white); //set font colour to white

		g.drawString("A Game of Pong", 300, 100); //title string
		
		g.setFont(font2); //set the second font	
		
		//draw rectangles
		g.setColor(Color.red); //set colour to red
		g2d.fill(exitButton); //draw red rectangle for exit button
		g.setColor(Color.white); //set colour to white
		
		//draw buttons
		g2d.draw(exitButton);
		g2d.draw(aiButton);
		g2d.draw(playButton);
		g2d.draw(helpButton);
		
		//button labels
		g.drawString("1 vs AI", aiButton.x + 5, aiButton.y + 37);
		g.drawString("1 vs 1", playButton.x + 10, playButton.y + 37);
		g.drawString("Intructions", helpButton.x + 29, helpButton.y + 37);
		g.drawString("EXIT", exitButton.x + 5, exitButton.y + 37);
		
		g.drawString("Made by: Brasen & Nathan", 325, 475);			
		
	}
}
