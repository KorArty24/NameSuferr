/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends Program implements NameSurferConstants {

/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the bottom of the window.
 */
	public void init() {
	    // You fill this in, along with any helper methods //
		
		textField = new JTextField("", N_COLNS);
		 textField.addActionListener(this);
		 add(new JLabel("Name"),SOUTH);
		 add(textField,SOUTH);
		 add(new JButton ("Graph"),SOUTH);
		 add(new JButton ("Clear"), SOUTH);
		 textField.setActionCommand("Graph");
		 lastY=0;
		 graph=new NameSurferGraph();
		 add(graph);
		 addActionListeners();
		 baby_names = new NameSurferDataBase(NAMESDB);
	}

/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		// You fill this in //
		String cmd= e.getActionCommand();
		if (cmd.equals("Graph")){
			String entered_name=textField.getText();
			NameSurferEntry rankings=baby_names.findEntry(entered_name);
	
	
			if (rankings!=null) {
				graph.addEntry(rankings);
				graph.update();
			}
				} 
		else if (cmd.equals("Clear")) {
					graph.clear();
					graph.update();
			}
		
	}

	/*Private instance variables*/
	private JTextField textField;
	private double lastY;
	private NameSurferGraph graph;
	private NameSurferDataBase baby_names;
	
	
	/*Constants*/
	private static final int LEFT_MARGIN=3;	
	private static final int N_COLNS=30;
	
}
