package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.*;

import view.WorkPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.ABall;


public class MainAppFrame extends JFrame {

	
	private static final long serialVersionUID = 3201143438944922719L;
	private JPanel contentPane;
	private JPanel pnlControl = new JPanel();
	private JButton btnCreate = new JButton("Create new Ball");
	private JButton btnClear = new JButton("Clear");
	public static WorkPanel pnlAction = new WorkPanel();
	public Color color = new Color(255,255,255);
	private String type; 
	public Graphics g;
	
	private String[] types = {"model.BreathingBall","model.ColorChangingBall","model.CurveBall","model.StraightBall"};
	private JComboBox box = new JComboBox(types);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainAppFrame frame = new MainAppFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void start(){
		setVisible(true);
	}
		
	
	/**
	 * Create the frame.
	 */
	public MainAppFrame() {
		intiGUI();
	}
	
	
	public void intiGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		/**
		 *  Create the content panel.
		 */
		
		pnlControl.setBackground(Color.YELLOW);
		contentPane.add(pnlControl, BorderLayout.NORTH);
		
		pnlControl.add(box);
		pnlControl.add(btnCreate);
		pnlControl.add(btnClear);
		contentPane.add(pnlAction,BorderLayout.CENTER);
		pnlAction.setBorder(new LineBorder(new Color(0,0,0),3));
		pnlAction.setBackground(Color.WHITE);
		
		
		
		
		ActionListener taskPerformer = new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		    	    pnlAction.repaint();
		      }
		  };
		// 时间触发器用于动画。
		int delay = 10; 
		new Timer(delay, taskPerformer).start(); 
		
		  
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type = (String) box.getSelectedItem();
				ABall ball = view.Dispatcher.loadBall(type);
				Dispatcher.ballDispatcher.addObserver(ball);
				
			}
		});
		
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dispatcher.ballDispatcher.deleteObservers();
			}
		});
		
		
	}

}


