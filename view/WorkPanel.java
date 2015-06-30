package view;

import javax.swing.*;

import java.awt.*;


public class WorkPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8672209849103068554L;

	public void paint(Graphics g){
	super.paint(g);
	g.setColor(Color.blue);
	Dispatcher.ballDispatcher.sendNotice(g);
	}
}
