package model;

import java.util.Observable;
import java.util.Observer;

public abstract class ABall implements Observer{
	
	protected int x = 0;
	protected int y = 0;
	protected int size = 0;
	
	/**
	 * set constructors
	 */
	
	public ABall(int x, int y, int size){
		this.x=x;
		this.y=y;
		this.size=size;
	}
	
	public ABall(){};
	
	public void update(Observable arg0,Object arg1){};
	
}
