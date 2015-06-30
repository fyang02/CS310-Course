package model;
/**
 *create sub class StraightBall.
 */

import java.awt.Color;
import java.util.Observable;
import java.util.Random;
import java.awt.Graphics;




public class StraightBall extends ABall{
	public StraightBall(int x, int y, int size){
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
	int speedMax = 10, speedMin = 5;
	int size = rand.nextInt(60)+20, x =100+rand.nextInt(300), y = 100+rand.nextInt(200);
	int speedX = rand.nextInt(speedMax-speedMin)+speedMin, speedY=rand.nextInt(speedMax-speedMin)+speedMin;
	int signX = 1,signY = 1;
	
	/**
	 * set Observer StraightBall update function.
	 */
	public void update(Observable arg0, Object arg1) {
		
		if (y>view.MainAppFrame.pnlAction.getHeight()-size){
			y = view.MainAppFrame.pnlAction.getHeight()-size;
			signY = signY * (-1);
		}// when the ball goes up or down out of the panelCenter, the sign of speedY change.
		if (y<0){
			y = 0;
			signY = signY * (-1);
		}
		if (x>view.MainAppFrame.pnlAction.getWidth()-size){
			x=view.MainAppFrame.pnlAction.getWidth()-size;
			signX = signX * (-1);
		}
		if (x<0){
			x = 0;
			signX = signX * (-1);
		}// when the ball goes right or left out of the panelCenter, the sign of speedX change.
		x = x+speedX*signX;// movement of x
		y = y+speedY*signY ;// movement of y
		
		/**
		 * paint the ball. 
		 */
		((Graphics)arg1).setColor(color);  
		((Graphics)arg1).fillOval(x, y, size, size); 
		
			
		
			
	}

}
