//import needed package
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Graphics2D;

//Score class
public class Score extends Rectangle{
	
	//create variables needed in class
	static int width; //width of screen
	static int height; //height of screen
	int player1; //player 1 score
	int player2; //player 2 score
	boolean isEnd = true; //variable for ending sound
	Sound winnerSound; //end screen Sound object
	
	//create rectangles for the buttons
	public Rectangle BackButton = new Rectangle(300, 10, 50, 50);
	public Rectangle MenuButton = new Rectangle(425, 450, 150, 50);
	
	/* constructor
	 * pre: none
	 * post: creates a Score object with width and height. Also defines Sound object
	 */
	Score(int GAME_WIDTH, int GAME_HEIGHT){
		winnerSound = new Sound(".//res//Victory.wav"); //define sound object (call location of the sound file)
		//set width and height
		Score.width = GAME_WIDTH;
		Score.height = GAME_HEIGHT;
	}
	
	/* change the isEnd variable
	 * pre: none
	 * post: the isEnd variable has been changed to End
	 */
	public void setEnd(boolean End) {
		isEnd = End;
	}
	
	/* draws the menu on the screen
	 * pre: none
	 * post: the main menu have been printed onto the screen
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g; //create a 2d graphics class
		
		//create 3 fonts
		Font font1 = new Font("Consolas", Font.PLAIN,60);
		Font font2 = new Font("arial", Font.PLAIN, 15);
		Font font3 = new Font("arial", Font.PLAIN, 27);
				
		g.setFont(font1); //set the first font
		g.setColor(Color.white); //set font colour to white
		
		g.drawLine(width/2, 0, width/2, height); //draw a line across the middle of the screen
		
		//draw player score
		g.drawString(String.valueOf(player1/10) + String.valueOf(player1%10), (width/2)-85, 50);
		g.drawString(String.valueOf(player2/10) + String.valueOf(player2%10), (width/2)+20, 50);
		
		//if a player gets 10 points
		if(player1 == 10) { //if player 1 wins
			g.drawString("Player Blue WINS", (width/2)-250, 240); //draw end string
			if(isEnd) { //if isEnd is true, play the winnerSound, and set isEnd to false to prevent repeat plays
				winnerSound.soundFile();
				winnerSound.playSound();
				isEnd = false;
			}
			g2d.draw(MenuButton); //draw menu button
			g.setColor(Color.white); //set colour to white
			g2d.fill(MenuButton); //fill menu button with white
			g.setColor(Color.black); //set colour to black
			g.setFont(font3); //set the third font
			g.drawString("Main Menu",MenuButton.x + 10,MenuButton.y + 30); //label the menu button
		}
		else if(player2 == 10) { //if player 2 wins
			g.drawString("Player Yellow WINS", (width/2)-265, 240); //draw end string
			if(isEnd) { //if isEnd is true, play the winnerSound, and set isEnd to false to prevent repeat plays
				winnerSound.soundFile();
				winnerSound.playSound();
				isEnd = false;
			}
			g2d.draw(MenuButton); //draw menu button
			g.setColor(Color.white); //set colour to white
			g2d.fill(MenuButton); //fill menu button with white
			g.setColor(Color.black); //set colour to black
			g.setFont(font3); //set the third font
			g.drawString("Main Menu",MenuButton.x + 10,MenuButton.y + 30); //label the menu button
			
		}
		else {
			g2d.draw(BackButton); //draw back button	
			g.setFont(font2); //set the second font
			g.drawString("back",310 ,39 ); //label the back button
		}
	}
}
