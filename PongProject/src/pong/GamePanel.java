package pong;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{
	
	//create variables needed
	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	static final int BALL_DIAMETER = 20;
	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 100;
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Paddle paddle1;
	Paddle paddle2;
	AIpaddle aiPaddle;
	Ball ball;
	Score score;
	Menu menu;
	Instructions instruct;
	Sound paddleSound;
	Sound wallSound;
	Sound scoreSound;
	Sound Menu;
	boolean isBeginning = true;
	
	//create enum
	public static enum STATE{
		MENU,
		AI,
		GAME,
		INSTRUCTIONS,
	};
	
	public static STATE state = STATE.MENU; //define enum, set it to menu
	
	GamePanel(){
		menu = new Menu(); //create menu object
		instruct = new Instructions();
		newBall(); //create ball object
		newPaddles(); //create paddle objects	
		newAI(); //create ai object
		score = new Score(GAME_WIDTH, GAME_HEIGHT); //create score object
		paddleSound = new Sound(".//res//PaddleSound.wav");
		wallSound = new Sound(".//res//WallSound.wav");
		scoreSound = new Sound(".//res//ScoreSound.wav");
		Menu = new Sound(".//res//Menu.wav");
		this.setFocusable(true);
		this.addKeyListener(new AL()); //create key listener
		this.setPreferredSize(SCREEN_SIZE);
		this.addMouseListener(new MouseInput()); //create mouse listener
		//start game thread
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	//new ball method
	public void newBall() {
		ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),(GAME_HEIGHT/2)-(BALL_DIAMETER/2),BALL_DIAMETER,BALL_DIAMETER);
	}
	
	//new paddle method
	public void newPaddles() {
		paddle1 = new Paddle(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
		paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
	}
	
	//new ai method
	public void newAI() {
		aiPaddle = new AIpaddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT, ball);
	}
	
	//paint method
	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics); //call draw method
		g.drawImage(image, 0, 0, this);
	}
	
	//draw method
	public void draw(Graphics g) {
		//if state is not menu, call the game
		if(state == STATE.GAME || state == STATE.AI) {
			//draws paddles, balls, and score
			paddle1.draw(g); 
			if(state == STATE.GAME) {
				paddle2.draw(g);
			}
			else if(state == STATE.AI) {
				aiPaddle.draw(g);
			}
			ball.draw(g);
			score.draw(g);
			Toolkit.getDefaultToolkit().sync(); //makes game smoother
		}
		else if(state == STATE.MENU) {
			score.player1 = 0;
			score.player2 = 0;
			ball.x = (GAME_WIDTH/2)-(BALL_DIAMETER/2);
			ball.y = (GAME_HEIGHT/2)-(BALL_DIAMETER/2);
			if(isBeginning) {
				Menu.soundFile();
				Menu.playSound();
				isBeginning = false;
			}
			menu.draw(g); //call menu
			
		}
		else  if (state == STATE.INSTRUCTIONS) //help screen
		{
			instruct.draw(g);
		}
	}
	
	//refreshes the location of the objects
	public void move() {
		if(state == STATE.GAME) {
			ball.move();
			paddle1.move();
			paddle2.move();			
		}
		else if(state == STATE.AI) {
			ball.move();
			paddle1.move();
			aiPaddle.move();
			//System.out.println(ball.y);
		}
	}
	
	//check object collision
	public void checkCollision() {
		
		//bounce ball off top & bottom window edges
		if(ball.y <=0) {
			ball.setYDirection(-ball.yVelocity);
			wallSound.soundFile();
			wallSound.playSound();
		}
		if(ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
			ball.setYDirection(-ball.yVelocity);
			wallSound.soundFile();
			wallSound.playSound();
		}
		
		//bounces ball off paddles
		if(ball.intersects(paddle1)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
			paddleSound.soundFile();
			paddleSound.playSound();
		}
		if(ball.intersects(paddle2)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
			paddleSound.soundFile();
			paddleSound.playSound();
		}
		if(ball.intersects(aiPaddle)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
			paddleSound.soundFile();
			paddleSound.playSound();
		}
		
		//stops paddles at window edges
		if(paddle1.y<=0) {
			paddle1.y=0;
		}
		if(paddle1.y>= (GAME_HEIGHT-PADDLE_HEIGHT)) {
			paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
		}
		if(paddle2.y<=0) {
			paddle2.y=0;
		}
		if(paddle2.y>= (GAME_HEIGHT-PADDLE_HEIGHT)) {
			paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
		}
		if(aiPaddle.y<=0) {
			aiPaddle.y=0;
		}
		if(aiPaddle.y>= (GAME_HEIGHT-PADDLE_HEIGHT)) {
			aiPaddle.y = GAME_HEIGHT-PADDLE_HEIGHT;
		}
		//give a player one point and creates new paddles & ball
		if(ball.x <= 0) {
			score.player2++;			
			scoreSound.soundFile();
			scoreSound.playSound();
			newBall();
			newPaddles();
			newAI();			
		}
		if(ball.x >= GAME_WIDTH-BALL_DIAMETER) {
			score.player1++;
			scoreSound.soundFile();
			scoreSound.playSound();
			newBall();
			newPaddles();
			newAI();			
		}
	}
	
	//run thread
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			if(delta >= 1) {
				if((state == STATE.GAME || state == STATE.AI) && (score.player1 < 10 && score.player2 < 10)) { 
					move();
					checkCollision();
					repaint();
					delta--;
				}
				else if(score.player1 == 10 || score.player2 == 10) {
					repaint();
					delta--;
				}
				else{
					repaint();
					delta--;
				}
			}
		}
	}
	
	//key adapter
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
	}
}
