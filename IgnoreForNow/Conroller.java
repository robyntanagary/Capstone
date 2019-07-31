/*
 * Class represents a thread that grows trees for multiple simulation years.
 * @author FYTTAN001
 */

import java.util.concurrent.ForkJoinPool; //ForkJoinPool will be used to execute and manage threads.
import java.lang.Thread;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException; 

public class ControllerThread extends Thread implements ActionListener
{
    
	public void run()
	{
	}
    
	public void actionPerformed(ActionEvent e)
        	{
		e.getActionCommand();
        	}
}
