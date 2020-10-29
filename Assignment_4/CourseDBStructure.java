package ass_4;

import static org.junit.Assert.assertThrows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The structure of this class is a hash table with buckets.
 * 
 * @author Student Zuyi Ding
 */
public class CourseDBStructure implements CourseDBStructureInterface{
    
    int size;
    String test;
    CourseDBElement[] hashTable;  //  hash table Linked list
    int recordCount;
 
 
    // Default constructor
    public CourseDBStructure() {  
	
    }
    
    // Copy constructor to accept one arguments
    public CourseDBStructure(int i) {
	size = i;  
	hashTable = new CourseDBElement[size];
	recordCount = 0;
	
    }
    
    // Copy constructor to accept two arguments
    public CourseDBStructure(String s, int i) {
	test = s;
	size = i;
	hashTable = new CourseDBElement[size];
	recordCount = 0;
    }
    
    // Creates CDE hash code. If CDE is not in hashTable,
    // adds it in.
    @Override
    public void add(CourseDBElement element) {
		
	Integer crn = element.getCRN();  // get course number
	
	int hashcode = crn.hashCode(); // get a hash code based on crn
	
	int index = hashcode % size;
	if (index < 0)
	    index += size;
	
	
	CourseDBElement node = element;
	// if it is empty bucket, adds it in.
	if (hashTable[index] == null)
	    hashTable[index] = node;
	else { // if not empty, adds it to the front of the bucket
	    node.next = hashTable[index];  
	    hashTable[index] = node;
	}
	
  }

   // If find the node looking for, return it; otherwise, return null
    @Override
    public CourseDBElement get(int crn) throws IOException {
	
	CourseDBElement result;
	
	int index;
	Integer crnI = crn;
	
	int hashcode = crnI.hashCode(); // get a hash code based on crn
	
	index = (hashcode & 0X7fffffff)  % size; // gets an index
	
	
	CourseDBElement nodeF = hashTable[index]; // set the first node
	
	CourseDBElement nodeL = nodeF;  // 
	if (nodeF.getCRN() == crn)
	  result = nodeF;
	else {
	    while (nodeL.next != null && nodeL.getCRN() != crn)
		nodeL = (CourseDBElement) nodeL.next;
	    
	    result = nodeL; // if no match, return null; otherwise, 
	    		    // return found node.
	}
	
	hashTable[index] = nodeF; // reset to the head position
	
	return result;
    }

    // Returns the size of hash table
    @Override
    public int getTableSize() {
	
	return size; 
    }
    
}
