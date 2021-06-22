//import needed package
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//PongPanel class
public class PongPanel extends JPanel implements Runnable{
	
	//create variables needed in class
	static final int WIDTH = 1000; //width of the screen
	static final int HEIGHT = 555; //height of the screen
	static final Dimension SCREEN_SIZE = new Dimension(WIDTH, HEIGHT); //size of screen
	static final int BALL_DIAMETER = 20; //diameter of the ball
	static final int PADDLE_WIDTH = 25; //width of paddle
	static final int PADDLE_HEIGHT = 100; //height of paddle
	Thread gameThread; //create Thread object
	Image image; //create Image object
	Graphics graphics; //create Graphics object
	//create Paddle pbjects
	Paddle paddle1; 
	Paddle paddle2;
	AIpaddle aiPaddle; //create AIpaddle object
	Ball ball; //create Ball object
	Score score; //create Score object
	Menu menu; //create Menu object
	Instructions instruct; //create Instructions object
	//create sound objects
	Sound paddleSound; 
	Sound wallSound;
	Sound scoreSound;
	Sound Menu;
	Sound Instructions;
	
	//create boolean variables for menu/intructions bgm
	static boolean isInstructions = true;
	static boolean isBeginning = true;
	
	//create enum to track state
	public static enum STATE{
		MENU,
		AI,
		GAME,
		INSTRUCTIONS,
	};
	
	public static STATE state = STATE.MENU; //define enum state and set it to menu first
	
	/* constructor
	 * pre: none
	 * post: defines all the objects needed in the game
	 */
	PongPanel(){
		menu = new Menu(); //create menu object
		instruct = new Instructions(); //create instructions object
		newBall(); //create ball object
		newPaddles(); //create paddle objects	
		newAI(); //create AI object
		score = new Score(WIDTH, HEIGHT); //create score object
		//define sound objects (call location of the sound files)
		paddleSound = new Sound(".//res//PaddleSound.wav");
		wallSound = new Sound(".//res//WallSound.wav");
		scoreSound = new Sound(".//res//ScoreSound.wav");
		Menu = new Sound(".//res//MenuMusic.wav");
		Instructions = new Sound(".//res//InstructionsSong.wav");
		this.setFocusable(true); //set focus to panel (allows KeyEvent)
		this.addKeyListener(new AL()); //create key listener
		this.setPreferredSize(SCREEN_SIZE); //set size of panel
		this.addMouseListener(new MouseInput()); //create mouse listener
		//start game thread
		gameThread = new Thread(this);
		gameThread.start();
	}
		
	/* defines the ball object
	 * pre: none
	 * post: the ball object has been defined
	 */
	public void newBall() {
		ball = new Ball((WIDTH/2)-(BALL_DIAMETER/2),(HEIGHT/2)-(BALL_DIAMETER/2),BALL_DIAMETER,BALL_DIAMETER);
	}
	
	/* defines the paddle objects
	 * pre: none
	 * post: the 2 paddle objects have been defined
	 */
	public void newPaddles() {
		paddle1 = new Paddle(0,(HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
		paddle2 = new Paddle(WIDTH-PADDLE_WIDTH,(HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
	}
	
	/* defines the AI paddle object
	 * pre: none
	 * post: the AI paddle object has been defined
	 */
	public void newAI() {
		aiPaddle = new AIpaddle(WIDTH-PADDLE_WIDTH,(HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT, ball);
	}
	
	/* overrides existing paint method
	 * pre: none
	 * post: paints the panel
	 */
	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight()); //creates image object
		graphics = image.getGraphics(); //set graphics object
		draw(graphics); //call draw method
		g.drawImage(image, 0, 0, this); //draws the image
	}
	
	/* draws the game
	 * pre: none
	 * post: depending on what state the game is in, various draw methods (from different classes) will be called
	 */
	public void draw(Graphics g) {
		//if state is game or AI
		if(state == STATE.GAME || state == STATE.AI) {
			Menu.stop(); //stop any menu music from playing
			//draws paddles, balls, and score
			paddle1.draw(g); 
			if(state == STATE.GAME) { //if multiplayer, draw the second paddle
				paddle2.draw(g);
			}
			else if(state == STATE.AI) { //if singleplayer, draw the AI paddle
				aiPaddle.draw(g);
			}
			ball.draw(g); //draw the ball
			score.draw(g); //draw the score
			Toolkit.getDefaultToolkit().sync(); //makes game smoother
		}
		//if state is menu
		else if(state == STATE.MENU) {
			if(!isInstructions) { //if the program has visited instructions (instructions music playing)
				Instructions.stop(); //stop the instruction music
			}
			//set both player score back to 0
			score.player1 = 0;
			score.player2 = 0;
			//set ball position back to start
			ball.x = (WIDTH/2)-(BALL_DIAMETER/2);
			ball.y = (HEIGHT/2)-(BALL_DIAMETER/2);
			//set paddle position back to start
			paddle1.y = (HEIGHT/2)-(PADDLE_HEIGHT/2);
			paddle2.y = (HEIGHT/2)-(PADDLE_HEIGHT/2);
			aiPaddle.y = (HEIGHT/2)-(PADDLE_HEIGHT/2);
			if(isBeginning) { //only plays the menu music once, and loops that (until a Menu.stop() is called)
				Menu.soundFile();
				Menu.playSound();
				Menu.loop();
				isBeginning = false;
			}
			score.setEnd(true); //set the score ending back to true so that the end screen can happen
			menu.draw(g); //call menu 
		}
		//if state is instructions
		else  if (state == STATE.INSTRUCTIONS) {
			Menu.stop(); //stop menu music
			if(isInstructions) { //only plays the instruction music once, and loops that (until a Instructions.stop() is called)
				Instructions.soundFile();
				Instructions.playSound();
				Instructions.loop();
				isInstructions = false;
			}
			instruct.draw(g); //calls instructions
		}
	}
	
	/* updates the positions of the objects
	 * pre: none
	 * post: the locations of the ball and the paddles have been changed
	 */
	public void move() {
		//if state is multiplayer, update both player paddles (and ball)
		if(state == STATE.GAME) { 
			ball.move();
			paddle1.move();
			paddle2.move();			
		}
		//if state is singleplayer, update player paddle and AI paddle (and ball)
		else if(state == STATE.AI) {
			ball.move();
			paddle1.move();
			aiPaddle.move();
		}
	}
	
	/* checks for object collision between objects/boundaries
	 * pre: none
	 * post: if collision, the location of the objects are changed
	 */
	public void checkCollision() {		
		//bounce ball off top & bottom window edges
		if(ball.y <=0) {
			ball.setYDirection(-ball.yVelocity);
			//play wall bounce sound
			wallSound.soundFile();
			wallSound.playSound();
		}
		if(ball.y >= HEIGHT-BALL_DIAMETER) {
			ball.setYDirection(-ball.yVelocity);
			//play wall bounce sound
			wallSound.soundFile();
			wallSound.playSound();
		}
		
		//bounces ball off paddles
		if(ball.intersects(paddle1)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
			//play paddle bounce sound
			paddleSound.soundFile();
			paddleSound.playSound();
		}
		if(ball.intersects(paddle2) && state == STATE.GAME) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
			//play paddle bounce sound
			paddleSound.soundFile();
			paddleSound.playSound();
		}
		if(ball.intersects(aiPaddle) && state == STATE.AI) {	
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
			//play paddle bounce sound
			paddleSound.soundFile();
			paddleSound.playSound();
		}
		
		//stops paddles at window edges (update position of paddles)
		if(paddle1.y<=0) {
			paddle1.y=0; //change paddle position
		}
		if(paddle1.y>= (HEIGHT-PADDLE_HEIGHT)) {
			paddle1.y = HEIGHT-PADDLE_HEIGHT; //change paddle position
		}
		if(paddle2.y<=0) {
			paddle2.y=0; //change paddle position
		}
		if(paddle2.y>= (HEIGHT-PADDLE_HEIGHT)) {
			paddle2.y = HEIGHT-PADDLE_HEIGHT; //change paddle position
		}
		if(aiPaddle.y<=0) {
			aiPaddle.y=0; //change paddle position
		}
		if(aiPaddle.y>= (HEIGHT-PADDLE_HEIGHT)) {
			aiPaddle.y = HEIGHT-PADDLE_HEIGHT; //change paddle position
		}
		
		//If ball goes past the left/right screen, 
		//give a player one point and creates new paddles & ball
		if(ball.x <= -1) {
			score.player2++; //update score for player 2			
			//play score sound
			scoreSound.soundFile();
			scoreSound.playSound();
			//creates new paddles/ball
			newBall();
			newPaddles();
			newAI();			
		}
		if(ball.x >= WIDTH-BALL_DIAMETER + 1) {
			score.player1++; //update score for player 1
			//play score sound
			scoreSound.soundFile();
			scoreSound.playSound();
			//creates new paddles/ball
			newBall();
			newPaddles();
			newAI();			
		}
	}
	
	/* run thread method
	 * pre: none
	 * post: constantly updates, allowing for constant refresh of repaint;
	 * also allows for constant check of collision and update position
	 */
	public void run() {
		long lastTime = System.nanoTime(); //get nano time
		double amountOfTicks = 60.0; //set amount of ticks
		double ns = 1000000000 / amountOfTicks; //set nanoseconds (1 billion / 60)
		double delta = 0;
		while(true) { //run while game is running
			long now = System.nanoTime(); //tracks time now
			delta += (now - lastTime)/ns; //add the difference from now and lasttime divided by nano seconds to delta
			lastTime = now; //change last time to now
			if(delta >= 1) { 
				if((state == STATE.GAME || state == STATE.AI) && (score.player1 < 10 && score.player2 < 10)) { //if the game is running
					//update position and collision
					move();
					checkCollision();
					repaint(); //repaint screen
					delta--;
				}
				else if(score.player1 == 10 || score.player2 == 10) { //if the game is over
					repaint(); //repaint screen
					delta--;
				}
				else{ //in menu or instructions
					repaint(); //repaint screen
					delta--;
				}
			}
		}
	}
	
	//ActionListener class for tracking keyboard inputs
	public class AL extends KeyAdapter{
		
		/* invoked when a key has been pressed
		 * pre: none
		 * post: calls the keyPressed of the Paddle class
		 */
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}
		
		/* invoked when a key has been released
		 * pre: none
		 * post: calls the keyReleased of the Paddle class
		 */
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
	}
}
