package ass_4;

import java.util.LinkedList;

/*
 * A class of entry object. it is node of a bucket.
 * 
 * @author:  Zuyi Ding
 */
public class CourseDBElement implements Comparable {
    
    private String courseID;
    private int CRN;
    private int credits;
    private String roomNumber;
    private String instructorName;    
    CourseDBElement next;
   
         
    // Default constructor
    public CourseDBElement() {
	
    }
    
    // Constructor for one parameter CRN
    public CourseDBElement(int crn) { 
	this.CRN = crn;
    }
    
    // Copy constructor for all parameters
    public CourseDBElement(String id, int c, int t, String n, String s) {
	courseID = id;
	CRN = c;
	credits = t;
	roomNumber = n; 
	instructorName =  s;
    }
    
    // Sets courseID
    public void setCourseID(String id) {
	courseID = id;
    }
    
    // Returns courseID
    public String getCourseID() {
	return courseID;
    }
    
    // Set CRN
    public void setCRN(int cn) {
	CRN = cn;
    }
    
    // Returns CRN
    public int getCRN() {
	return CRN;
    }
    
    // Sets credits
    public void setCredits(int n) {
	credits = n;
    }
    
    // returns credits
    public int getCredits() {
	return credits;
    }
    
    // set roomNumber
    public void setRoomNumber(String s) {
	 roomNumber = s;
    }
    
    // Returns roomNumber
    public String getRoomNumber() {
	return roomNumber;
    }
    
    // set insructorName
    public void setInstructorName(String name) {
	instructorName = name;
    }
    
    // Returns instructorName
    public String getInstructorname() {
	return instructorName;
    }
    
   // Returns a result of compareTo
    @Override
    public int compareTo(CourseDBElement element) {
	int result = 0;
	
	return result;
    }
    
    // toString method to display contents of instance
    public String toString() {
	
	String result = "";
	
	result = "\nCourse:" + courseID + " CRN:" + CRN + " Credits:" + credits 
		 + " Instructor:" + instructorName + " Room:" + roomNumber;
	return result;
    }
    
 }
