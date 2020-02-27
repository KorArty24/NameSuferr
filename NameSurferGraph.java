/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import acm.util.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {
 
	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	public NameSurferGraph() {
		addComponentListener(this);
		DisplayedEntries= new ArrayList<NameSurferEntry>();
		
		//	 You fill in the rest //
	}
	
	/**
	* Clears the list of name surfer entries stored inside this class.
	*/
	public void clear() {
	 DisplayedEntries.clear();
	 
		//	 You fill this in //
	}
	
	/* Method: addEntry(entry) */
	/**
	* Adds a new NameSurferEntry to the list of entries on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/
	public void addEntry(NameSurferEntry entry) {
		DisplayedEntries.add(entry);
	}
	
	
	
	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the list of entries. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
	public void update() {
		//	 You fill this in //
		removeAll();
		buildMesh();
		addLabels();
		buildGraph();
		
		
	}
	private void buildMesh(){
		double x=0;
			for (int i=0;i<=(NDECADES+1);i++) {
			x=getWidth()/(NDECADES+1)*i;
			GLine v_separator = new GLine(x,0,x,getHeight());
			add(v_separator);
			
			}
		 	
		add(new GLine(0,BOTTOM_DIST,getWidth(),BOTTOM_DIST));
		add(new GLine(0,getHeight()-BOTTOM_DIST,getWidth(), getHeight()-BOTTOM_DIST));
	}
	
	private void addLabels(){
		int year_label$num=1890;
		double x=0;
		
		for (int i=0;i<(1+NDECADES);i++) {
			year_label$num=START_DECADE+10*i;
			String year_label=Integer.toString(year_label$num);
			x=i*(getWidth()/(NDECADES+1));
			add(new GLabel(year_label,x,getHeight()-5));
		}
		
	}
	private void buildGraph() {
	
		
		if (DisplayedEntries.size()>=0) {
			for (int i=0;i<DisplayedEntries.size(); i++) {
				NameSurferEntry entries=DisplayedEntries.get(i);
				int k=i;
				if (i>5) k=i%5;
				drawEntry(entries,k);
				}
			}
		}
				
	private void drawEntry(NameSurferEntry entry, int t) {
		

	double x0=-getWidth() / (NDECADES+1);
	double x1=getWidth() / (NDECADES+1);
	
	for (int i=0; i<12;i++) {
		
		double height=getHeight();
		double scale_y=getHeight()/MAX_RANK;
		double y0=GRAPH_MARGIN_SIZE+entry.getRank(i)*(scale_y);
		double y1=GRAPH_MARGIN_SIZE+entry.getRank(i+1)*(scale_y);
		x0=getWidth()/(NDECADES+1)*(i);
		x1=getWidth()/(NDECADES+1)*(i+1);
		GLine graph =new GLine(x0,y0,x1,y1);	
		
		graph.setColor(Colors[t]);
		add(graph);
		
		}
		
		
					}
				
			
/*Miseleneous variables*/
	
	
	
	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
	private ArrayList<NameSurferEntry> DisplayedEntries ;
	private Color[] Colors={Color.RED,Color.RED,Color.GREEN,Color.BLUE,Color.MAGENTA,Color.BLACK};
	private Map <Integer,Color> GraphColors=new HashMap<>();
}
