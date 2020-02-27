/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class NameSurferDataBase implements NameSurferConstants {


	
	private Map<String, NameSurferEntry> baby_names;
/* Constructor: NameSurferDataBase(filename) */
/**
 * Creates a new NameSurferDataBase and initializes it using the
 * data in the specified file.  The constructor throws an error
 * exception if the requested file does not exist or if an error
 * occurs as the file is being read.
 */
	public NameSurferDataBase(String filename) 
	{
		
		// You fill this in //
		try (Scanner in = new Scanner(new File(filename)))
		{	
					
			while (in.hasNextLine())
			{
				String line=in.nextLine();
				NameSurferEntry sline = new NameSurferEntry(line);
				baby_names.put(sline.getName(), sline);
			}
		}
		catch (IOException exception)
		{
			System.out.println("Could not open input file");
		}
	}
		
		
/* Method: findEntry(name) */
/**
 * Returns the NameSurferEntry associated with this name, if one
 * exists.  If the name does not appear in the database, this
 * method returns null.
 */
	public NameSurferEntry findEntry(String name) {
		// You need to turn this stub into a real implementation //
		
		return baby_names.get(name);
		
		}
		
	}


