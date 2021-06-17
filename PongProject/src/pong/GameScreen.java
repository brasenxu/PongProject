package pong;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GameScreen extends JFrame implements KeyListener {
	
	 	private static int WINDOWWIDTH = 1000;
	    private static int WINDOWHEIGHT = 1000;
	    private static int RECTWIDTH1 = 50;
	    private static int RECTWIDTH2 = 50;
	    private static int RECTHEIGHT1 = 250;
	    private static int RECTHEIGHT2 = 250;
	    private double xValue1;
	    private double yValue1;
	    private double yVelocity1;
	    private double xValue2;
	    private double yValue2;
	    private double yVelocity2;
	
	
	public GameScreen(){
		
		super("Pong");
		xValue1 = 0;
		yValue1 = 0;
		xValue2 = WINDOWWIDTH-RECTWIDTH2;
		yValue2 = 0;
		yVelocity1 = 0;
		yVelocity2 = 0;
		addKeyListener(this);
	}
	
	public void keyTyped(KeyEvent e) {
	
		if(e.getKeyChar() == 'i') {
            yVelocity2 = -0.5;
        }
        else if(e.getKeyChar() == 'k') {
            yVelocity2 = 0.5;
        }
        else if(e.getKeyChar() == 'w') {
            yVelocity1 = -0.5;
        }
        else if(e.getKeyChar() == 's') {
            yVelocity1 = 0.5;
        }
	}
	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar() == 'i' || e.getKeyChar() == 'k'){
			yVelocity2 = 0;	
		}
		if(e.getKeyChar() == 'w' || e.getKeyChar() == 's'){
			yVelocity1 = 0;	
		}	
	}
	
	public void keyPressed(KeyEvent e) {
	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, WINDOWWIDTH, WINDOWHEIGHT);
		g.fillRect((int)xValue1, (int)yValue1, RECTWIDTH1, RECTHEIGHT1);
		g.fillRect((int)xValue2, (int)yValue2, RECTWIDTH2, RECTHEIGHT2);
		
		movement();
		repaint();
	}
	public void movement() {
		if (yValue1 < 0) {
			yValue1 = 1;
		}
		else if (yValue2 < 0) {
			yValue2 = 1;
		}
		else if (yValue1 > WINDOWHEIGHT-RECTHEIGHT1) {
			yValue1 = WINDOWHEIGHT-(2*RECTHEIGHT1);
		}
		else if (yValue2 > WINDOWHEIGHT-RECTHEIGHT2) {
			yValue2 = WINDOWHEIGHT-(2*RECTHEIGHT2);
		}
		else {
			yValue1 += yVelocity1;
			yValue2 += yVelocity2;
		}
			
	}
		
	public static void main(String [] args) {
		GameScreen screen = new GameScreen();
		screen.setSize(WINDOWWIDTH, WINDOWHEIGHT);
        screen.setLocationRelativeTo(null);
        screen.setResizable(false); 
        screen.setVisible(true); 
        screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	
		
	}
	

