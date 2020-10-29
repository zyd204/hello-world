package ass_4;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 * This class is a client version to act on CourseDBStructure.
 * 
 * @author Student Zuyi Ding
 */

public class CourseDBManager implements CourseDBManagerInterface{
    
    CourseDBStructure CDS = new CourseDBStructure(20); 
    
    ArrayList<String> CDBFile = new ArrayList<>();
    
    public CourseDBManager() {
	CDBFile = new ArrayList<>();
    }

   // Adds a record to the hash table
    @Override
    public void add(String id, int crn, int credits, 
	            String roomNum, String instructor) { 
	        	    
	
	CourseDBElement CDE1 = new CourseDBElement(id, crn, credits, 
		                    roomNum, instructor);
	
	CDS.add(CDE1);
	
   }

    // Retrieve a specified record from hash table
    @Override
    public CourseDBElement get(int crn) {
	
	CourseDBElement node = new CourseDBElement(crn); 
	try {
	    // call get method of COurseDBStructure
	    node = CDS.get(crn);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	return node;
    }

    // Reads an input file
    @Override
    public void readFile(File input) throws FileNotFoundException {
		
	Scanner readFile = new Scanner(input);
	
	
	while (readFile.hasNext()) {
	    String line = readFile.nextLine();
	    CDBFile.add(line);
	}
	readFile.close();
	
	Scanner newRead = new Scanner(input);
	while (newRead.hasNext()) {
	    String line = newRead.nextLine();
	    String[] detail = line.split(" ");
	    String s1 = detail[0];
	    int d2 = Integer.parseInt(detail[1]);
	    int d3 = Integer.parseInt(detail[2]);
	    String s4 = detail[3];
	    String s5 = detail[4];
	    String s6 = detail[5];
	
	   String dName = s5 + " " + s6;
	   
	   CourseDBElement e1 = new CourseDBElement(s1, d2, d3, s4, dName);
	    CDS.add(e1);
	}
	
	newRead.close();
	

	
    }

    // Returns an ArrayList contains records from hash table
    @Override
    public ArrayList<String> showAll() {
	
	CourseDBElement item = new CourseDBElement();
	
	ArrayList<String> result = new ArrayList<>();
	
	for (int i = 0; i < CDS.size; i++) {
	   item =  CDS.hashTable[i];
	   while (item != null) {
	         result.add(CDS.hashTable[i].toString());
	         item = item.next;
	   }
	}
	

	return result;
    }

}
