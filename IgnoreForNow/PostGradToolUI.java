//package treeGrow;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

public class PostGradToolUI {
	
	public static void setupGUI(int frameX,int frameY,) {
		Dimension fsize = new Dimension(800, 800);
		// Frame init and dimensions
    	JFrame frame = new JFrame("Applications to School of IT"); 
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setPreferredSize(fsize);
    	frame.setSize(800, 800);
    	
      	JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(g, BoxLayout.PAGE_AXIS)); 
      	panel.setPreferredSize(fsize);
 
	//Add buttons to panel	
	buttonReset.setActionCommand("reset");
	buttonReset.addActionListener(simulationThread);		

		
    	
      	frame.setLocationRelativeTo(null);  // Center window on screen.
      	frame.add(panel); //add contents to window
        frame.setContentPane(g);     
        frame.setVisible(true);
	}
	
		
	public static void main(String[] args) {
		//FYTTAN001: Run Swing code on Event Dispatch Thread, since most Swing methods are not "thread safe", but safely invoked when run on Event Driven Thread
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {setupGUI(frameX, frameY, sundata.trees);} //run setupGUI() code on Event Driven Thread
		}
		); 
	}	
}
