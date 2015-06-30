package view;

import java.awt.Graphics;
import java.util.Observable;

import model.ABall;

public class Dispatcher extends Observable{
	public static Dispatcher ballDispatcher = new Dispatcher();
	
	public static ABall loadBall(String className){
		try{
			int x = 0;
			int y = 0;
			int z = 0;
			Object[] args = new Object[]{x,y,z};
			java.lang.reflect.Constructor<?> cs[] = Class.forName(className).getConstructors();  // get all the constructors
	        java.lang.reflect.Constructor<?> c = null; 
	        for(int i=0;i < cs.length; i++) {  // find the first constructor with the right number of input parameters
	            if(args.length == (cs[i]).getParameterTypes().length) {
	                c = cs[i];
	                break;
	            	}  	
	        	}
	        return(ABall) c.newInstance(args);
			}
		catch(Exception ex){
			System.err.println("Class "+className+" failed to load. \nException = \n"+ ex);
		    ex.printStackTrace();  // print the stack trace to help in debugging.
		    return null;
		}
	}
	
	public void sendNotice(Graphics g){
		setChanged();
	    notifyObservers(g);// when the function run, send Graphics g to observers.
	}
}


