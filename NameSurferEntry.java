/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import acm.util.*;
import java.util.*;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class NameSurferEntry implements NameSurferConstants {
 /* private instance variables */
	private String BabyName;
	private ArrayList<Integer> Birth_rate;
/* Constructor: NameSurferEntry(line) */
/**
 * Creates a new NameSurferEntry from a data line as it appears
 * in the data file.  Each line begins with the name, which is
 * followed by integers giving the rank of that name for each
 * decade.
 */
	public NameSurferEntry(String line) {
		// You fill this in //
		
		ProcessLine(line);
		}
		
		private void ProcessLine(String line) {
			Scanner lineScanner=new Scanner(line);
			BabyName=lineScanner.next();
			Birth_rate=new ArrayList<Integer>();
			while (lineScanner.hasNextInt()) {
				
			       Birth_rate.add(lineScanner.nextInt());
			       
			    }
			
		
			lineScanner.close();}
			

/* Method: getName() */
/**
 * Returns the name associated with this entry.
 */
	public String getName() {
		// You need to turn this stub into a real implementation //
		
		return BabyName;
	}

/* Method: getRank(decade) */
/**
 * Returns the rank associated with an entry for a particular
 * decade.  The decade value is an integer indicating how many
 * decades have passed since the first year in the database,
 * which is given by the constant START_DECADE.  If a name does
 * not appear in a decade, the rank value is 0.
 */
	public int getRank(int decade) {
		// You need to turn this stub into a real implementation //
		
		return Birth_rate.get(decade);
		
	}

/* Method: toString() */
/**
 * Returns a string that makes it easy to see the value of a
 * NameSurferEntry.
 */
	public String toString() {
		// You need to turn this stub into a real implementation //
		StringBuilder builder = new StringBuilder();
		builder.append("\""+BabyName+ " [");
		for (Integer element : Birth_rate) 
		{
			builder.append(element+" ");
		}
		builder.append("]"+"\"");
		String entry=builder.toString();
		return entry;
	}
}

