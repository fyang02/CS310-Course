package model;
/**
 *create sub class CurveBall.
 */

import java.awt.Color;
import java.util.Observable;
import java.util.Random;
import java.awt.Graphics;
import java.lang.Math;




public class CurveBall extends ABall{
	
	public CurveBall(int x, int y, int size){
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
	int size = rand.nextInt(60)+20, x =100+rand.nextInt(600), y = 100+rand.nextInt(400);
	int speedX = rand.nextInt(speedMax-speedMin)+speedMin, speedY=rand.nextInt(speedMax-speedMin)+speedMin;
	int signX = 1,signY = 1, R = 300;
	double x1, y1, theta = 0, speedTheta = 0.02;
	int centerX = x, centerY = y;
	
	/**
	 * set Observer CurveBall update function.
	 */
	public void update(Observable arg0, Object arg1) {
		if (centerY>0-R && centerX>0-R && centerX<view.MainAppFrame.pnlAction.getWidth()+R && centerY<view.MainAppFrame.pnlAction.getHeight()+R){
			if (x>view.MainAppFrame.pnlAction.getWidth()-size){
				centerY = centerY - Math.abs((int)(2*R*Math.sin(theta)));
				theta = 0-theta+speedTheta*2;
				
			}// when the ball goes right out of the panelCenter, centerY location and theta changes.
			if (x<0){
				centerY = centerY + Math.abs((int)(2*R*Math.sin(theta)));
				theta = 0-theta+speedTheta*2;
				
			}// when the ball goes left out of the panelCenter, centerY location and theta changes.
			if (y<0){
				centerX = centerX - Math.abs((int)(2*R*Math.cos(theta)));
				theta = 3.14-theta+speedTheta*2;
				
			}// when the ball goes up out of the panelCenter, centerY location and theta changes.
			if (y>view.MainAppFrame.pnlAction.getHeight()-size){
				centerX = centerX + Math.abs((int)(2*R*Math.cos(theta)));
				theta = 3.14-theta+speedTheta*2;
			}// when the ball goes down out of the panelCenter, centerY location and theta changes.
			
		}
		else {centerX = 0; centerY = 0;}
		
		x = centerX+(int)(R*Math.cos(theta));
		y = centerY+(int)(R*(Math.sin(theta)));
		theta = theta+speedTheta;
		((Graphics)arg1).setColor(color);  
		((Graphics)arg1).fillOval(x, y, size, size); 
		
			
		
			
	}

}
