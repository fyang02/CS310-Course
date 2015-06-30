/**
 *create sub class BreathingBall.
 */
package model;

import java.awt.Color;
import java.util.Observable;
import java.util.Random;
import java.awt.Graphics;



public class BreathingBall extends ABall{
	/**
	 *set constructor.
	 */
	public BreathingBall(int x, int y, int size){
		super(x,y,size);	
	}
	
	/**
	 * create random color。
	 */
	Random rand = new Random();
	float r = rand.nextFloat();
	float g = rand.nextFloat();
	float b = rand.nextFloat();
	Color color = new Color(r, g, b);
	
	/**
	 * Variables declaration
	 */
	int sizeMax = 80, sizeMin = 20, speedMax = 10, speedMin = 5;
	int size = rand.nextInt(sizeMax-sizeMin)+sizeMin, x =100+rand.nextInt(300), y = 100+rand.nextInt(200);
	int speedX = rand.nextInt(speedMax-speedMin)+speedMin, speedY=rand.nextInt(speedMax-speedMin)+speedMin;
	int signX = 1,signY = 1, sign = 1;
	
	/**
	 * set Observer BreathingBall update function.
	 */
	public void update(Observable arg0, Object arg1) {
		if (x>view.MainAppFrame.pnlAction.getWidth()-size  || x<0){
			signX = signX * (-1);
		}// when the ball goes right or left out of the panelCenter, the sign of speedX change.
		if (y<0 || y>view.MainAppFrame.pnlAction.getHeight()-size){
			signY = signY * (-1);
		}// when the ball goes up or down out of the panelCenter, the sign of speedY change.
		x = x+speedX*signX; // movement of x
		y = y+speedY*signY; // movement of y
		
		/**
		 * set size of the ball, change cyclically from sizeMax to sizeMin.
		 */
		if (size>sizeMax|| size<sizeMin){
			sign = sign * (-1);
		}
		size = size+2*sign;
		
		/**
		 * paint the ball. random color. location(x,y);
		 */
		((Graphics)arg1).setColor(color);  
		((Graphics)arg1).fillOval(x, y, size, size); 
		
			
		
			
	}

}
